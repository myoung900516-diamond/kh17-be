package data;

public class Test03시간계산기 {
    public static void main (String[] args) {
    	//입력
    	int yesterdayHour = 1; //1,30= 변수 (변하는 값)
    	int yesterdayMin = 30;
    	
    	int todayHour = 2;
    	int todayMin = 40;
    	//처리
    	int yesterdayTotal = yesterdayHour * 60 + yesterdayMin; //60=상수(죽어도 변하지 않는 값)
    	int todayTotal = todayHour*60 + todayMin;
    	
    	int total = yesterdayTotal + todayTotal;
    	//출력
    	System.out.println(total);
    	

    	
    	}
}
