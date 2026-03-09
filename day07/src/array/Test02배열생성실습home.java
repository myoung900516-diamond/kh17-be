package array;

public class Test02배열생성실습home {
	public static void main(String[] args) {
		
		int[] heightList = new int[] {173,168,181,176,170};
		float[] visionList = new float[] {1.2f, 0.4f, 0.1f, 1.0f, 0.8f, 0.2f, 1.5f};
		String[] bloodTypes = new String[] {"A", "B", "B", "AB", "O", "A", "O", "A"};
		int[] steps = new int[] {8420, 12500, 3210, 7890};
		
		for(int i = 0; i <heightList.length; i++) {
			System.out.println("키 데이터 : " + heightList[i]);
		}
		for(int i = 0; i < visionList.length; i++) {
			System.out.println("시력 데이터 : " + visionList[i]);
		}
		for(int i = 0; i<bloodTypes.length; i++) {
			System.out.println("혈액형 데이터 : " + bloodTypes[i] + "형");
		}
		for(int i = 0; i <steps.length; i++) {
			System.out.println("요일별 걸음수 : " + steps[i]);
		}
	}

}
