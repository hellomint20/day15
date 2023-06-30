package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass05 {
	public static void main(String[] args) throws Exception{
		File path = new File("D:/핀테크_평일/test/test.txt");
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);

		dos.writeUTF("안녕하세요");
		dos.writeInt(12345);
		dos.writeDouble(1.12345);
		
		dos.close();	bos.close();	fos.close();
	
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		//저장한 순서와 동일한 순서로 값을 가져온다
		String msg = dis.readUTF();
		int num = dis.readInt();
		double dou = dis.readDouble();
		System.out.println("msg : "+msg);
		System.out.println("num : "+num);
		System.out.println("dou : "+dou);
		
		dis.close();	bis.close();	fis.close();
	}
}
