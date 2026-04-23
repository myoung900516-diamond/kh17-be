package com.kh.spring09.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.AttachDao;
import com.kh.spring09.dto.AttachDto;
import com.kh.spring09.exception.TargetNotfoundException;

//서비스: 하나의 단위작업을 구현하기 위한 도구
@Service
public class AttachService {
	@Autowired
	private AttachDao attachDao;
	
	//서비스는 매소드의 정해진 형태가 없다 
	public int save(MultipartFile attach) throws IllegalStateException, IOException{
		int attachNo = attachDao.sequence();
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(attachNo);
		attachDto.setAttachName(attach.getOriginalFilename());
		attachDto.setAttachType(attach.getContentType());
		attachDto.setAttachSize(attach.getSize());
		attachDao.insert(attachDto);
		
		//업로드된 파일을 저장하는 코드
		File dir = new File("D:/upload");
		dir.mkdirs();
//		File target = new File(dir, attach.getOriginalFilename());
		File target = new File(dir, String.valueOf(attachNo));
		attach.transferTo(target);
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
