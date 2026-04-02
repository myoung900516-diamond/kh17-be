package kh.program;

import java.util.List;

import kh.dao.MusicDao;
import kh.dto.MusicDto;

public class Exam02음원목록 {
	public static void main(String[] args) {
		String column = "";
		String keyword = "";
		
		MusicDao musicDao = new MusicDao();
		List<MusicDto> list = musicDao.selectList(column, keyword);
		
		for(MusicDto musicDto : list) {
			System.out.println(musicDto);
		}
	}

}
