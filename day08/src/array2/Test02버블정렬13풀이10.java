package array2;

public class Test02버블정렬13풀이10 {
	public static void main(String[] args) {
		
	 //최적화
		int[] data = new int[] {30, 50, 20, 10, 40, 55};
		
		
		//버블정렬 
		for(int k = data.length-1; k > 0 ; k--) {
			for(int i = 0; i <k; i++) {
				if(data[i] > data[i + 1]) { 
					int backup = data[i];
					data[i] = data[i+1];
					data[i +1] =backup;	
			}
		}
		
		
		}
	
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	
	}
}
