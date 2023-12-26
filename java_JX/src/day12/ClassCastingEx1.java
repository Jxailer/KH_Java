package day12;

public class ClassCastingEx1 {

	public static void main(String[] args) {
		// 클래스 형 변환 예제
		// 업 캐스팅: 묵시적 클래스 형변환
		Parent p1 = new Child(1,2);
		p1.print(); // 부모 클래스에도 있음.
//		p1.print2(); // 자식 클래스에만 있기 때문에, 부모 인스턴스가 접근 할 수 없음.

		// 다운 캐스팅: 명시적 클래스 형 변환
//		Child c2 = new Parent(1); // 형변환을 명시해야함.
		
		// 예외가 발생: 클래스 다운 캐스팅은 조건부로 가능함.
		// 부모 인스턴스를 자식 인스턴스에 저장하려고 할 때
		
//		예외가 발생함. (Parent 클래스에는 num2가 없어서.)
//		Child c2 = (Child) new Parent(1); 
//		c2.print();
		
		/* 다운 캐스팅이 가능하려면
		 * 1. 업캐스팅으로, 부모 인스턴스에 자식 인스턴스가 저장되어야함.*/
		Parent p3 = new Child(10, 20);
		System.out.println();
		p3.print(); // Child의 print()를 호출함.
		
//		2. 업캐스팅 된 부모 인스턴스를 자식 인스턴스에 저장함. (다운캐스팅)
		Child c3 = (Child)p3;
		System.out.println();
		c3.print();
		System.out.println();
		c3.print2();
		
		Parent p4 = new Child(30, 40);
		System.out.println();
		// 다운캐스팅을 통해 부모 인스턴스로, 자식 인스턴스의 메서드인 print2를 호출함.
		((Child)p4).print2();
		
	}

}

class Parent{
	int num1;
	void print() {
		System.out.println(num1);
	}
	public Parent(int num1) {
		this.num1 = num1;
	}
}

class Child extends Parent{
	int num2;
	void print() {
		super.print();
		System.out.println(num2);
	}
	void print2() {
		System.out.println("자식 클래스 메서드 입니다.");
	}
	public Child(int num1, int num2) {
		super(num1);
		this.num2=num2;
	}
}
