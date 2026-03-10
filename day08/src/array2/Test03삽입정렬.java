package array2;

public class Test03삽입정렬 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 60, 10, 40};
		
		//2회차 삽입 정렬
		int backup = data[2];
		if(data[1] > data[2]) {
			if(data[0] > data [2]) {
			}
			data[2] = data[1];
			data[1] = data[0];
			data[0] = backup;
		}
		else {
			data[2] = backup;
		}
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
