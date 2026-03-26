package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test04미니메모장출력 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("파일명을 입력하세요");
		String name = sc.next();
		
		File target = new File("files", name);
		FileWriter writer = new FileWriter(target);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter printer = new PrintWriter(buffer);
		
		
		while(true) {
			System.out.println("입력하세요");
			String word = sc.nextLine();
			if(word.equals("종료"))break;
			printer.println(word);
		}
		printer.close();
		sc.close();
	}
}
