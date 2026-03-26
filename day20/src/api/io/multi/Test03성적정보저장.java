package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test03성적정보저장 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "score.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		
		int i = 0;
		Scanner sc = new Scanner(System.in);
		for(i = 1; i<=10; i++) {
			System.out.println("성적을 입력하세요");
			int score = sc.nextInt();
			data.writeInt(score);
		}
		data.close();
		sc.close();
	}

}
