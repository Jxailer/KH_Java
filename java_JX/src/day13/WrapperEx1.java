package day13;

public class WrapperEx1 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = 2;
		num2 = null;
		num2 = num1;
		System.out.println(num2);
		
		// 문자열을 정수로
		String str = "12345";
		int num3 = Integer.parseInt(str);
		System.out.println(num3);

	}

}
