package day05;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		// 학생 5명의 국어 성적을 저장하기 위한 배열을 만들기
		Scanner scan = new Scanner(System.in);
		
		int korScore [] = new int[5];
//		korScore[0] = scan.nextInt();
//		korScore[1] = scan.nextInt();
//		korScore[2] = scan.nextInt();
//		korScore[3] = scan.nextInt();
//		korScore[4] = scan.nextInt();
		
		for (int i = 0; i<5; i++) {
			System.out.print("학생"+(i+1)+"의 성적: ");
			korScore[i] = scan.nextInt();
	
		}
		System.out.println();
		for (int i = 0; i<5; i++) {
			System.out.println("학생"+(i+1)+"의 성적: "+korScore[i]);
		}
		
		scan.close();
	}
}
