package array;

public class Test01배열의필요성2 {
	public static void main(String[] args) {
		//배열(Array)
		//-반복문과 같이 사용해야 시너지가 발생
		
		//배열 생성 (정수 3개)
		int[] arr = new int[] {10, 20, 30, 40, 50};//int다발, int묶음
		
		//for(int i = 0; i < 3 ; i++) {
		for(int i = 0; i < arr.length; i++) {//arr.length는 arr배열의 길이 (칸수)를 자동으로 보관하는 값
		System.out.println(arr[i]);//arr 리모컨이 가리키는 시작점에서 +0칸 떨어진 곳의 데이터
		
		}
	}

}
