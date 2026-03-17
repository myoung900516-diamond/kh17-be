package api.string2;

public class Test02아이디검사 {
	public static void main(String[] args) {
		String id = "testuser1234";
		
		String regex = "^[a-z0-9][a-z0-9]{4,19}$";//앞으로 사용할 형식(알파벳소문자 시작+ 숫자포함 5~20자)
		
		boolean valid = id.matches(regex);
		if(valid) {
			System.out.println("멋진 아이디입니다!");
		}
		else {
			System.out.println("영문 소문자로 시작하며 5~20자의 영문 소문자, 숫자만 사용 가능합니다");
		}
	}

}
