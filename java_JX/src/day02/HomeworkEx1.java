package day02;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		// 성적을 입력받아서 성적에 맞는 학점을 출력하는 코드
		/* 90이상 ~ 100이하 A
		 * 80~90 B
		 * 70~80 C
		 * 60~80 D
		 * 60 under F
		 * 나머지: 잘못된 수
		 * */
		
		Scanner scan = new Scanner(System.in);

		System.out.print("성적을 입력하세요: ");
		int score = scan.nextInt();
		
		if (score<0 || score>100)
			System.out.println("잘못된 점수");
		else if (score>=90)
			System.out.println("A");
		else if (score>=80)
			System.out.println("B");
		else if (score>=70)
			System.out.println("C");
		else if (score>=60)
			System.out.println("D");
		else
			System.out.println("F");
	}

}
