package day10;

public class StaticEx1 {

	public static void main(String[] args) {
		KiaCar c1 = new KiaCar("모닝");
		KiaCar c2 = new KiaCar("레이");
		KiaCar c3 = new KiaCar("K3");
		
		c1.brand="기아";
		//KiaCar에서  brand는 static이 아니기 때문에 인스턴스 마다 brand를 수정해야함.
		c2.brand="기아";
		c3.brand="기아";
		
		c1.print();
		c2.print();
		c3.print();
		System.out.println("====================");
		
		KiaCar2 c4 = new KiaCar2("모닝");
		KiaCar2 c5 = new KiaCar2("레이");
		KiaCar2 c6 = new KiaCar2("K3");
		
		KiaCar2.brand = "기아"; 	// static 변수는 클래스를 통해서 brand 변수에 접근함.
//		c4.brand="기아"; 			// 인스턴스를 통해도 되지만 클래스 접근을 권장함.
		//KiaCar에서  brand는 static이기 때문에 한 인스턴스의 brand만 변경해도 다른 인스턴스의 값도 수정됨.
//		c5.brand="기아";
//		c6.brand="기아";
	
		c4.print();
		c5.print();
		c6.print();
	}

}

class KiaCar{
	public String brand = "KIA";
	public String name; // 차 이름
	
	public KiaCar(String name) {
		this.name=name;
	}
	public void print() {
		System.out.println(brand);
		System.out.println(name+"\n-------------");
		
	}
}

class KiaCar2{
	public static String brand = "KIA";
	public String name; // 차 이름
	
	public KiaCar2(String name) {
		this.name=name;
	}
	public void print() {
		System.out.println(brand);
		System.out.println(name+"\n-------------");
		
	}
}
