package jdbc.dao;

import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.mapper.CountryMapper;
import jdbc.util.JdbcUtils;

//DAO(Data Access Object)
//-데이터에 접근하는 작업을 수행하는 객체
//-DB전담 클래스 (테이블마다 생성)
//-등록,수정,삭제,조회 등 자주 사용되는 DB작업들을 메소드로 보관 

public class CountryDao {
	
	//내가 일을 하려면 메소드가 필요
	//-등록메소드를 만들거에요. 
	//-등록 메소드 : [대륙, 국가명,수도명,인구수]를 받아서 DB등록 후 반환값은 없음
	//public 반환형 void 이름(매개변수) {}
	//매개변수가 뭔지 모르면 입력 다 지워서 에러나는 곳
	//처리부분 다 지워서 출력이 에러 안나면 void
	//public void insert(String countryRegion, String countryName,
	//		String countryCapital, long countryPopulation) {
	public void insert(CountryDto countryDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "insert into country(country_no, country_region, country_name, "
				+ "country_capital, country_population)"
				+ "values("
				+ "country_seq.nextval, ?, ?, ?, ?)";
//		Object[] params =  {countryRegion, countryName, 
//				countryCapital, countryPopulation};
		Object[] params =  {countryDto.getCountryRegion(), countryDto.getCountryName(),
									countryDto.getCountryCapital(), countryDto.getCountryPopulation()};
		jdbcTemplate.update(sql, params);
		
	}
	
	//수정메소드
	//-등록과 다르게 실행한 뒤 "진짜 수정이 되었는지를"알아야함
	//-반환형을 boolean으로 설정해서 이 결과를 판단해서 
	//내보내도록 처리 
//	public int update(int countryNo, String countryRegion, 
//			String countryName, String countryCapital,
//			long countryPopulation) {
	public boolean update(CountryDto countryDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update country "
				+ "		set country_region=?, country_name=? "
				+ "		country_capital=?, country_population=? "
				+ "		where country_no=? ";
		Object[] params = {
				countryDto.getCountryRegion(), 
				countryDto.getCountryName(), 
				countryDto.getCountryCapital(), 
				countryDto.getCountryPopulation(), 
				countryDto.getCountryNo()
		};
		int rows = jdbcTemplate.update(sql, params);
//		if(rows > 0)return true;
//		else return false;
		return rows > 0; //한줄로 표현 
	
		
		
	}
	
	//삭제 메소드 
	//-기본키(primary key)를 이용해서 삭제(매개변수가 기본키)
	//-반환형을 boolean으로 설정해서 진짜로 삭제되었는지 판정하여 반환 
	public boolean delete(int countryNo) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete country where country_no=?";
		Object[] params = {countryNo};
		return jdbcTemplate.update(sql, params) >0;
		
	}
	
	//조회 메소드
	//-CountryDto 목록 (List<CountryDto>을 반환하도록 구현
	public List<CountryDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from country order by country_no asc";
		//홀더없음
		CountryMapper mapper = new CountryMapper();
//		List<CountryDto> list = jdbcTemplate.query(sql, mapper);
//		return list;
		return jdbcTemplate.query(sql, mapper);
		
	}
	
	//검색메소드
	//-컬럼 + 키워드 검색
	//-반환해야할 데이터 형태는 목록과 동일
	public List<CountryDto> selectList(String column, String keyword){
//		if(데이터가 부족하면) return 목록;
//		if(column == null || keyword == null) return this.selectList(); //column.equals(null); 이것은 잘못된 코드 
		if(column == null || keyword == null) return List.of(); //검색항목이 없으면 비어있는 결과반환 
		
		Set<String> allowList = Set.of("country_region", "country_name", "country_capital");
		if(allowList.contains(column) == false) return List.of();//허용되는 검색항목이 아니면 비어있는 결과 반환
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from country where instr("+column+", ?) >0 order by country_no asc";
		Object[] params = {keyword};
		CountryMapper countryMapper = new CountryMapper();
		return jdbcTemplate.query(sql, countryMapper, params);//(주의)홀더는 맨 마지막!!!! 
	}
	
	//상세메소드
	//-기본키(primary key)를 이용하여 단 하나의 데이터만 찾는 검색(없을 수는 있음)
	public CountryDto selectOne(int countryNo) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from country where country_no= ?";
		Object[] params = {countryNo};
		CountryMapper countryMapper = new CountryMapper();
		//return jdbcTemplate.query(sql, countryMapper, params); // 안되는 코드 
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params); //일단 목록으로조회하고 
		
		return list.isEmpty() ? null : list.get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

