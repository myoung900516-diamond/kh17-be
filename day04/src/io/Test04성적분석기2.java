package io;


public class Test04성적분석기2 {
	public static void main(String[] args) {
		
		//입력
		int score1 = 84;
		int score2 = 93;
		int score3 = 38;
		

		
		//처리
		int total = score1 + score2 + score3;
		float average = (float)total/3;
		boolean pass = score1>= 40 && score2>= 40 && score3>= 40 && average>=60;
		
		//출력
		System.out.println("평균점수 : " + average + "점");		
		System.out.println("결과 : " + pass);
		
	}

}
