package api.object;

public class Student /*extends Object, extends가 있으면 그걸로 상속되있고 없으면 object로 상속됨*/ {
	//public Student(){}	
	private String name;
	private int score;
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

}
