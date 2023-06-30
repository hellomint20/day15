package file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class MainClass04 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/핀테크_평일/test/test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		for(char ch='0'; ch <='9'; ch++) {
			Thread.sleep(1000);
			//fos.write(ch);
			bos.write(ch);	//임시저장소에만 저장이 됨
		}
		bos.flush();	//저장된 내용을 파일로 보내주는 역할
		bos.write('A');
		bos.flush();
		bos.write('B');
		bos.close();	//close 하게 되면 더이상 내용 추가 불가능
	}
}
