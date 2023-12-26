package day12;

public class InheritanceEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("K3", "기아", 4);
		c1.print();
		
		KiaCar k1 = new KiaCar("레이", 4);
		k1.print(); 
		// KiaCar 클래스에는 정의되어있지 않은 메서드 이지만, 부모를 상속받아서 사용가능함.
	
		HyundaiCar h1 = new HyundaiCar("아반떼", 4);
		h1.print();
		
	}

}

// 자동차
class Car{
	String name, brand;
	int wheelCount; // 바퀴수
	boolean power;
	int speed;
	
	void turn() {
		power = !power;
	}
	void speed(int speed) {
		this.speed += speed;
	}
	public Car(String name, String brand, int wheelCount) {
		this.brand=brand;
		this.name=name;
		this.wheelCount=wheelCount;
	}
	public Car() {
		
	}
	public void print() {
		System.out.println("회사: "+brand);
		System.out.println("차명: "+name);
		System.out.println();
	}
}
//현대차
//현대차는 자동차이다 (O)
class HyundaiCar extends Car{
	public HyundaiCar(String name, int wheelCount) {
//		brand = "현대";
//		this.name=name;
//		this.wheelCount=wheelCount;
		super(name, "현대", wheelCount);
	}
}

// 기아차
/* 기아차는 자동차이다. (O)*/
class KiaCar extends Car{
	// 코드가 아무것도 없어도 생성자가 자동으로 추가가 되고, super를 통해 부모 생성자가 호출이 되는데
	// 부모 클래스에 기본 생성자가 없으면 에러가 뜸.
//	public KiaCar() {
//		super();
//	}

	public KiaCar(String name, int wheelCount) {
//		brand = "기아";
//		this.name=name;
//		this.wheelCount = wheelCount;
		super(name, "기아", wheelCount);
	}
}

