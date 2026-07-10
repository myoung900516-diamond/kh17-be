package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.CountryDto;

public interface CountryDao {

	//interface는 무조건 public
	
	int sequence();
	//추상메소드
	void insert(CountryDto countryDto);
	boolean update(CountryDto countryDto);
	boolean delete(int countryNo);
	CountryDto selectOne(int countryNo);
	List<CountryDto> selectList(int lastCountryNo, int size);
	int count(int lastCountryNo);
	List<CountryDto> searchByCountryName(String keyword);
	
}
