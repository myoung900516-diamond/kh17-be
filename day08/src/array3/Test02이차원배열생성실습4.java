package array3;

public class Test02이차원배열생성실습4 {
	public static void main(String[] args) {
		
		int[][] data = new int[5][5];
		
		int limit = data.length * data[0].length;
		int x = 0, y = 0;
		for(int i = 1; i <= limit; i++) {
			data[x][y] = i;
			y++;//우측으로 한칸씩 이동
			if(y == data[0].length) {
				x++;
				y=0;
			}
		}
		
		for(int i = 0; i <data.length; i++) {
			for(int k = 0; k<data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
				}
				System.out.println();
	
		}
	}

}
