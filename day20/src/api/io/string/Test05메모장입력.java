package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Test05메모장입력 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String fileName = sc.next();
		
		File target = new File("files", fileName);
		FileReader reader = new FileReader(target);
		BufferedReader buffer = new BufferedReader(reader);
		
		while(true) {
			String line = buffer.readLine();
			if(line == null) break;
			System.out.println("line = " + line);
		}
		
		buffer.close();
		
	}

}
