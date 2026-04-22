package com.kh.spring08.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.dao.AttachDao;
import com.kh.spring08.dto.AttachDto;

//서비스: 하나의 단위작업을 구현하기 위한 도구
@Service
public class AttachService {
	@Autowired
	private AttachDao attachDao;
	
	//서비스는 매소드의 정해진 형태가 없다 
	public void save(MultipartFile attach) throws IllegalStateException, IOException{
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
	}

}
