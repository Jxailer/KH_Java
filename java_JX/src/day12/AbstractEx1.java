package day12;

public class AbstractEx1 {

	public static void main(String[] args) {
		// 추상 메서드 예제
//		AA aa1 = new AA(); // 추상 메서드가 없더라도, 직접 인스턴스를 만들 수가 없다.
		
		// 추상 클래스의 인스턴스를 만들려면 
		// 1. 익명 클래스를 이용하거나,
		AA aa1 = new AA() { // 익명 클래스 (재사용 불가)
			
		};
		
		AA aa2 = new CA();
		
		DA da1 = new DA();
		da1.print();
		
		// 2. 추상 클래스를 상속받은 일반 클래스를 생성해서 인스턴스를 생성함.
	}

}

abstract class AA{
	int num;
}
abstract class AB{
	int num;
	public abstract void print();
}

class CA extends AA{
	
}
class DA extends AB{
	// AB 클래스에 추상메서드가 있어서 에러가 뜸.
	/* 1. DA를 추상 클래스로 만들거나
	 * 2. 추상 메서드(print)를 재정의(오버라이드) 해야함
	 * */
	
	@Override
	public void print() {
		System.out.println("num: "+num);
	}
}