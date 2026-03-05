package loop;

public class Test04삼육구게임 {
	public static void main(String[] args) {
		
			for( int i = 1 ; i <= 99; i += 1) {
				
				boolean thirty = i / 10 == 3; boolean three = i % 10 == 3;
				boolean sixty = i / 10 == 6; boolean six = i % 10 == 6;
				boolean ninety = i / 10 == 9; boolean nine = i % 10 == 9;
				boolean match = thirty || three || sixty || six || ninety || nine;
				//boolean doubleMatch = thirty && three;
				//boolean doubleMatch2 = sixty && six;
				//boolean doubleMatch3 = ninety && nine;
						//; boolean match2 = sixty || six; boolean match3 = ninety || nine;
				
				if(match) {
					System.out.println("짝");
					
				}
				//else if(doubleMatch) {
				//	System.out.println("짝짝");
				//}
				else { 
					System.out.println(i);
					
				}
			
		/*		if(i / 10 == 3 || i / 10== 6 || i / 10 == 9 ) {
					System.out.println("짝");
			}
				else {
					System.out.println(i);
				}
					
				
			}
		*/
			}
	}
}

	


