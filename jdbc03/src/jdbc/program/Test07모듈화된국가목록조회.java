package jdbc.program;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test07모듈화된국가목록조회 {
	public static void main(String[] args) {
		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList();
		
		//출력
		System.out.println(list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
	}

}
