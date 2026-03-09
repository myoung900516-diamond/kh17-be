package array;

public class Teat09배열뒤집기3 {
	public static void main(String [] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};

		//옮기는 과정 = 뒤집는 과정
	    int backup = data[0];
		data[0] = data[4];
		data[4] = backup;
		
		backup = data[1];
		data[1] = data[3];
		data[3] = backup;
		
		
		
		//출력
		for(int i = 0; i<data.length; i++) {
			System.out.println(data[i]);}
			
		
		
		}
	}


