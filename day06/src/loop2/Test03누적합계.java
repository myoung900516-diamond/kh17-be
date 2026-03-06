package loop2;

public class Test03누적합계 {
	public static void main(String[] args) {
		//(Q) 1부터 10까지 더하면 얼마에요?
		//int total = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
		//System.out.println("total = " + total);
		
		int total = 0;
		for(int i = 1 ; i <= 10; i++) {
			total += i;
		}
		/*
		total += 1;
		total += 2;
		total += 3;
		total += 4;
		total += 5;
		total += 6;
		total += 7;
		total += 8;
		total += 9;
		total += 10;
		*/
		System.out.println("total =" + total);
		
	}

}
