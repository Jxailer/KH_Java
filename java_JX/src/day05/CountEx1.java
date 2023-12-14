package day05;

import java.util.Scanner;

public class CountEx1 {

	public static void main(String[] args) {
		// 1에서 9 사이의 정수를 5개 입력받아, 각 숫자가 몇 개 씩 입력됐는지를 출력하는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = 5;
		int arr1 [] = new int [num1];
		int numArr[] = new int [10];
		
		System.out.print("정수를 "+num1+"개 입력하세요: ");
		for(int i =0; i<num1; i++) {
			arr1[i]=scan.nextInt();
			numArr[arr1[i]-1]++;
		}
		
		for (int i =1; i<numArr.length; i++)
			System.out.println((i)+" : "+numArr[i-1]+" 개");

		System.out.println("\n\n\n");
		
		
	}

}
