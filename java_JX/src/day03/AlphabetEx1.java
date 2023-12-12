package day03;

public class AlphabetEx1 {

	public static void main(String[] args) {
		/* a부터 Z까지 반복문을 이용하여 출력하는 코드를 작성하세요
		 * */
		
		char ch = 0x61; // 'a'
		System.out.println("소문자 출력: ");
		while(true) { // for(char ch = 'a' ; ch<='z'; ch++)
			System.out.print(ch+" ");
			ch++;
			
			if(ch == 0x7B) { // 'z'이후의 것
				System.out.println();
				ch = 0x41; // 'A'
				System.out.println("\n대문자 출력: ");
			}
			if(ch == 0x5B) { // 'Z' 이후의 것
				System.out.println("\n\n출력 완료.");
				break;
			}
		}

	}

}
