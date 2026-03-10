package array2;

public class Test03삽입정렬6 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		int backup = data[2];
		
		for(int i = 1; i >= 0; i --) {
			if(backup < data[i]) {
				data[i + 1] = data[i];
		}
//			else(backup > data[i]){
//				
//			}
//			
		}
		
		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
