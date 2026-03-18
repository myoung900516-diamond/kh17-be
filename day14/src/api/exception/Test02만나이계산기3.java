package api.exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02만나이계산기3 {
	public static void main(String[] args) {
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("생년월일을 입력하세요");
		String birth = sc.nextLine();
		
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(((02)-(0[1-9]|1[0-9]|2[0-8]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$";
		boolean valid = birth.matches(regex);
		
		if(!valid) {
			throw new Exception();
			}
		else {
		int year = Integer.parseInt(birth.substring(0, 4));
		
		int y2 =LocalDate.now().getYear() - year;
		
		int month = Integer.parseInt( birth.substring(5, 7));
		int m2 = LocalDate.now().getMonthValue() - month;
		int m = y2*12 + m2;
		
		int y3 = m/12;
		System.out.println("만나이 : " + y3 + "세");
				}
			}
		catch(Exception e ) {
			System.out.println("입력이 잘못 되었습니다.");
				}
	}


}
