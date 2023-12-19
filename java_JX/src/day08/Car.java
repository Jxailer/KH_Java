package day08;

public class Car {
	/* 정보: 무게(톤), 브랜드, 분류, 색상, 바퀴, 자동차 이름, 년식
	 * 멤버 변수
	 */

	// 멤버 변수는 메서드 내의 변수(지역변수)와의 색상이 다름.
	double weight; 
	String brand;
	String category;
	// 0xff0000
	// int color;
	String color;
	String [] tires;
	String carName;
	int year;

	 /* 기능: 가속, 감속, 시동 켜기/끄기, 좌측/우측 깜빡이를 켜기/끄기
	 * 메서드
	 * */
	boolean power;
	int speed;
	boolean leftLight, rightLight;
	
	
	// 시동을 켜기/끄기
	// 시동이 꺼져있으면 켜고, 켜져있으면 끄기.
	
	public void onOff() {
		power = !power;
//		if(this.power==false)
//			this.power=true;
//		else
//			this.power=false;
		if(power)
		{
			System.out.println("시동이 켜졌습니다.");
		}else
			System.out.println("시동이 꺼졌습니다.");
	}
	// 가속
	public void accelerate() {
		speed++;
	}
	// 감속
	public void decelerate() {
		speed--;
	}
	// 깜빡이 켜기끄기. 위:우측1, 가운데0, 아래:좌측-1
	public void turnLight(int direc) {
		switch(direc) {
		case 1:
			rightLight = true;
			leftLight = false;
			break;
		case 0:
			rightLight = false;
			leftLight = false;
			break;
		case -1:
			rightLight = false;
			leftLight = true;
			break;
		}
	}
	
	// 자동차 현재 상태 출력
	public void print() {
		System.out.println("---------------------");
		System.out.println("시동: "+ power);
		System.out.println("속력: "+ speed);
		System.out.println("좌깜: "+ leftLight);
		System.out.println("우깜: "+ rightLight);
		
	}
	
}
