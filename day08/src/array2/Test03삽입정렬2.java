package array2;

public class Test03삽입정렬2 {
	public static void main(String[] args) {
		
		int[] data = new int[] {20, 30, 50, 35, 40};
		
		//3회차 삽입 정렬 
		int backup = data[3];
		if(data[2] > data[3]) {
			if(data[1] > data [3]) {
				if(data[0] > data[3]) {
					data[3] = data[2];
					data[2] = data[1];
					data[1] = data[0];
					data[0] = backup;
				}
				else { 
					data[3] = data[2];
					data[2] = data[1];
					data[1] = backup;
				}
			}
			else { 
				data[3] = data[2];
				data[2] = backup;
			}
			
		}
		else {
			data[3] = backup;
		}
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}

}
