package day13;

public class InterfaceEx1 {

	public static void main(String[] args) {
		System.out.println(KiaCar.brand);
		// static 변수들은 객체 생성 없이 호출 가능함.

	}

}

class KiaCar{
	public static String brand = "기아";
}

interface Printer{
//	static void print(); 
// static 메서드는 반드시 구현되어야함. 객체 생성 없이 호출을 할 수도 있기 때문에.
	
	static void print() {
		System.out.println("프린터입니다.");
	}
	
	// static이 붙지 않은 것은 추상메서드여서 구현하지 않거나, default 메서드로 만들어서 구현함.
	void test();
	
	default void test2() {
		
	}
}