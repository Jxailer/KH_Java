package day13.program;

public interface Program {
	int num1=10; // final static 생략.
	final static int num2 = 20;
	
	void printMenu();
	public void runMenu(int menu);
	public abstract void printExit();
	void run();
}

class TestA{
	// 클래스에서는 final static을 생략하면 멤버변수가 됨. 붙여주면 상수가 됨.
	int num1=10; // 상수는 직접 초기화해야함.
	final static int  num2 = 20;
	// 클래스에서는 추상 메서드에 자동으로 abstract가 추가되지 않는다.
	// 그리고 추상 메서드가 있는 클래스는 추상 클래스가 된다. 클래스를 선언할 때 abstract 를 붙여줘야 한다.
//	public abstract void printMenu();
}
