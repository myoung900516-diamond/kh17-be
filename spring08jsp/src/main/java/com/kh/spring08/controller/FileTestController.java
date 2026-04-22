package com.kh.spring08.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.dao.AttachDao;
import com.kh.spring08.dto.AttachDto;

@Controller
@RequestMapping("/filetest")
public class FileTestController {
	@Autowired
	private AttachDao attachDao;
	
	@GetMapping("/uploadTest")
	public String uploadTest() {
		return "/WEB-INF/views/filetest/uploadTest.jsp";
	}
	//첨부파일을 받으려면 MultipartFile 이라는 형태를 사용해야 한다 
	@PostMapping("/uploadTest")
	public String uploadTest(@RequestParam String uploader, 
//										@RequestParam String attach) {
										@RequestParam MultipartFile attach) throws IOException {
		System.out.println("uploader = " + uploader);
//		System.out.println("attach = " + attach);
		System.out.println("파일명 = " + attach.getOriginalFilename());
		System.out.println("파일유형 = " + attach.getContentType());
		System.out.println("파일크기 = " + attach.getSize());
		//byte[] data = attach.getBytes();
		//System.out.println("데이터 = " + Arrays.toString(data));
		
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
		return "redirect:./uploadTest";
	}

}
