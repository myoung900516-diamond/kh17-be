package api.exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02만나이계산기4 {
	public static void main(String[] args) {
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("생년월일을 입력하세요");
		String birth = sc.nextLine();
		
		boolean valid = DateCalculator.checkValid(birth);
		
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
