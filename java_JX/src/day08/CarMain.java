package day08;

import java.util.Scanner;

public class CarMain {

	public static void main(String[] args) {
		
		
		/* Scanner: 클래스명
		 * scan: 인스턴스명
		 * Scanner(System.in): 표준 입력을 이용하여 초기화를 하는 생성자
		 * Scanner("123\nabc"): 문자열을 이용하여 초기화하는 생성자
		 * */
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner("123\nabc");
		
		/* Car: 클래스명
		 * car: 인스턴스명
		 * new: 인스턴스를 생성하는 연산자
		 * Car(): 생성자. 멤버변수를 초기화함
		 * */
		Car car = new Car();
		car.onOff(); // 시동 켜기
		car.print();
		
		car.turnLight(-1); // 깜빡이 켜기 (좌측)
		car.print();
		car.turnLight(1); // 깜빡이 켜기 (우측)
		car.print();
		car.turnLight(0); // 깜빡이 끄기
		car.print();
		
		for(int i=0; i<10; i++)
			car.accelerate(); // 가속하기
		car.print();
		for(int i=0; i<10; i++)
			car.decelerate(); // 가속하기
		car.print();
		
	}

}
