package kh.dto;

public class MusicDto {
	private int musicId;
	private String musicTitle;
	private String musicArtist;
	private String musicAlbum;
	private String musicRelease;
	private Long musicPlay;
	private Long musicLike;
	private Long musicDislike;
	private String musicGenre;
	public int getMusicId() {
		return musicId;
	}
	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicArtist() {
		return musicArtist;
	}
	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}
	public String getMusicAlbum() {
		return musicAlbum;
	}
	public void setMusicAlbum(String musicAlbum) {
		this.musicAlbum = musicAlbum;
	}
	public String getMusicRelease() {
		return musicRelease;
	}
	public void setMusicRelease(String musicRelease) {
		this.musicRelease = musicRelease;
	}
	public Long getMusicPlay() {
		return musicPlay;
	}
	public void setMusicPlay(Long musicPlay) {
		this.musicPlay = musicPlay;
	}
	public Long getMusicLike() {
		return musicLike;
	}
	public void setMusicLike(Long musicLike) {
		this.musicLike = musicLike;
	}
	public Long getMusicDislike() {
		return musicDislike;
	}
	public void setMusicDislike(Long musicDislike) {
		this.musicDislike = musicDislike;
	}
	public String getMusicGenre() {
		return musicGenre;
	}
	public void setMusicGenre(String musicGenre) {
		this.musicGenre = musicGenre;
	}
	public MusicDto() {
		super();
	}
	@Override
	public String toString() {
		return "MusicDto [musicId=" + musicId + ", musicTitle=" + musicTitle + ", musicArtist=" + musicArtist
				+ ", musicAlbum=" + musicAlbum + ", musicRelease=" + musicRelease + ", musicPlay=" + musicPlay
				+ ", musicLike=" + musicLike + ", musicDislike=" + musicDislike + ", musicGenre=" + musicGenre + "]";
	}
	

}
