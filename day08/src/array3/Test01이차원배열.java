package array3;

public class Test01이차원배열 {
	public static void main(String[] args) {
		
		//이차원 배열
		//-일차원 배열들이 모여있는 형태
		//(일차원 배열은 변수들을 모여있는 형태)
		//-이해하기 가장 쉬운 형태는 "표"
		
		int[][] data = new int[][] {
			{2,3,6},
			{7,1, 5}
		};
		
		//data는 리모컨이다. data ------------> data[0] ---> {2, 3, 6}
		//                         data ------------> data[1] ---> {7, 1, 5}
		//                         <2차원>                <1차원>           <0차원>
		//data.length = 2
		//data[0].length = 3
		//data[1].length = 3
		
		System.out.println(data);
		System.out.println(data[0]);
		System.out.println(data[1]);
		//일련번호 나오면 리모컨이다. [[괄호수가 차원 수다. 
		
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
		System.out.println(data[0][2]);
		System.out.println(data[1][0]);
		System.out.println(data[1][1]);
	System.out.println(data[1][2]);
	}
}

