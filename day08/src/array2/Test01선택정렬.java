package array2;

public class Test01선택정렬 {
	
	public static void main(String[] args){
		
		int[] data = new int[] { 30, 50, 20, 10, 40};
		
		//가장 작은 수 찾기
		int min = data[0];
		int minRocation = data[0];
		for(int i = 0; i <data.length ; i++) {
			if(min>data[i]) {
				min = data[i];
				minRocation = i;
			}
		}
		System.out.println("가장 작은 수 : " + min);
		
		
		//가장 작은 수의 위치 찾기 
		System.out.println("가장 작은 수의 위치는 " + (minRocation + 1) + "번째");
		
		//가장 작은 수를 첫 번째 위치로 옮기기
		
		int backup = data[0];
		data[0] = min;
		data[minRocation] = backup;
		
		for(int i = 0; i <data.length; i++) {
			//System.out.println(data[i]);
			System.out.print(data[i] + "\t");
		}
		System.out.println();
	
		//나머지 위치에서 가장 작은 수 찾기 
		int min2 = data[1];
		int min2Rocation = data[1];
		for(int i = 1; i < data.length;i++) {
			if(min2 > data[i]) {
				min2 = data[i];
				min2Rocation = i;
			}
		}
		System.out.println("나머지 위치에서 가장 작은 수 : " + min2);
		System.out.println("나머지 위치에서 가장 작은 수의 위치는 " + (min2Rocation + 1) + "번째");
		
		backup = data[1];
		data[1] = min2;
		data[min2Rocation] = backup;
		
		for(int i = 0; i < data.length; i++) {
			//System.out.println(data[i]);
			System.out.print(data[i] + "\t");
		}
		System.out.println();
		
		//그 나머지 위치에서 가장 작은 수 
		int min3 = data[2];
		int min3Rocation = data[2];
		for(int i = 2; i < data.length;i++) {
			if(min3 > data[i]) {
				min3 = data[i];
				min3Rocation = i;
			}
		}
		System.out.println("그 나머지 위치에서 가장 작은 수 : " + min3);
		System.out.println("그 나머지 위치에서 가장 작은 수의 위치는 " + (min3Rocation + 1) + "번째");
		
		backup = data[2];
		data[2] = min3;
		data[min3Rocation] = backup;
		
		for(int i = 0; i < data.length; i++) {
			//System.out.println(data[i]);
			System.out.print(data[i] + "\t");
		}
		System.out.println();
		//그그 나머지 위치에서 가장 작은 수 
		int min4 = data[3];
		int min4Rocation = data[3];
		for(int i = 3; i < data.length;i++) {
			if(min4 > data[i]) {
				min4 = data[i];
				min4Rocation = i;
			}
		}
		System.out.println("나머지 위치에서 가장 작은 수 : " + min4);
		System.out.println("나머지 위치에서 가장 작은 수의 위치는 " + (min4Rocation + 1) + "번째");
		
		backup = data[3];
		data[3] = min4;
		data[min4Rocation] = backup;
		
		for(int i = 0; i < data.length; i++) {
			//System.out.println(data[i]);
			System.out.print(data[i] + "\t");
		}
		System.out.println();
		
		
	}
}
