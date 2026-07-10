package com.kh.spring11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.CountryDto;

@Repository
public class CountryDaoMybatis implements CountryDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int sequence() {
		return 0;
	}

	@Override
	public void insert(CountryDto countryDto) {
		
	}

	@Override
	public boolean update(CountryDto countryDto) {
		return false;
	}

	@Override
	public boolean delete(int countryNo) {
		return false;
	}

	@Override
	public CountryDto selectOne(int countryNo) {
		return null;
	}

	@Override
	public List<CountryDto> selectList(int lastCountryNo, int size) {
		return null;
	}

	@Override
	public int count(int lastCountryNo) {
		return 0;
	}
	
	

}
