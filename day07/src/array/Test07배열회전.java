package array;

public class Test07배열회전 {
	public static void main(String[] args) {
		
		//배열준비
		int[] data = new int[] {30, 20, 10, 50, 40};
		
		//회전
		
		
		//for(int i = 0; i<size; i++) {
		int backup = data[4];
		data[4] = data[3];
		data[3] = data[2];
		data[2] = data[1];
		data[1]= data[0];
		data[0] = backup;
		
		
		//출력
		for(int i = 0; i < data.length; i++) {
		//	System.out.println(data[i]);
		}
	}

}
