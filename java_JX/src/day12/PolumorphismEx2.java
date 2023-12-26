package day12;

public class PolumorphismEx2 {

	public static void main(String[] args) {
		// 다형성 예제
		/* 2. 포함 다형성
		 *  - 자식 인스턴스들을 부모 인스턴스가 관리하는 것.
		 * 
		 * 
		 * 그려진 도형들을 관리
		 * ex. 사각형>타원>선>선>사각형 순으로 그렸다면, 그린 순서대로 관리함.*/
		Rect[] rects = new Rect[10];
		Ellipse[] ellipses = new Ellipse[10];
		Line[] lines = new Line[10];
		int rectCount = 0, ellipsesCount =0, lineCount =0;
		int count = 0;
		
		// 도형 그리기 (다형성 이용 x)
		rects[rectCount++] = new Rect(); 
		ellipses[ellipsesCount++] = new Ellipse(); 
		lines[lineCount++] = new Line(); 
		lines[lineCount++] = new Line(); 
		rects[rectCount++] = new Rect(); 
		
		// 도형 그리기 (다형성 이용)
		Shape [] shapes = new Shape[30];
		
		shapes[count++] = new Rect(); 
		shapes[count++] = new Ellipse(); 
		shapes[count++] = new Line(); 
		shapes[count++] = new Line(); 
		shapes[count++] = new Rect(); 
		
		for(int i = 0; i<count; i++) {
			shapes[i].draw();
		}
	}

}
class Shape{
	void draw() {
		
	}
}

class Rect extends Shape{
	void draw() {
		System.out.println("사각형");
	}
}
class Ellipse extends Shape{
	void draw() {
		System.out.println("타원");
	}
}
class Line extends Shape{
	void draw() {
		System.out.println("선");
	}
}