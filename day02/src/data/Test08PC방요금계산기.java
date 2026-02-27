package data;

public class Test08PC방요금계산기 {
	
	public static void main(String[] args) {
	
		/*
		int entryHour = 12;
		int entryMin = 40;
		int goOutHour = 15;
		int goOutMin = 20;
		
	
		int min1 = entryHour * 60 + entryMin;
		int min2 = goOutHour * 60 + goOutMin;
		int runMin = min2 - min1;
		int runHour = runMin/60;
		int runMin2 = runMin - runHour*60;
		
		int fee = 1000;
		
		int hourPrice = runHour * fee;
		int minPrice = runMin2*fee/60/100;
		int minPrice2 = minPrice*100;
		System.out.println(hourPrice + minPrice2);
		//이렇게 해도 계산은 맞지만, 선생님께서 변환연산을 사용하라는 말씀을 듣고 수정함. 그리고 이름도 단순화함.
		*/
		
		
		//입력
		int h1 = 12;
		int m1 = 40;
		int h2 = 15;
		int m2 = 20;
		int price = 1000;
		
		//처리
		int t1 = h1 * 60 + m1;
		int t2 = h2 * 60 + m2;
		int time = t2 - t1;
	    double pricePerMin = (double)price/60;
	   // double realfee = pricePerMin * time;
	    //System.out.println(pricePerMin);
	    //System.out.println(realfee);
	    //int total = (int)realfee;
	    //System.out.println(total);
	    //int fee = total/100*100;
	    //System.out.println(fee);
	    int total = (int)(time*pricePerMin)/100*100;
	  
		//int total = (time*pricePerMin)/100*100;
		
		//출력
		System.out.println(total);
		
		
		
	
		

	
		
	}

}
