package array;

public class Test07배열회전 {
	public static void main(String[] args) {
		
		int[] arr = new int[] {30, 20, 10, 50, 40};
		int block = 0;
		
		//단순화 시키자
		
		int[] arr1 = new int[] {40, 30, 20, 10, 50};
		int[] arr2 = new int[] {50, 40, 30, 20, 10};
		int[] arr3 = new int[] {10, 50, 40, 30, 20};
		int[] arr4 = new int[] {20, 10, 50, 40, 30};
		//int[] arr5 = int[] arr;
		
		for(int i = 0; i < arr.length; i++) {
			block = arr.length;
			
		
		}
		System.out.println("회전 결과 : " +
		arr[block] + arr[(block-1)] + arr[(block -2)] + arr[(block -3)] +arr[(block -4)]);
		
		
	}

}
