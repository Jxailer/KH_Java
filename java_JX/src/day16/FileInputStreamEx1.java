package day16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx1 {

	public static void main(String[] args) {
		try {
			// 파일을 찾을 수 없을 떄 에러가 발생할 수 있다는 에러가 뜸.
			// 에러를 직접 처리함.
			FileInputStream fis = new FileInputStream("src/day16/fileEx1.txt");
			for(int i=0; i<3; i++) {
				int num = fis.read(); // 파일에 기록된 것을 하나씩 읽어옴
				System.out.print((char)num); // 형변환을 하지 않으면 아스키코드가 출력됨.
			}
			
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			System.out.println("파일을 닫을 수 없습니다.");
		}

	}

}
