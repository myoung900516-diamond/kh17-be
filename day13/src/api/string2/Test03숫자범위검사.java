package api.string2;

public class Test03숫자범위검사 {
	public static void main(String[] args) {
		//문자열이지만 "숫자"형태로 작성된 값의 범위 검사가 가능한가? 
		
		//다음과 같이 문자열 형태로 주어진 점수가 올바른 범위(0~100)인지 검사하려면?
		String score = "100";
		
		String regex = "검사식";
		
		boolean valid = score.matches(regex);
		System.out.println("valid = " + valid);
	}

}
