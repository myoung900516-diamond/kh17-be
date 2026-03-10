package array2;

public class Test03삽입정렬7풀이4 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//기준을 하나 잡고 그 데이터를 백업시켜놓고 얘를 얼마나 앞으로 옮길건지
		//중간 지점을 하나 잡고 2지점을 잡고 구현해봅시다 
		
		//삽입정렬
		for(int k = 1; k <data.length; k++) {
			int position = k;
			int backup = data[position];
			for(int i =position - 1; i>=0; i--) {
				//System.out.println(backup > data[i]);
				if(backup > data[i]) {
					break;
				}
				else {
					data[i + 1] = data[i];
					position--;
				}
			}
			data[position] = backup; 
		}
		
	
		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
