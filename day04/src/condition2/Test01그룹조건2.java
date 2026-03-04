package condition2;

public class Test01그룹조건2 {
	public static void main(String[] args) {
		
		//3개 이상의 조건
		//-피자 가격이 엄청 비싼지, 그냥 비싼지, 적당한지, 싼지 구분
		
		
		//입력
		int pizza = 22000;
		
		//출력
		
		if(pizza >= 30000) {
			System.out.println("엄청비싸네");

		}
		else if(pizza >= 25000) {
				System.out.println("비싼데?");

			}
		else if(pizza >= 15000) {
					System.out.println("나쁘지 않은데?");

				}
				else {
					System.out.println("대박인데?");

				}
			}
		
		
	}
	

