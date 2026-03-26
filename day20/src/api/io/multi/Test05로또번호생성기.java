package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class Test05로또번호생성기 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		
		Random r = new Random();
		
		for(int i = 0; i < 6; i++) {
		int number = r.nextInt(45) + 1;
		data.writeInt(number);
		System.out.println("로또번호 " + number);
		}
		data.close();
	}

}
