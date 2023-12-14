package day05;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		// 배열 정렬 방법 예제
		int arr[] = new int[] {1, 3, 5, 7, 2, 4, 6, 8};
		int arr2[] = new int[] {1, 3, 5, 7, 2, 4, 6, 8};
		
		// 버블 정렬
		/* 옆에 인접한 값들을 비교하여 정렬하는 방식.
		 * 1 3 5 7 2 4 6 8
		 * 1 3 5 2 4 6 7 [8] // 끝 수를 확정시킴
		 * 1 3 2 4 5 6 [7 8]
		 * */
		System.out.println("버블 소팅 오름차순");
		for(int i = 0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j]=tmp;
				}
			}
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		
		System.out.println("\n\n버블 소팅 내림차순");
		for(int i = 0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j]<arr[j+1]) { // 부등호 방향을 바꿔 내림차순으로 변경
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j]=tmp;
				}
			}
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		System.out.println("\n\nArrays 클래스 활용(퀵 소트): ");
		Arrays.sort(arr2); // arrays라는 클래스에서 제공해주는 정렬 방법
		for(int i =0; i<arr2.length; i++) {
			System.out.print(arr2[i]);
		}
		
	}

}
