package day02;

public class LogicalOperatorEx1 {

	public static void main(String[] args) {
		/* && : ~하고, ~이고
		* A && B : A와 B는 참/거짓을 판별할 수 있는 식 또는 변수
		* - 성적이 100이하이고, 성적이 90 이상이면 A. 성적이 95일 때: true 반환.
		* - 100이고 90이다 A, 성적이 95일 때: 무엇이 100이고 90인지 판별할 수 없음. 에러 발생. 
		* - 진리표
		* 	A && B
		* 	T && F == F
		* 	F && F == F
		* 	T && F == F
		* 	T && T == T (둘 다 참일때만 참.)
		* 
		* || : ~이거나, ~하거나
		* - 진리표
		* 	A || B
		* 	T || F == T
		* 	F || F == F
		* 	T || F == T
		* 	T || T == T
		* 
		* ! : ~아닌, 반대
		* - 진리표
		* 	!F == T
		* 	!T == F
		*/
		
		int score = 190; // 성적
		// 성적이 올바른지 확인. 올바른 성적은 0 이상 100 이하이다.
//		boolean valid = (score>=0)&&(score<=100);
//		System.out.println("성적이 올바른가?: "+ valid);
		System.out.println("성적이 올바른가?(and): "+ (score>=0 && score<=100));
		System.out.println("성적이 올바르지 않은가?(not): "+ !(score>=0 && score<=100));
		System.out.println("성적이 올바르지 않은가?(or): "+ (score<0 || score>100));
	}

}
