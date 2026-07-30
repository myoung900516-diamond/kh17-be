package com.kh.spring11.vo.attach;

import org.springframework.core.io.Resource;

import com.kh.spring11.dto.AttachDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//내부적으로 쓰는 것 schema안달아도됨
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AttachInfoVO {

	private AttachDto attachDto;
	private Resource resource;
}
