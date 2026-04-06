package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.CountryDao;
import com.kh.spring06.dto.CountryDto;

@RestController//등록(제어 반전, IoC, Inversion of Control)
@RequestMapping("/country")//공용주소
public class CountryController {
	@Autowired//주세요!(의존성 주입,  DI, Dependency Injection)
//	private JdbcTemplate jdbcTemplate;
	private CountryDao countryDao;

	//country 등록을 위한 페이지 
	@RequestMapping("/insert")
	public String insert(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "국가 정보 등록이 완료되었습니다";
	}
	
	//country 수정을 위한 페이지 
	//일반적인 흐름 : 수정정보입력 → 수정처리 → 성공/실패 안내 
	@RequestMapping("/update")
	public String update(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		
		if(success) {
		return "국가 정보 변경이 완료되었습니다";
		}
		else {
			return "존재하지 않는 국가입니다";
		}
	}
		@RequestMapping("/delete")
		public String delete(@RequestParam int countryNo){
			boolean success = countryDao.delete(countryNo);
			if(success) {
			return "국가 정보 삭제가 완료되었습니다";
			}
			else {
			return "존재하지 않는 국가입니다";
			}
		}
		//country조회 매핑
		//1. 목록 및 검색(column, keyword 파라미터가 선택적으로 존재
		//2. 상세조회(기본키, primary key)
		@RequestMapping("/list")
		public String list(
				@RequestParam(required = false) String column, 
				@RequestParam(required = false) String keyword) {
				
				List<CountryDto> list = countryDao.selectList(column, keyword);
//				return list.toString(); 너무 성의없이 결과가 나옴 
				//StringBuffer를 이용해서 문자열로 만들어서 반환하겠다 (나중에 화면으로 바뀜)
				StringBuffer buffer = new StringBuffer();
				buffer.append("결과 수 : " + list.size());
				buffer.append("<br>");
				for(CountryDto countryDto : list) {
					buffer.append(countryDto);
					buffer.append("<br>");
				}
				return buffer.toString();
			
		}
		@RequestMapping("/detail")
		public String detail(@RequestParam int countryNo) {
			CountryDto countryDto = countryDao.selectOne(countryNo);
			if(countryDto == null) {
				return "존재하지 않는 국가 정보";
			}
			else {
				StringBuffer buffer = new StringBuffer();
				buffer.append("인구 : " + countryDto.getCountryNo() + "<br>");
				buffer.append("번호 : " + countryDto.getCountryRegion() + "<br>");
				buffer.append("대륙 : " + countryDto.getCountryName() + "<br>");
				buffer.append("이름 : " + countryDto.getCountryCapital() + "<br>");
				buffer.append("수도 : " + countryDto.getCountryPopulation() + "<br>");
				return buffer.toString();
			}
		}
		
	}

