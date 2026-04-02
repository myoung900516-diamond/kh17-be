package jdbc.program;

import jdbc.dao.LectureDao;

public class Test05모듈화된강좌정보삭제 {
	public static void main(String[] args) {
		int lectureNo = 9;
		
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.delete(lectureNo);
		
		if(success) {
			System.out.println("강좌정보삭제완료");
		}
		else {
			System.out.println("대상이 존재하지 않습니다.");
		}
	}

}
