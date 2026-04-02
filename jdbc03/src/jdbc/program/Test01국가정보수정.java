package jdbc.program;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test01국가정보수정 {
	public static void main(String[] args) {
		//입력 : CountryDto
		CountryDto countryDto = new CountryDto();
		//수정에 필요한 데이터 설정
		countryDto.setCountryNo(32);
		countryDto.setCountryRegion("아프리카");
		countryDto.setCountryName("남아프리카공화국");
		countryDto.setCountryCapital("케이프타운");
		countryDto.setCountryPopulation(630000000L);
		
		
		//처리: CountryDao
		CountryDao countryDao = new CountryDao();
		boolean success = countryDao.update(countryDto);
		
		
		
		//출력
		
		if(success) {
			System.out.println("국가 정보가 변경되었습니다");
		}
		else {
			System.out.println("대상이 존재하지 않습니다");
		}
	}

}
