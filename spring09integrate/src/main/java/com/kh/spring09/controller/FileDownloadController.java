package com.kh.spring09.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring09.dao.AttachDao;
import com.kh.spring09.dto.AttachDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
	@Autowired
	private AttachDao attachDao;
	
	//레거시 다운로드 - Java EE의 객체들을 이용하여 다운로드를 설정
	@RequestMapping("/legacy")
	@ResponseBody
	public void legecy(@RequestParam int attachNo, 
						HttpServletResponse response) throws IOException {
		//전달된 attachNo에 해당하는 정보를 불러와서 파일과 조합하여 사용자에게 전송
		//1.정보 조회
		AttachDto attachDto = attachDao.selectOne(attachNo);
		if(attachDto == null) throw new TargetNotfoundException("존재하지 않는 파일");
		
		//2.파일조회
		File dir = new File("D:/upload");
		File target = new File(dir, String.valueOf(attachNo));
		if(!target.isFile()) throw new TargetNotfoundException("존재하지 않는 파일");
		
		//3.사용자에게 알려줄 다운로드 정보(헤더) 설정
		response.setHeader("Content-Encoding", "UTF-8");//내가 보낼 데이터의 표현방식
		response.setHeader("Content-Type", attachDto.getAttachTypeString());
		response.setHeader("Content-Length", String.valueOf(attachDto.getAttachSize()));
		StringBuffer sb = new StringBuffer();
		sb.append("attachment");
		sb.append(";");
		sb.append("filename=");
		sb.append("\"");
//		sb.append(attachDto.getAttachNo());
		sb.append(URLEncoder.encode(attachDto.getAttachName(), "UTF-8"));
		sb.append("\"");
		//브라우저를 벗어나 다운받게됨
		response.setHeader("Content-Disposition", sb.toString());
//		"attachment; filename="+attachDto.getAttachName());
//		response.setHeader("Content-Disposition", "inLine;"attachDto.getAttachName());
		
//		4. 실제 파일을 불러와서 사용자에게 전송
		FileInputStream stream = new FileInputStream(target);
		byte[] buffer = new byte[1024];
		
		while(true) {
			int size = stream.read(buffer);
			if(size == -1) break;
			response.getOutputStream().write(buffer, 0, size);
		}
		stream.close();
//		response.getOutputStream().write(파일데이터);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
