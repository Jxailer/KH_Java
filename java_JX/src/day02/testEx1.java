package day02;

public class testEx1 {
	public static void main (String [] ar) {
		// 다음 코드를 이용하여 국어, 영어, 수학 성적의 평균을 구하여 콘솔에 출력하는 코드를 작성하시오
		
		int korScore = 100, engScore = 50, mathScore = 92;
		float sum;
		sum = korScore + engScore + mathScore;
		System.out.println(sum);
		System.out.println("평균은: " +  sum / 3.0);
		
	}
}
