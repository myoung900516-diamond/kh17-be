package jdbc.program;

import jdbc.dao.CountryDao;

public class Test04모듈화된국가정보삭제 {
	public static void main(String[] args) {
		//입력:기본키
		
		int countryNo = 30;
		
		CountryDao countryDao = new CountryDao();
		boolean success = countryDao.delete(countryNo);
		
		if(success) {
			System.out.println("도서정보삭제완료");
		}
		else {
			System.out.println("대상이 존재하지 않습니다");
		}
		
		
	}

}
