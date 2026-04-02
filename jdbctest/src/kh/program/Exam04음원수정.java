package kh.program;

import java.util.Scanner;

import kh.dao.MusicDao;
import kh.dto.MusicDto;

public class Exam04음원수정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MusicDto musicDto = new MusicDto();
		System.out.println(" 고유번호 : ");
		musicDto.setMusicId(0);
		System.out.println("곡 제목 : ");
		musicDto.setMusicTitle(sc.nextLine());
		System.out.println("아티스트 : ");
		musicDto.setMusicArtist(sc.nextLine());
		System.out.println("앨범명 : ");
		musicDto.setMusicAlbum(sc.nextLine());
		System.out.println("발매일 : ");
		musicDto.setMusicRelease(sc.nextLine());
		System.out.println("재생횟수 : ");
		musicDto.setMusicGenre(sc.nextLine());
		System.out.println("종아요 수 : ");
		musicDto.setMusicPlay(sc.nextLong());
		System.out.println("싫어요 수 : ");
		musicDto.setMusicLike(sc.nextLong());
		System.out.println("장르 : ");
		musicDto.setMusicDislike(sc.nextLong());
		
		MusicDao musicDao = new MusicDao();
		boolean success = musicDao.update(musicDto);
		
		
	}
	

}
