package api.string2;

public class Test02아이디검사2 {
	public static void main(String[] args) {
		String id = "다이아몬드1234";
		
		String regex = "^[가-힣0-9]{1,10}$";//닉넴조건식 //한글과 숫자로만 가능하며 10글자 이내로 작성해야함 /				ㅋㅋㅋ나 ㅡㅡ 같은 자모음은 포함시킬 수 없음
		
		boolean valid = id.matches(regex);
		if(valid) {
			System.out.println("멋진 아이디입니다!");
		}
		else {
			System.out.println("영문 소문자로 시작하며 5~20자의 영문 소문자, 숫자만 사용 가능합니다");
		}
	}

}
