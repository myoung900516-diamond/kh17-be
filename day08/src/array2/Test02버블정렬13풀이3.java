package array2;

public class Test02버블정렬13풀이3 {
	public static void main(String[] args) {
		
	 //인접한 두 개를 비교하는게 핵심 
		//배열 준비
		int[] data = new int[] {30, 20, 50, 10, 40};
		
		
		//1회차 버블정렬 중 세번째 동작
		if(data[2] > data[3]) { //앞 데이터가 더 크다면
			int backup = data[2];
			data[2] = data[3];
			data[3] =backup;
		}
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	
	}
}
