package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		// 스캐너를 이용하여 국어, 영어, 수학 성적을 입력받고
		// 총점과 평균을 구하는 코드를 작성하세요
		int sum;
		int koreanScore, engScore, mathScore;
		
				
		Scanner scan = new Scanner(System.in);
		System.out.print("국어, 영어, 수학 성적을 입력하세요(예: 80 90 100): ");
		
		koreanScore = scan.nextInt();
		engScore = scan.nextInt();
		mathScore = scan.nextInt();
		
		sum = koreanScore + engScore + mathScore;
		
		System.out.println("총합은: "+ (sum));
		System.out.println("평균은: " + ((double)sum/3));
		
		scan.close();
	}

}
