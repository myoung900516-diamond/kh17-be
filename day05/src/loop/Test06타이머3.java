package loop;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Test06타이머3 {
	public static void main (String[] args) throws Exception {
	
		//시작값을 변수로 설정
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("분 입력 : ");
		int inputMinute = sc.nextInt();
		System.out.println("초 입력 : ");
		int inputSecond = sc.nextInt();
		//처리
		
		int time = inputMinute * 60 + inputSecond ;
		
		for(int i = time ; i >= 0 ; i--) {
			int minute = i / 60;
			int second = i % 60;
			System.out.println(minute + "분" + second + "초 후에 알람이 울립니다");
			Thread.sleep(1000);
			
			//1초마다 메세지가 올라오는 방법 / 알람 소리 울리는 방법 gpt에 물어보기 
		}
		System.out.println("★★★시간 종료★★★");
		//Toolkit.getDefaultToolkit().beep();
		File file = new File("C:/kh17/workspace/alarmsound.wav");
		AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(stream);
		clip.start();
		clip.drain();
	}
}

