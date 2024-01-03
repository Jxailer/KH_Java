package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx1 {

	public static void main(String[] args) {
		FileInputStream fis1=null;
		FileOutputStream fos1=null;
		
		String fileName = "src/day16/fileEx3.txt";
		
		try {
			fos1 = new FileOutputStream(fileName);
			fis1 = new FileInputStream(fileName);
			
			String str="Hello";
			for(int i=0; i<str.length();i++) {
				fos1.write(str.charAt(i));
			}
			for(int i=0; i<str.length();i++) {
				int ch = fis1.read();
				System.out.println((char)ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			System.out.println("파일 작업 중 예외 발생");
		}
		finally { 
			// 위의 작업이 정상 실행이 안될 경우 파일을 닫게 하기위해 finally에 close()를 작성함.
			try {
				fos1.close();
			} catch (IOException e) {
				System.out.println("파일을 닫을 수 없습니다.");
			}
		}

	}

}
