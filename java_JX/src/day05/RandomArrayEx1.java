package day05;

public class RandomArrayEx1 {

	public static void main(String[] args) {
		// 1~9 사이의 랜덤한 수를 3개 생성해서 배열에 저장하는 코드
		
		int arr1[] = new int[3];
		int max = 9, min = 1;
		
		for(int i = 0; i<arr1.length; i++)
			arr1[i] = (int)(Math.random()*(max-min+1)+min);

		for(int i = 0; i<arr1.length; i++) 
			System.out.print(arr1[i]+" ");
		

	}

}
