package array2;

public class Test02버블정렬13풀이4 {
	public static void main(String[] args) {
		
	 //인접한 두 개를 비교하는게 핵심 
		//배열 준비
		int[] data = new int[] {30, 20, 10, 50, 40};
		
		
		//1회차 버블정렬 중 네번째 동작
		if(data[3] > data[4]) { //앞 데이터가 더 크다면
			int backup = data[3];
			data[3] = data[4];
			data[4] =backup;
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
