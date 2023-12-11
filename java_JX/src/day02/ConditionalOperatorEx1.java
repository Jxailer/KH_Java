package day02;

public class ConditionalOperatorEx1 {
	public static void main (String [] ar) {
		// 조건 선택 연산자
		/* 성적이 A인지 아닌지를 판별하는 예제
		 * 성적이 100 이하이고 90이상이면 A, 아니면 A가 아님
		 * */
		
		int score = 90;
		String result = "";
		result = score <=100 && score >= 90 ? "A 학점입니다." : "A 학점이 아닙니다." ;
		
		System.out.println(result);
	}
	
}
