package day12;

public class PolumorphismEx1 {

	public static void main(String[] args) {
		// 다형성 예제
		/* 1. 매개변수의 다형성
		 * 2. 
		 * */
		Remocon r = new Remocon();
		
		Tv tv = new Tv();
		AirCon aricon = new AirCon();
		Projector proj = new Projector();
		Phone phone = new Phone();
		
		r.turnOn(tv);
		r.turnOn(aricon);
		r.turnOn(proj);
		r.turnOn(phone);
		
		System.out.println();
		phone.turnOn();
	}

}

// 리모컨: TV나 에어컨 등을 켜는 기기
class Remocon{
//	void turnOn(Tv target) {
//		System.out.println("제품이 켜졌습니다.");
//	}
//	void turnOn(AirCon target) {
//		System.out.println("제품이 켜졌습니다.");
//	}
//	
	// 매개변수의 다형성을 이용하여 turnOn 메서드를 1개만 생성함.
	void turnOn(ElecProduct target) {
		if(target instanceof Tv) {
			System.out.println("TV 제품이 켜졌습니다."); 
		}else if(target instanceof AirCon) {
			System.out.println("에어컨 제품이 켜졌습니다."); 
		}else if(target instanceof Projector) {
			System.out.println("프로젝터 제품이 켜졌습니다."); 
		}else {
			System.out.println("전자 제품이 켜졌습니다."); 
			target.print();
		}
	}
}
class ElecProduct{
	void print() {
		System.out.println("123");
	}
	
}

class Tv extends ElecProduct{
	
}

class AirCon extends ElecProduct{
	
}

class Projector extends ElecProduct{
	
}
class Phone extends ElecProduct{
	void turnOn() {
		System.out.println("123123");
	}
}
