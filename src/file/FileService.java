package file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
	public final String path="D:/핀테크_평일/test/member/";

	public void writeMember() {
		Scanner sc = new Scanner(System.in);
		String name, addr;
		int age;
		System.out.print("이릅 입력 : ");
		name = sc.next();
		System.out.print("주소 입력 : ");
		addr = sc.next();
		System.out.print("나이 입력 : ");
		age = sc.nextInt();

		FileDTO dto = new FileDTO();
		dto.setName(name);	dto.setAddr(addr);	dto.setAge(age);

		File filepath = new File(path+name+".txt");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(filepath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dto);
			System.out.println("저장완료");
		} catch (Exception e) {

		}finally {
			try {
				if(oos != null) oos.close();
				if(bos != null) bos.close();
				if(fos != null) fos.close();
			} catch (Exception e2) {
			}
		}
	}

	public void readMember() {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("1. 목록 보기");
		System.out.println("2. 특정 목록 보기");
		System.out.println("3. 모든 사용자 보기");
		System.out.println(">>> ");
		num = sc.nextInt();
		if(num == 1) {
			list();
		}else if(num == 2){
			System.out.print("파일명 입력 : ");
			String msg = sc.next();
			memberView(msg+".txt");
		}else {
			allMemberView();
		}
	}

	private void allMemberView() {
		String[] fileNames = list();
		/*for(String name : fileNames) {
			memberView(name);
		}*/
		ArrayList<FileDTO> members = new ArrayList<>();
		for(String name : fileNames) {
			File file = new File(path+name);
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				ois = new ObjectInputStream(bis);
				FileDTO dto = (FileDTO)ois.readObject();
				members.add(dto);
				ois.close();	bis.close();	fis.close();

				//System.out.println("이름 : "+dto.getName());
				//System.out.println("주소 : "+dto.getAddr());
				//System.out.println("나이 : "+dto.getAge());
			} catch (Exception e) {
				System.out.println("해당 사용자는 존재하지 않습니다.");
			}
			
		}
		System.out.println("===================");
		System.out.println("이름\t주소\t나이");
		System.out.println("-------------------");
		
		for(FileDTO d : members) {
			System.out.println(d.getName()+"\t");
			System.out.println(d.getAddr()+"\t");
			System.out.println(d.getAge());
			System.out.println("--------------");
		}
	}

	private void memberView(String msg) {
		//Scanner sc = new Scanner(System.in);
		//System.out.print("파일명 입력 : ");
		//String msg = sc.next();

		File file = new File(path+msg);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			FileDTO dto = (FileDTO)ois.readObject();

			ois.close();	bis.close();	fis.close();

			System.out.println("이름 : "+dto.getName());
			System.out.println("주소 : "+dto.getAddr());
			System.out.println("나이 : "+dto.getAge());
		} catch (Exception e) {
			System.out.println("해당 사용자는 존재하지 않습니다.");
		}
	}

	private String[] list() {
		File file = new File(path);
		String[] fileNames = file.list();
		for(String f : fileNames) {
			System.out.println(f.split("\\.")[0]);
		}
		return fileNames;
	}
}
