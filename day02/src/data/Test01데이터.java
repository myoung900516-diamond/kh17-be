package data;

public class Test01데이터 {
	public static void main(String[] args) {
		//데이터(data)
		//-측정이 가능한 값
		//-무언가 판단을 하기 위한 근거(가벼운 판단)
		
		//정보(information)
		//-데이터를 가공해서 만든 값 (ex:평균)
		
		//자바 프로그래밍에서의 데이터
		//-숫자와 숫자가 아닌 것으로 나눠짐
		//-단위는 신경쓰지 않는다 = 단위는 개발자가 알아서 구분해 작성해줘야함, 기본상식이다. (다르면 계산 불가, 같으면 계산 가능, 비슷하면 바꿔서 계산가능)
		
		System.out.println(100 + 200); //""따옴표가 없으면 숫자로 인식한다. *=곱하기, /=나누기
		
		
		//(Q)자장면 1그릇 7천원, 짬뽕 1그릇 8천원일 때 자장면 2그릇과 짬뽕 3그릇의 가격은?
		
		System.out.println(7000*2 + 8000*3); //이게 best!
		System.out.println(38000); //귀찮다고 내가 계산해서 쓰면 안됨. 
		System.out.println(14000 + 24000); //이렇게도 쓰면 안 됨.
		
		
		//변수(variable) - 데이터를 잠시 담아두기 위한 저장공간
		int a = 7000*2;
		int b = 8000*3;
		int c = a + b;
		System.out.println(c);
		
		//우리가 원하는 최종적인 형태(단순하게 저장하기만 하는 것이 아니라 고치는 것가지 염두)
		int jjajang = 7000;
		int jjambbong = 8000;
		int jjajangCount = 2; //띄어쓰기 않됨. 언어중의 대소문자를 구분하면 
		int jjambbongCount = 3;
		//---------------------------------------------------------여기까지는 입력 = 문제에서 주어지는 값
		
		int jjajangTotal = jjajang * jjajangCount;
		int jjambbongTotal = jjambbong * jjambbongCount;
		int total = jjajangTotal + jjambbongTotal;
		//---------------------------------------------------------여기까지는 계산(process) + - * / 
		System.out.println(total);
		//---------------------------------------------------------여기까지가 출력(output) = 문제에서 요구하는 결과값
		
		
    }

}




