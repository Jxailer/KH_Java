package day05;

public class RandomArrayEx2 {

	public static void main(String[] args) {
		// 1~9 사이에 중복되지 않은 랜덤한 수 3개를 저장하는 예제
		int arr1[] = new int[3];
		int max = 9, min = 1;
		int r;
		int count = 0; // 배열에 저장된 중복되지 않은 수의 개수
		
		while(count<3) {
			count=0;
			for(int i = 0; i<arr1.length; i++) 
				arr1[i] = (int)(Math.random()*(max-min+1)+min);
			
				if(arr1[0]!=arr1[1])
					count++;
				if(arr1[1]!=arr1[2])
					count++;
				if(arr1[2]!=arr1[0])
					count++;
		}
		
		for(int i = 0; i<arr1.length; i++) 
			System.out.print(arr1[i]+" ");
		
		 // 다음 예제를 위해 array 0으로 초기화
		for(int i = 0; i<arr1.length; i++)
			arr1[i]=0;
		System.out.println("\n\n다른방법: ");
		
		
		boolean dup=false;
		count=0;
		while(count<arr1.length) {
			r = (int)(Math.random()*(max-min+1)+min);
//			System.out.println(1);
			for(int i=0; i<count;i++) {
//				System.out.println(2);
				if(arr1[i]==r) {
					dup=true;
					break;
				}
				
			}
			if (!dup) {
				arr1[count] = r;
				count++;
			}
			
		}
		
		
		for(int i = 0; i<arr1.length; i++) 
			System.out.print(arr1[i]+" ");
		
		
		
		
			}


}
