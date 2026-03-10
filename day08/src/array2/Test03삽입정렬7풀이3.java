package array2;

public class Test03삽입정렬7풀이3 {
	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//기준을 하나 잡고 그 데이터를 백업시켜놓고 얘를 얼마나 앞으로 옮길건지
		//중간 지점을 하나 잡고 2지점을 잡고 구현해봅시다 
		
		//삽입정렬
		//1.+2지점의 데이터를 임시 백업한다.
		//2. 앞 지점들(+1, +0)과 비교하여 더 작은 값이 나오면 중지
		
		int backup = data[2];
		for(int i =1; i>=0; i--) {
			//System.out.println(backup > data[i]);
			if(backup > data[i]) {
				break;
			}
		}
	
		
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
