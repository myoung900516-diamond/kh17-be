package array2;

public class Test02버블정렬3 {
	public static void main(String[] args) {
		
	 
	int[] data = new int[] {30, 50, 20, 10, 40};
	
	//2회차 정렬
	int smaller = 1; //1번째가 2번째보다 작다고 치자
	
		if(data[smaller] > data[smaller + 1]) {
			int backup = data[smaller];
			data[smaller] = data[smaller + 1];
			data[smaller + 1] = backup;
		}

	
	for(int i = 0; i<data.length; i++) {
		System.out.print(data[i]);
		System.out.print("\t");
	}

	System.out.println();
	}
}
