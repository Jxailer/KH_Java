package day13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternEx2 {
	/* 아이디를 입력받아 아이디 형식에 맞는지 아닌지를 출력한느 프로그램을 작성하세요
	 * 
	 * 아이디 정규 표현식: 영문, 숫자로 구성이 되어있고, 8~13자리
	 *  
	 * 아이디: abc
	 * 아이디 형식에 맞지 않습니다.
	 * 
	 * 아이디: abcd1234
	 * 아이디로 사용 가능합니다.
	 * */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String regex = "^[a-zA-Z0-9]{8,13}$";
		
		System.out.println("아이디: ");
		String id = scan.next();
		
		if(Pattern.matches(regex, id)) {
			System.out.println("아이디로 사용 가능합니다.");
		}
		else {
			System.out.println("아이디 형식에 맞지 않습니다.");
		}
		

	}

}
