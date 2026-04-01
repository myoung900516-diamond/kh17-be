package jdbc.select;


//country 테이블의 한 줄을 보관할 클래스
//-필드 + setter/getter + 기본 생성자
//-toString()까지 생성
//-DTO (Data Transfer Object): 변환객체
public class CountryDto {
	//필드 : DB 컬럼명과 동일하게 구성
	private int countryNo;
	private String countryRegion;
	private String countryName;
	private String countryCapital;
	private long countryPopulation;
	public int getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(int countryNo) {
		this.countryNo = countryNo;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	public long getCountryPopulation() {
		return countryPopulation;
	}
	public void setCountryPopulation(long countryPopulation) {
		this.countryPopulation = countryPopulation;
	}
	public CountryDto() {
		super();
	}
	@Override
	public String toString() {
		return "CountryDto [countryNo=" + countryNo + ", countryRegion=" + countryRegion + ", countryName="
				+ countryName + ", countryCapital=" + countryCapital + ", countryPopulation=" + countryPopulation + "]";
	}
	
	
	

}
