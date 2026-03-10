package array;

public class Teat09배열뒤집기2 {
	public static void main(String [] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};

		//backup개수는 data.length/2개.데이터갯수와 무관하게.
		//반땡 백업으로 옮기면 나머니 반을 옮기고 백업에 있던 애들을 나머지로 옮긴다.
//		int backup0 = data[0];
//		int backup1 = data[1];
//		data[0] = data[4];
//		data[1] = data[3];
//		data[3] = backup1;
//		data[4] = backup0;
		
		
		//옮기는 과정
//	    int backup = data[0];
//		data[0] = data[4];
//		data[4] = backup;
//		
//		backup = data[1];
//		data[1] = data[3];
//		data[3] = backup;
		
//		if(data.length % 2 == 0) {
//			for(int k = 0; k < data.length/2; k++) {
//				int a = k;
//				int b = data.length/2;
//		
//				int backup = data[k];
//				data[k] = data[data.length];
//				data[data.length] = backup;
//			}
//		}
		
//		if(data.length % 2 == 0) {
		int a = 0;
		int b = 4;
			for(int k = 0; k < data.length/2; k++) {
//				int a = k;
//				int b = data.length/2;
//		
				int backup = data[b];
				data[b] = data[a];
				data[a] = backup;
				//System.out.println()
			}
//		}
		
//		for(int i = 0; i < data.length/2; i++) {
//			int a = i;
//			int b = data.length - 1 - i;
//			int backup = data[b];
//			data[b] = data[a];
//			data[a] = backup;
//		}
	
//		if(data.length % 2 == 1) {
//			
//			for(int k = 0; k < data.length/2 +1; k++) {
//				int backup = data[k];
//				data[k] = data[data.length];
//				data[data.length] = backup;
//			}
//		}
			
				
				for(int i = 0; i<data.length; i++) {
		
			//System.out.println(data[k]);
			System.out.println(data[i]);
		}
	

		}
	}


