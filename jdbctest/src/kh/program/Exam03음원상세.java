package kh.program;

import kh.dao.MusicDao;
import kh.dto.MusicDto;

public class Exam03음원상세 {
	public static void main(String[] args) {
		int musicId = 1;
		
		MusicDao musicDao = new MusicDao();
		MusicDto musicDto = musicDao.selectOne(musicId);
		
		System.out.println(musicDto);
	}

}
