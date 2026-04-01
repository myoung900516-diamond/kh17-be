package jdbc.select;

public class LectureDto {
	private int lectureNo;
	private String lectureTitle;
	private String lectureCategory;
	private int lectureDuration;
	private int lecturePrice;
	private String lectureType;
	public int getLectureNo() {
		return lectureNo;
	}
	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String getLectureCategory() {
		return lectureCategory;
	}
	public void setLectureCategory(String lectureCategory) {
		this.lectureCategory = lectureCategory;
	}
	public int getLectureDuration() {
		return lectureDuration;
	}
	public void setLectureDuration(int lectureDuration) {
		this.lectureDuration = lectureDuration;
	}
	public int getLecturePrice() {
		return lecturePrice;
	}
	public void setLecturePrice(int lecturePrice) {
		this.lecturePrice = lecturePrice;
	}
	public String getLectureType() {
		return lectureType;
	}
	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}
	public LectureDto() {
		super();
	}
	@Override
	public String toString() {
		return "LectureDto [lectureNo=" + lectureNo + ", lectureTitle=" + lectureTitle + ", lectureCategory="
				+ lectureCategory + ", lectureDuration=" + lectureDuration + ", lecturePrice=" + lecturePrice
				+ ", lectureType=" + lectureType + "]";
	}
	

}
