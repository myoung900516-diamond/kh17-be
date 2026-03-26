package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test04성적정보분석2 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("files", "score.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
			while(true) {
				int score = data.readInt();
				System.out.println("점수 = " + score);
				if(score < 0) break;
			}
//			int count = 0;
//			while(true) {
//				int score = data.readInt();
//				if(score >= 60) 
//					count++;
//				System.out.println("합격자 수 = " + count);
//			}
			
//			int total = 0;
//			while(true) {
//				int score = data.readInt();
//				total += score;
//			}
//			double average = total / 10d;
//			System.out.println("평균 = " + average);
		
		data.close();
		
	}

}
