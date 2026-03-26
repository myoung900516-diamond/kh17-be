package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test03로또번호생성기 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		Set<Integer> number = new TreeSet<>();
		
		Random r = new Random();
		
		while(number.size()<6) {
			int num = r.nextInt(45) + 1;
			number.add(num);
		}
		object.writeObject(number);
	
		object.close();
	}

}
