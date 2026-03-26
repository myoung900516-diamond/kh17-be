package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test05로또번호생성기2 {
	public static void main(String[] args) throws Exception {
		
		File target = new File("files", "lotto.kh");
		FileOutputStream stream = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(stream);
		DataOutputStream data = new DataOutputStream(buffer);
		
		Set<Integer> number = new TreeSet<>();
		
		Random r = new Random();
		
		for(int i = 0; i < 6; i++) {
			int num = r.nextInt(45) + 1;
			number.add(num);
		}
		System.out.println("로또번호 = " + number);
		 Object[] arr = number.toArray();
	        System.out.println(arr[0]); // 첫 번째 값 (5)
	        System.out.println(arr[1]); // 두 번째 값 (10)
	        
	      //  data.write(arr[0]);
	        
		
		//data.writeInt(num);
		
		data.close();
	}

}
