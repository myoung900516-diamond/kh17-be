package random;

import java.util.Random;

public class Teat02구구단게임 {
	public static void main(String[] args) {
		
		Random r = new Random();
		int gugudan = r.nextInt(9) + 1;
		int gugudan2 = r.nextInt(9) + 1;
		System.out.println("1." + gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println("2." + gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
		System.out.println(gugudan + "*" + gugudan2 +" 의 정답을 맞혀보세요");
	}

}
