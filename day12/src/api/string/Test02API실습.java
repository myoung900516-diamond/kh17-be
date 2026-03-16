package api.string;

public class Test02API실습 {
	public static void main(String[] args) {
		
		StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer("HelloWorld");
		
		System.out.println("객체 a의 글자수 : " + a.length());
		System.out.println("객체 b의 글자수 : " + b.length());
		
		System.out.println(a.append("KHacademy"));
		
		System.out.println(b.append("JavaProgramming"));
		
		System.out.println(a.reverse());
		
		System.out.println(b.delete(4, 9));
		
		//System.out.println(b.deleteCharAt(1));
		
		
	}

}
