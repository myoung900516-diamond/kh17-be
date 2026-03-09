package array;

public class Test02배열생성실습2 {
	public static void main(String [] args) {
		
		int[] arrheight = new int[] {173, 168, 181, 176, 170};
		double[] arrsee = new double[] { 1.2, 0.4, 0.1, 1.0, 0.8, 0.2, 1.5};
		String[] arrblood = new String[] {"A", "B", "B", "AB", "O", "A", "O", "A"};
		int[] arrjoging = new int[] { 8420, 12500, 3210, 7890};
		
		for(int i = 0; i < arrheight.length; i++) {
			System.out.println(arrheight[i]);
		}
		for(int i = 0; i < arrsee.length ; i ++) {
			System.out.println(arrsee[i]);
		}
		for(int i = 0; i < arrblood.length; i++) {
			System.out.println(arrblood[i]);
		}
		for(int i = 0 ; i < arrjoging.length; i ++) {
			System.out.println(arrjoging[i]);
		}
	}

}
