package array3;

public class Test02이차원배열생성실습6 {
	public static void main(String[] args) {
		
		int[][] data = new int[5][5];
		
		int n = 1;
		
		for(int i = 0; i <data.length; i++) {
			for(int k = 0; k<data[i].length; k++) {
				data[i][k] = n;
				n ++;
				System.out.print(data[i][k]);
				System.out.print("\t");
				}
				System.out.println();
	
		
	}
	}
}
