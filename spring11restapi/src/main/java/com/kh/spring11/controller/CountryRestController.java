package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.dao.CountryDao;
import com.kh.spring11.dto.CountryDto;
import com.kh.spring11.error.TargetNotfoundException;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="국가API", description ="국가 CRUD를 위한 API입니다")
@CrossOrigin
@RestController
@RequestMapping("/api/country")
public class CountryRestController {

	@Autowired
	private CountryDao countryDao;
	//등록
	@PostMapping("/")
	public CountryDto insert(@RequestBody CountryDto countryDto) {
		int countryNo = countryDao.sequence();
		countryDto.setCountryNo(countryNo);
		countryDao.insert(countryDto);
		return countryDto;
		
	}
	//조회
	@GetMapping("/")
	public List<CountryDto> list(){
		return countryDao.selectList(1, Integer.MAX_VALUE);
	}
	//상세 : PK를 경로 변수로 받음
	@GetMapping("/{countryNo}")
	public CountryDto find(@PathVariable int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) throw new TargetNotfoundException();
		return countryDto;
	}
	//삭제
	@DeleteMapping("/{countryNo}")
	public CountryDto delete(@PathVariable int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) throw new TargetNotfoundException();
		countryDao.delete(countryNo);
		return countryDto;//삭제한 데이터 정보
	}
	
	//전체정보 수정
	@PutMapping("/{countryNo}")
	public CountryDto updateAll(@RequestBody CountryDto countryDto, 
						 @PathVariable int countryNo) {
		CountryDto findCountryDto = countryDao.selectOne(countryNo);
		if(findCountryDto == null) throw new TargetNotfoundException();
		countryDto.setCountryNo(countryNo);
		countryDao.update(countryDto);
		return countryDto;
	}
	
	//일부정보 수정
	@PatchMapping("/{countryNo}")
	public CountryDto updateUnit(@RequestBody CountryDto countryDto, 
								@PathVariable int countryNo) {
		//countryDto에 뭐가 있을지 모름
		//일단 countryNo로 원본을 조회해서countryDto에 있는 정보만 복사한 뒤 변경
		CountryDto findCountryDto = countryDao.selectOne(countryNo);
		if(findCountryDto == null) throw new TargetNotfoundException();
		
		//countryDto에 존재하는 항목들을 findCountryDto에 복사
		if(countryDto.getCountryRegion() != null) {
			findCountryDto.setCountryRegion(countryDto.getCountryRegion());
		}
		if(countryDto.getCountryName() != null) {
			findCountryDto.setCountryName(countryDto.getCountryName());
		}
		if(countryDto.getCountryCapital() != null) {
			findCountryDto.setCountryCapital(countryDto.getCountryCapital());
		}
		if(countryDto.getCountryPopulation() > 0L) {
			findCountryDto.setCountryPopulation(countryDto.getCountryPopulation());
		}
		countryDao.update(findCountryDto);
		return findCountryDto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
