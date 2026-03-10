package array2;

public class Test02버블정렬13풀이8 {
	public static void main(String[] args) {
		
	 //인접한 두 개를 비교하는게 핵심 
		//배열 준비
		int[] data = new int[] {10, 20, 30, 40, 50};
		
		
		//4회차 버블정렬 
		for(int i = 0; i <=0; i++) {
			if(data[i] > data[i + 1]) { //앞 데이터가 더 크다면
				int backup = data[i];
				data[i] = data[i+1];
				data[i +1] =backup;	
		}
		
		}
		//1회차 버블정렬은 총 4번 동작으로 마무리 된다.
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	
	}
}
