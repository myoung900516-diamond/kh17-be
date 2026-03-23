package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임 {
	public static void main(String[] args) {
		//인원 수 입력받기 
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수를 입력하세요");
		int count = sc.nextInt();
		System.out.println("인력한 인원수 = " + count + "명");
		
		//인원수 만큼의 이름과 항목을 입력받습니다. 
	
		//이름 배열만들기 
		List<String> name = new ArrayList<>();
		//항복 배열만들기 
		List<String> choice = new ArrayList<>();
		
		//이름배열에 이름넣기 
//		System.out.println("이름을 입력하세요");
//		String name1 = sc.next();
//		name.add(name1);
//		
		//인원수에 맞게 이름 넣기 
		int i = 0;
		int k = 0;
		for(i=0;i<count;i++) {
			System.out.println((i+1) + "번 이름을 입력하세요");
			String name1 = sc.next();
			name.add(name1);
		}
		for(k=0;k<count;k++) {
			System.out.println((k + 1) + "개의 항목을 입력하세요");
			System.out.println((k + 1) + "번 항복 : ");
			String choice1 = sc.next();
			choice.add(choice1);
		}
			sc.close();
		
//		System.out.println(name);
//		System.out.println(choice);
			
			
		
	}

}
