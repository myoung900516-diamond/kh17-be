package data;

public class Test07주차요금계산기 {
        public static void main(String[] args) {
        	//주차시간을 구해야 금액을 구할 수 있으니 시간 먼저 계산 
        	
        	//입력
        	int startHour = 12; 
        	int startMin = 40;
        	int finishHour = 15;
        	int finishMin = 20;
        	
        	//처리
        	int parkingHour =(finishHour * 60 + finishMin) -(startHour * 60 + startMin);
        	int showHour = parkingHour/60;
        	int showMin = parkingHour%60;
        	int parkingfee = parkingHour/10*500;
        	//int parkingfee = (parkingHour -10)/10*500;
        	
        	
        	//출력
       
        	//System.out.println(parkingHour);
        	
        	System.out.println("주차이용시간은 " + showHour + "시간 " + showMin + "분 입니다.");
        	System.out.println("주차이용요금은 " + parkingfee + "원 입니다.");
        	
        	
        }
}
