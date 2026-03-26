package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.TreeSet;


public class Test04로또번호출력기 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		
		Set<Integer> number = (TreeSet)object.readObject();//경고가 발생함(내용물까지 완벽히 책임지지 못한다는 것)
		
		
		object.close();
		
		System.out.println(number);
	
		
	}

}
