package api.exception;

public class DateCalculator {
	private DateCalculator() {}
	
	public static boolean checkValid(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
		
		String regex;
		if(leap) {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$";//통합
		}
		else {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((02)-(0[1-9]|1[0-9]|2[0-8]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$";//통합
		}
		
		boolean valid = date.matches(regex);
		return valid;
	}
}
