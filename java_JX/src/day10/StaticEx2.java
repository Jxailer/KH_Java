package day10;

public class StaticEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum1(1,2));
//		System.out.println(sum2(1,2)); // 메서드가 static하지 않기 때문에 에러가 발생함.
		
		StaticEx2 ex = new StaticEx2(); // 생성자를 사용해야함.
		System.out.println(ex.sum2(1, 3));
	}
	
	
	public static int sum1(int num1, int num2) {
		return num1+num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1+num2;
	}

	// 인스턴스 메서드: static 하지 않음. static이 안붙어도, static 하지 않은 메서드를 사용할 수 있음.
	// 
	public void test() {
		System.out.println(sum1(1,2));
		System.out.println(sum2(1,2));
	}
}
