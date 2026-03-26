package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Test04성적정보분석 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "score.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		DataInputStream data = new DataInputStream(buffer);
		
		int scoreA = data.readInt();
		int scoreB = data.readInt();
		int scoreC = data.readInt();
		int scoreD = data.readInt();
		int scoreE = data.readInt();
		int scoreF = data.readInt();
		int scoreG = data.readInt();
		int scoreH = data.readInt();
		int scoreI = data.readInt();
		int scoreJ = data.readInt();
		
		
		System.out.println("a학생의 점수 =" + scoreA + "점");
		System.out.println("b학생의 점수 =" + scoreB + "점");
		System.out.println("c학생의 점수 =" + scoreC + "점");
		System.out.println("d학생의 점수 =" + scoreD + "점");
		System.out.println("e학생의 점수 =" + scoreE + "점");
		System.out.println("f학생의 점수 =" + scoreF + "점");
		System.out.println("g학생의 점수 =" + scoreG + "점");
		System.out.println("h학생의 점수 =" + scoreH + "점");
		System.out.println("i학생의 점수 =" + scoreI + "점");
		System.out.println("j학생의 점수 =" + scoreJ + "점");
		data.close();
		
		int pass = 0;
		while(true) {
			//if(data.readInt() == -1)break;
			//data.readInt() >= 60;
			pass ++;
		}
		//System.out.println("합격 인원수 = " + pass + "명");
		
		
	}

}
