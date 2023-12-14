package day05;

import java.util.Scanner;

public class ArrayScoreEx1 {

	public static void main(String[] args) {
		// 학생 5명의 성적을 입력받고 총점과 평균을 구하는 코드를 작성하세요

		Scanner scan = new Scanner(System.in);
		
		int sum=0;
		int studentNum = 5;
		int korScore [] = new int[studentNum];
		
		for (int i = 0; i<studentNum; i++) {
			System.out.print("학생"+(i+1)+"의 성적: ");
			korScore[i] = scan.nextInt();
		}
		System.out.println();
		for (int i = 0; i<studentNum; i++) {
			sum += korScore[i];
		}
		System.out.println("학생들의 점수 총합: "+ sum);
		System.out.println("학생들의 점수 평균: "+ sum/(double)korScore.length);
		
		scan.close();
	}

}
