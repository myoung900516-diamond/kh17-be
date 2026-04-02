package kh.program;

import java.util.Scanner;

import kh.dao.MusicDao;

public class Exam05음원삭제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("음원 아이디 : ");
		int musicId = sc.nextInt();
		
		
		MusicDao musicDao = new MusicDao();
		musicDao.delete(musicId);
		
		
		
		
	}

}
