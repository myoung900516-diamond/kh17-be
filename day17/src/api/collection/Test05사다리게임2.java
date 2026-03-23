package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test05사다리게임2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수를 입력하세요");
		int count = sc.nextInt();
		System.out.println("인력한 인원수 = " + count + "명");
		
	
		List<String> name = new ArrayList<>();
		List<String> choice = new ArrayList<>();
		
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
			
			// 항목을 랜덤셔플
			Collections.shuffle(choice);
			//System.out.println(choice);
			
			//출력
			int l = 0;
			for(l = 0 ; l < count ; l ++) {
				//System.out.println(name + "의 항목은 순서대로" + choice + "입니다");
				//System.out.println(name.get(l));
				//System.out.println(choice.get(l));
				System.out.println(name.get(l) + "→" + choice.get(l));
			}
			sc.close();
		
	}

}
