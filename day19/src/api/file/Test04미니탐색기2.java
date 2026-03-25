package api.file;


import java.util.Scanner;

public class Test04미니탐색기2 {
	public static void main(String[] args) {
		//String input = "D:/존재하지않는이름";
		Scanner sc = new Scanner(System.in);
		//String path = sc.next();
		
		FileExplorer explorer = new FileExplorer();
		
		while(true) {
			System.out.println("입력하세요");
			String input = sc.nextLine();
			if(input.equals("종료"))break;
			//File a = new File(input);
			explorer.move(input);
			explorer.show();
			
		}
		sc.close();
		
		
		
	}

}
