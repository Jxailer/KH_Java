package day07;

import java.util.Scanner;

public class ArrayMethodEx1 {

	public static void main(String[] args) {
		// 1~45 사이의 중복되지 않은 랜덤한 수를 6개 만드는 코드를 작성하기 (메서드 이용)
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 45, length=6;
		int r, enter;
		int [] numbers = new int[length];
		int [] userNumbers = new int[length];
		for(int i=0; i<length; ) {
			r = random(min, max); 
			if(!contains(r, numbers, i)) {
				numbers[i] = r;
				i++;
			}
			
		}
		
		for(int i = 0; i<length; i++) {
			System.out.print(numbers[i]+" ");
		}
		
		
		// 1~45 사이의 중복되지 않은 수 6개를 입력하는 코드를 작성하세요 (메서드 이용)
		for(int i = 0; i<length; ) {
			System.out.print("\n\n"+(i+1)+"번째 수를 입력하세요(1~45): ");
			enter = scan.nextInt();
			if (enter>max||enter<min) {
				System.out.println("범위 내의 수를 다시 입력해주세요. "+(i+1)+"번째 수: ");
				continue;
			}
			
			if(!contains(enter, userNumbers, i)) {
				userNumbers[i] = enter;
				i++;
			}
			else {
				System.out.print("\n중복된 숫자입니다. "+(i+1)+"번째 숫자를 다시 입력해주세요: ");
			}
		}
		
		System.out.print("\n\n입력된 숫자입니다: ");
		for(int i = 0; i<length; i++) {
			System.out.print(userNumbers[i]+" ");
		}
		scan.close();
	}
	
	// 일정 범위 사이의 중복되지 않은 랜덤한 수를 배열에 만들어주고, 생성 여부를 알려주는 메서드
	public static boolean createRandomArray(int min, int max, int [] array){
		//배열의 크기가 min~max사이가 아닐 때
		if(array.length>max - min + 1) {
			return false;
		}
		// 반복문: 저장된 숫자의 개수가 배열의 크기보다 작을 때 반복
		int count = 0;
		while(count < array.length) {
			// 랜덤 번호 생성
			int r = random(min, max);
		
			// 중복 확인
				
				if(contains(r, array, count)) {
					//중복되지 않으면 배열에 저장
					array[count]=r;
					//저장된 숫자의 개수를 1 증가
					count++;
				}
				
		}
		return true;
	}
	
	// 중복 확인. 중복이면 true 반환
	public static boolean contains(int num, int [] array, int count) {
		int i;
		
		if(array == null || array.length == 0){ // 배열 생성이 안됐거나 크기가 0이면
			return false;
		}
		if(array.length<count) {
			count = array.length;
		}
		for(i=0; i<count;i++) {
			if(array[i] == num) {
				return true;
			}
		}
//		if(i == count) { // 중복되지 않음. 위의 for문이 정상 종료됨.
			return false;
//			array[count]= num; // 후위연산자의 특징을 이용해 코드를 1줄 줄임.
//		}
		
	}
	
	// 범위 내의 랜덤한 수를 생성
	public static int random(int min, int max) {
		if(max<min) {
			return (int)(Math.random()*(min-max+1)+max);
		}
		return (int)(Math.random()*(max-min+1)+min);
	}

}
