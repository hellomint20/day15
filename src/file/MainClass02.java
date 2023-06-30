package file;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String path = "D:/핀테크_평일/test/";
		/*File path = new File("D:\\핀테크_평일\\test\\test.txt");
		File path = new File("D:\\핀테크_평일\\test");
		path.mkdir();
		path.delete();

		String [] list = path.list();
		System.out.println(list[0]);
		System.out.println(path.exists());	//파일 존재 여부 확인 
		 */
		System.out.println("파일명 입력 : ");
		String name = sc.next();
		path += name+".txt";
		File filepath = new File(path);
		if(filepath.exists()) {
			System.out.println("파일이 존재합니다.");
		}else {
			FileOutputStream fos = new FileOutputStream(path);
			System.out.println("파일에 출력할 내용 입력 : ");
			String msg = sc.next();
			fos.write(msg.getBytes());
			System.out.println("저장 되었습니다.");
		}
	}
}
