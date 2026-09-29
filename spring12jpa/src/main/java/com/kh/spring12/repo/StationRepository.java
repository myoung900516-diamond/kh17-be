package com.kh.spring12.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kh.spring12.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long>{
	//여기만 해도 기본명령은 이미 존재


	
	
	//역 전체 조회
	//역 번호 오름차순
	List<Station> findAllByOrderByStationNoAsc();
	
	//호선번호 검색
	//역번호 오름차순
	List<Station> findBySubwayLineOrderByStationNoAsc(String subwayLine);
	
	//역번호로 단일 검색
	Optional<Station> findByStationNo(Long stationNo);

	List<Station> findByLocationContainingOrderByStationNoAsc(String keyword);
	
	//수정 메소드 (JPQL)구현
	//-주의사항 : 수정메소드를 만들 때 등록, 수정, 삭제처럼 데이터베이스가 변하는 작업은 
	//@Query + @Modifying 표시가 필요(@Query만 쓰면 조회처럼 처리하려고 함)
	//- 파라미터가 원시형이면 콜론 혹은 ?를 이용해서 네이밍 바인딩 또는 시퀀스 바인딩 모두가 가능 (:stationName 또는 ?1)
	//- 파라미터가 객체라면 :#{#객체명.필드명}으로 사용해야 한다
	//- 이렇게 구현하면 @UpdateTimestamp가 자동 갱신되지 않음(수동으로 처리해야함, JPQL의 CURRUNT_TIMESTAMP값 사용)
	@Modifying
	@Query("""
			update 	Station s
			set 	s.stationName = :#{#station.stationName}, 
					s.location = :#{#station.location}, 
					s.stationUtime = CURRENT_TIMESTAMP
			where 	s.stationNo = :#{#station.stationNo}
			""")
	int updateStation(Station station);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
