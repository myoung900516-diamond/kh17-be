package jdbc.program;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test08모듈화된국가목록검색 {
	public static void main(String[] args) {
//		String column = "country_name";//검색으로 처리
//		String keyword = "시아"; //검색으로 처리
		String column = null; //목록으로 처리하거나 차단 등 다른 작업을 하도록 지시
		String keyword = null;//목록으로 처리하거나 차단 등 다른 작업을 하도록 지시
		
		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList(column, keyword);
		
		System.out.println(list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
	}

}
