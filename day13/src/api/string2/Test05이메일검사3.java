package api.string2;

import java.util.Scanner;

public class Test05이메일검사3 {
	public static void main(String[] args) {
		

		String email = "testuser1@a.com";
		//'@' 좌측 : ^[a-z][a-z0-9]{4,19}$
		//'@' 우측 : ^[A-Za-z0-9-.]{1,}.[A-Za-z0-9]{2,}$
		String regex = "^[a-z][a-z0-9]{4,19}@[A-Za-z0-9-.]{1,}.[A-Za-z0-9]{2,}$";
		boolean valid = email.matches(regex);
		System.out.println(valid);
		
	}

}
