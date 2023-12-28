package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {

	public static void main(String[] args) {
		// 속담을 입력받아 저장하고 출력하는 코드를 작성
		Scanner scan = new Scanner(System.in);
		ArrayList<String> saying = new ArrayList<String>();
//		int count = 5;
		String enter = "";
		
		while(true) {
			System.out.print("속담을 입력하세요: ");
			enter =scan.nextLine();
			if(enter.equals("-1")) {
				break;
			}
			saying.add(enter);
		}
		 

		for(String tmp: saying) {
			System.out.println(tmp+" ");
		}
	}

}
