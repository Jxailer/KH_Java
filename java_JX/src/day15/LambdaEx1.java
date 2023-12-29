package day15;

public class LambdaEx1 {

	public static void main(String[] args) {
		// 인터페이스의 인스턴스를 생성하기 위해 구현 클래스 ClassA를 추가한 후,
		// ClassA를 이용하여 인스턴스를 생성함.
		InterfaceA ia1 = new ClassA();
		ia1.print();
		
		
		// 익명 클래스를 추가해서 인스턴스를 생성함.
		InterfaceA ia2 = new InterfaceA() {
			
			@Override
			public void print() {
				System.out.println("안녕하세요");
				
			}
		};
		ia2.print();
		
		// 람다식이용하기 2. 
		// main 메서드가 있는 클래스에서, 1번 과정에서 생성한 인터페이스를 구현한 익명 클래스 객체를 생성함.
		InterfaceA ia3 = ()->{
			System.out.println("안녕하세요");
		};
		
		// 람다식 이용하기 3.
		// 2번에서 생성한 객체를 이용하여 기능을 호출함.
		ia3.print();
		
		
	}

}


// 람다식 이용하기 1. 추상메서드가 1개인 인터페이스를 생성함
interface InterfaceA{
	
	// public abstract는 자동으로 생성됨.
	void print();
}
class ClassA implements InterfaceA{

	@Override
	public void print() {
		System.out.println("안녕하세요");
		
	}
	
}