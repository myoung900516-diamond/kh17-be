package api.io.multi;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.TreeSet;


public class Test06로또번호출력기2 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileInputStream stream = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(stream);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		Set<Integer> number = (TreeSet)object.readObject();
		
		object.close();
		
		System.out.println(number);
	
		
	}

}
