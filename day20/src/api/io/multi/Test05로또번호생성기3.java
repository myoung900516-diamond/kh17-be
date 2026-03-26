package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test05로또번호생성기3 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		
		Set<Integer> number = new TreeSet<>();
		
		Random r = new Random();
		
		while(number.size()<6) {
			int num = r.nextInt(45) + 1;
			number.add(num);
		}
		for(int lotto : number) {
			data.writeInt(lotto);
			System.out.println("로또번호 = " + lotto);
		}
		data.close();
	}

}
