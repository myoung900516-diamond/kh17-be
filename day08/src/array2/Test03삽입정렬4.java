package array2;

public class Test03삽입정렬4 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		for(int i = 1; i <=4; i++ ) {
			int backup = data[i];
			if(data[i -1] > data[i]) {
				data[i] = data[i-1];
				data[i-1] = backup;
			}
			else {
				data[i] = backup;
			}
		}
		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
