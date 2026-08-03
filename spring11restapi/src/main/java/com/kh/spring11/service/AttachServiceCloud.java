package com.kh.spring11.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.configuration.StorageProperties;
import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dto.AttachDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.attach.AttachInfoVO;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Slf4j
@Service
@Profile("cloud")
public class AttachServiceCloud implements AttachService{
	
	@Autowired
	private AttachDao attachDao;
	@Autowired
	private S3Client s3Client;
	@Autowired
	private StorageProperties storageProperties;

	@Transactional
	@Override
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		
		int attachNo = attachDao.sequence();
		attachDao.insert(
					AttachDto.builder()
						.attachNo(attachNo)
						.attachName(attach.getOriginalFilename())
						.attachType(attach.getContentType())
						.attachSize(attach.getSize())
					.build()
				);//db저장 
		
		//[1]AWS S3전용 클라이언트 생성(이미 만들었으니 생략)
				
								
				//[2] 업로드할 파일명과 내용을 준비 
				String objectKey = storageProperties.getAwsRoot()+"/"+attachNo;
				
				//[3]업로드 요청(PutObjectRequest)을 보낼 요청객체, 응답객체를 준비하여 실행
				PutObjectRequest request = PutObjectRequest.builder()
							.bucket(storageProperties.getAwsBucket())
							.key(objectKey)
							//(주의)세미콜론 있어야함
							.contentType(attach.getContentType()+"; charset=UTF-8")
						.build();
				
				PutObjectResponse response = s3Client.putObject(
						request,
						RequestBody.fromBytes(
//								content.getBytes(StandardCharsets.UTF_8)//문자열을 바이트[]
								attach.getBytes()//업로드된 파일
						)
				);
				
				
				log.debug("업로드성공");
				log.debug("객체키={}", objectKey);
				log.debug("ETag ={}", response.eTag());
				
		return attachNo;
	
		
	}

	@Transactional
	@Override
	public void delete(Integer attachNo) {
		if(attachNo == null) return;
		
		//DB정보 삭세
		attachDao.delete(attachNo);
		//AWS에서 파일 삭제요청
		//삭제 요청은 DeleteObjectRequest, DeleteObjectReponse로 처리
				String objectKey = storageProperties.getAwsRoot()+"/"+attachNo;//지울 대상의 경로
				
				DeleteObjectRequest request = DeleteObjectRequest.builder()
						.bucket(storageProperties.getAwsBucket())
						.key(objectKey)
					.build();
				
				DeleteObjectResponse response = s3Client.deleteObject(request);
				
				log.debug("<AWS 파일 삭제 완료>");
				log.debug("HTTP status = {} ", response.sdkHttpResponse().statusCode());
	}

	@Override
	public AttachInfoVO load(int attachNo) throws Exception {
		//[1]정보 조회
		AttachDto attachDto = attachDao.selectOne(attachNo);
		if(attachDto == null)throw new TargetNotfoundException();
		
		//AWS S3에서 파일 불러오기
		//1. 실제로 파일을 다운로드 받아서 불러오는 것 -경우에 따라서 (압축하거나 검사를 해야할 때)
		//2. 파일에 접근할 수 있는 임시 URL을 발급받는 것 (Presigned URL) - 권장
		//3. 파일에 접근할 수 있는 영구적인 URL을 반환하는 것 (절대 쓰면 안됨)
		
		//1번 코드
		String objectKey = storageProperties.getAwsRoot()+"/"+attachNo;
		
		GetObjectRequest request = GetObjectRequest.builder()
				.bucket(storageProperties.getAwsBucket())
				.key(objectKey)
			.build();
		
		//byte로 추출(in-memory방식)
		ResponseInputStream<GetObjectResponse> stream =  s3Client.getObject(request);
		
		
		GetObjectResponse response = stream.response();
		
		log.debug("Content-Type={}", response.contentType());
		log.debug("Content-Length={}", response.contentLength());
		log.debug("ETag={}", response.eTag());
		
		byte[] data = stream.readAllBytes();
		//[3]실제 파일 데이터를 불러와서 Resource형태로 포장
		Resource resource = new ByteArrayResource(data);
		
		stream.close();//이게 없으면 어느순간 서버가 마비가됨. 
		
		//[4]조회 결과를 포장해서 반환
		return AttachInfoVO.builder()
					.attachDto(attachDto)
					.resource(resource)
				.build();
	}

}
