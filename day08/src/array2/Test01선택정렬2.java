package array2;

public class Test01선택정렬2 {
	
	public static void main(String[] args){
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//1회차 정렬
		//-핵심 : 0~4 범위에서 가장 작은 값의 위치를 찾아 0과 교체
		//모를 때는 정답부터 써 놓고 그다음 해결 
//		int backup = data[3];
//		data[3] = data[0];
//		data[0] = backup;
		
		//int min = data[0]; //이럼 위치를 알 수 없음.
		
		int min = 0; //0번 위치가 가장 작은 값이 있다고 치자. 
		
		for(int i =1; i <4; i++) {
			if(data[min] > data[i]) {                          //더 작은 데이터를 발견한다면 ){
					min = i; //위치를 수정 )
		}
		}
		//데이터 교체
		int backup = data[min];
		data[min] = data[0];
		data[0] = backup;
		
		//출력
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	
	}
}
