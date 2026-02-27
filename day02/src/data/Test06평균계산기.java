package data;

public class Test06평균계산기 {
	public static void main(String[] args) {
		
		
		int koreanScore = 50;
		int englishScore = 65;
		int mathScore = 70;
		
		int totalScore = koreanScore + englishScore + mathScore;
		//float averageScore = totalScore/subject;
		double averageScore = (double) totalScore / 3; //변환연산(cast) 이게 젤 많이 쓰임. 
		
		
		
		System.out.println(totalScore);
		System.out.println(averageScore);
		//소수점 두가지수만 보여주고 싶다면, 그 내용은 뒤에 나옴. 
		
		
		/*int subject = 3;
		int koreanScore = 50;
		int englishScore = 65;
		int mathScore = 70;
		
		int totalScore = koreanScore + englishScore + mathScore;
		int average = totalScore/subject;
		int averageRemain = totalScore%subject;
		
		System.out.println(totalScore);
		System.out.println(average + "." + averageRemain);
		*/
		
	}

}
