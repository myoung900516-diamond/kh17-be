package march19_20;

public class Test09 {
	public static void main(String[] args) {
		int a = 472;
		int b = 385;
		
		//b를 무엇으로 나눠서 5가 나올까 
		int b380 = b/10*10; 
		int b5 = b%b380; 
		
		int ab3 = a*b5;
		
		//b를 무엇으로 나눠서 8이 나올까 
		int b300 = b/100*100;
		int b85 = b%b380;
		
		
		System.out.println(ab3);
	}

}
