package day10;

public class InitEx1 {

	public static void main(String[] args) {
		B b = new B();
		
		System.out.println(b.num1); // num1은 int의 기본값으로 초기화됨.
		System.out.println(B.num2); // num2는 int의 기본값으로 초기화됨.
		System.out.println(b.num3); // num3은 int의 기본값으로 초기화됨 => 명시적 초기화로 덮어씀
		System.out.println(B.num4); // num4는 int의 기본값으로 초기화됨 => 명시적 초기화로 덮어씀
		System.out.println(b.num5); // num5는 int의 기본값으로 초기화됨 => 명시적 초기화로 덮어씀 => 초기화 블록에서 수정됨.
		System.out.println(B.num6); // num6은 int의 기본값으로 초기화됨 => 명시적 초기화로 덮어씀 => 초기화 블록에서 수정됨.

		System.out.println(b.num7); 
		// num6은 int의 기본값으로 초기화됨 => 명시적 초기화로 덮어씀 => 초기화 블록에서 수정됨. => 생성자에서 초기화됨.
	}

}

class B{
	int num1;
	int num3 = 1;
	int num5 = 10;
	int num7 = 30;
	
	// 초기화 블록
	{
		num5 = 3;
		num7 = 500;
	}
	static int num2;
	static int num4 = 2;
	static int num6 = 20;
	static {
		num6 = 4;
	}
	public B() {
		num7 = 5;
	}
}
