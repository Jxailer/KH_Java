package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

	public static void main(String[] args) {
		// 정수를 5개 입력받아 입력받은 정수를 리스트에 저장하고 출력하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		
		int count = 5;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<count; i++) {
			System.out.print("정수 입력: ");
			int num=scan.nextInt();
			list.add(num); // int인 num이 Integer로 박싱이 되면서 리스트에 추가됨
		}
//		for(int i=0; i<list.size(); i++) {
//			//get(index): index번지에 있는 인스턴스를 가져옴
//			System.out.print(list.get(i)+" ");
//		}
		
		// 가져온 Integer의 인스턴스를 int형으로 언박싱을 해서 출력함.
		for(int tmp: list) {
			System.out.print(tmp+" ");
		}

	}

}
