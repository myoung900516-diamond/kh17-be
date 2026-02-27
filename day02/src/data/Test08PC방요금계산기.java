package data;

public class Test08PC방요금계산기 {
	
	public static void main(String[] args) {
		int entryHour = 12;
		int entryMin = 40;
		int goOutHour = 13;
		int goOutMin = 59;
		
		int min1 = entryHour * 60 + entryMin;
		int min2 = goOutHour * 60 + goOutMin;
		int runMin = min2 - min1;
		int runHour = runMin/60;
		int runMin2 = runMin - runHour*60;
		
		int fee = 1000;
		int period = 1;
		
		int hourPrice = runHour * fee;
		int minPrice = runMin2*fee/60/100;
		int minPrice2 = minPrice*100;
		System.out.println(hourPrice + minPrice2);
		

		
		
	}

}
