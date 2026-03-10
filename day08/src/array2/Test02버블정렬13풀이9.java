package array2;

public class Test02버블정렬13풀이9 {
	public static void main(String[] args) {
		
	 //인접한 두 개를 비교하는게 핵심 
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		
		//버블정렬 
		for(int k = 3; k >= 0 ; k--) { //'=' 등호 없는 것을 선호, 왜? 일관성있으니까
			for(int i = 0; i <=k; i++) {
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
