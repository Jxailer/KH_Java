package day13;

public class MathEx2 {

	public static void main(String[] args) {
		// 주어진 실수의 소수점 3자리에서 올림한 값을 출력하는 코드를 작성하세요
		double num = 123.4567;
		System.out.println("반올림 전: "+num);
		num *= 100;
		num = Math.ceil(num);
		num/=100;
		System.out.println("반올림 후: "+num);
		
		// 주어진 실수의 n자리에서 올림한 값을 출력하세요
		double num2 = 1.234567;
		int n = 3;
		int pow = (int) Math.pow(10, n-1);
		System.out.println(pow);
		
		System.out.println("반올림 전: "+num2);
		num2 *= pow;
		num2 = Math.ceil(num2);
		num2 /= pow;
		System.out.println("반올림 후: "+num2);

	}

}
