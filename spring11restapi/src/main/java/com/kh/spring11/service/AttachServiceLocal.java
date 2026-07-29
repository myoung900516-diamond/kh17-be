package com.kh.spring11.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dto.AttachDto;
import com.kh.spring11.error.TargetNotfoundException;

@Service
@Profile("local")//spring profile이 local일 때 활성화 되는 서비스
public class AttachServiceLocal implements AttachService{
	
	@Autowired
	private AttachDao attachDao;
	

	//파일 업로드는 [물리적인 저장] → [정보(메타데이터) 저장]
	public int save(MultipartFile attach) throws IllegalStateException, IOException{
			int attachNo = attachDao.sequence();
//			AttachDto attachDto = new AttachDto();
//			attachDto.setAttachNo(attachNo);
//			attachDto.setAttachName(attach.getOriginalFilename());
//			attachDto.setAttachType(attach.getContentType());
//			attachDto.setAttachSize(attach.getSize());
			attachDao.insert(
						AttachDto.builder()
							.attachNo(attachNo)
							.attachName(attach.getOriginalFilename())
							.attachType(attach.getContentType())
							.attachSize(attach.getSize())
						.build()
					);//db저장 
			
			
			
			
			//업로드된 파일을 저장하는 코드
			File dir = new File("D:/upload");
			dir.mkdirs();
//			File target = new File(dir, attach.getOriginalFilename());
			File target = new File(dir, String.valueOf(attachNo));
			attach.transferTo(target);//물리저장
			return attachNo;
		}
		//번호에 해당하는 파일을 지우고 DB정보도 삭제하도록 처리
		public void delete(int attachNo) {
			//정보가 있는지 먼저 확인
			AttachDto attachDto = attachDao.selectOne(attachNo);
			if(attachDto == null) throw new TargetNotfoundException("존재하지 않는 파일");
			
			attachDao.delete(attachNo);//DB 데이터 삭제
			
			File dir = new File("D:/upload");
			File target = new File(dir, String.valueOf(attachNo));
			target.delete();//파일 삭제 지시
		}


}
