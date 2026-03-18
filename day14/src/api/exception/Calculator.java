package api.exception;

public class Calculator {
	//N분의1금액을 구하는 메소드
	//-예외 처리는 힘든데 나는 예외가 발생할 수 있는 "위,험,한"메소드야!
	//=메소드 마지막에 throws + 예외클래스를 적어서 위험하다는 표시를 남김 
	//-
	public static int oneOverN(int total, int people) throws Exception {
		return total / people;
		}
	//N분의1하고 남은 금액을 구하는 메소드 
	public static int remainingAmount(int total, int people)throws Exception {
		return total % people;
	}

}
