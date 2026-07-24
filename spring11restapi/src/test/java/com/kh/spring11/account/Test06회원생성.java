package com.kh.spring11.account;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.service.RandomService;

@SpringBootTest
public class Test06회원생성 {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private RandomService randomService;
	
	@Test
	public void test() {
		Random r = new Random();
		List<String> addrList = List.of(
				"서울특별시 강남구 역삼동","서울특별시 강남구 삼성동","서울특별시 강남구 논현동","서울특별시 강남구 청담동","서울특별시 서초구 서초동","서울특별시 서초구 반포동","서울특별시 서초구 잠원동","서울특별시 송파구 잠실동","서울특별시 송파구 문정동","서울특별시 송파구 가락동","서울특별시 마포구 서교동","서울특별시 마포구 합정동","서울특별시 마포구 연남동","서울특별시 마포구 공덕동","서울특별시 영등포구 여의도동","서울특별시 영등포구 당산동","서울특별시 영등포구 문래동","서울특별시 용산구 이태원동","서울특별시 용산구 한남동","서울특별시 성동구 성수동","부산광역시 해운대구 우동","부산광역시 해운대구 좌동","부산광역시 수영구 광안동","부산광역시 부산진구 부전동","부산광역시 동래구 명륜동","대구광역시 수성구 범어동","대구광역시 수성구 만촌동","대구광역시 중구 동성로","인천광역시 연수구 송도동","인천광역시 남동구 구월동","인천광역시 부평구 부평동","광주광역시 서구 치평동","광주광역시 북구 용봉동","대전광역시 유성구 봉명동","대전광역시 서구 둔산동","울산광역시 남구 삼산동","세종특별자치시 새롬동","세종특별자치시 아름동","경기도 성남시 분당구 정자동","경기도 성남시 분당구 서현동","경기도 수원시 영통구 영통동","경기도 수원시 팔달구 인계동","경기도 용인시 수지구 죽전동","경기도 고양시 일산동구 장항동","경기도 고양시 일산서구 주엽동","경기도 안양시 동안구 평촌동","경기도 부천시 원미구 중동","경기도 화성시 동탄동","경상남도 창원시 성산구 상남동","제주특별자치도 제주시 연동"
				
		);
		
		for(int i=1; i <= 1000; i++) {
			accountDao.insert(AccountDto.builder()
						.accountId("dummyuser"+i)
						.accountPassword("DummyUser"+i+"!")
						.accountNickname("더미유저"+i)
						.accountEmail("dummy"+i+"@kh.com")
						.accountPost(randomService.generateNumber(
								r.nextInt(2) + 5
						))
						.accountAddress1(
								addrList.get(r.nextInt(addrList.size()))
						)
						.accountAddress2("000아파트 xxx동 ooo호")
					.build());
		}
	}

}
