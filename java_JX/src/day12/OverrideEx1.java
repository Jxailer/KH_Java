package day12;

public class OverrideEx1 {

	public static void main(String[] args) {
		D d = new D();
		d.print1(); // 오버라이딩을 통해 재정의된 메서드가 호출됨
		// print1()은 접근제어자가 protected이기 때문에 같은 패키지 내에서는 실행되지만
		// 다른 패키지에서는 실행이 안됨.
		System.out.println();
		d.print2(); // 오버라이딩을 통해 재정의된 메서드가 호출됨
		System.out.println();
		d.print1(20); // 오버로딩을 통해 추가된 메서드가 호출됨
		
		
		

	}

}
class C{
	protected int num1 = 1, num2 = 2;
	
	protected void print1() {
		System.out.println(num1);
		System.out.println(num2);
	}
	protected void print2() {
		System.out.println(num1);
		System.out.println(num2);
	}
}

class D extends C{
	@Override // 어노테이션 추가는 선택.
	// 어노테이션을 추가할 경우 아래 식이 문법에 맞는 지 확인해준다.
	
//	void print1(int num1) {
//		
//	}
	// 에러가 뜬다.
	/* 1. 매개변수가 부모 클래스에는 없다.
	 * 2. 부모 클래스에서는 접근 제어자가 protected 였는데 default로 변경되었다. 범위가 좁아져서 x
	 * */
	protected void print1() { 
		System.out.println("num1: "+num1);
		System.out.println("num2: "+num2);
	}
	
	// 메서드 오버로드(오버라이드 x)
	protected void print1(int num1) { 
		System.out.println("num1: "+num1);
		System.out.println("num2: "+num2);
	}
	
	public void print2() {
		super.print2(); // 부모 메서드를 가져옴
		System.out.println("B 클래스의 메서드 입니다."); // 추가 작업이 가능함.
	}
}