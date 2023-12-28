package day14;

import lombok.Data;

public class ExceptionEx4 {

	public static void main(String[] args) {
		try {
			test();
		} catch (MyException e) {
			
			e.print();
			e.printStackTrace(); // 붉은 에러문구를 띄우지만 프로그램을 종료시키지는 않음.
		}
		System.out.println("종료");
	}
	public static void test() throws MyException{ // 예외가 발생할 수 밖에 없는 메서드라서 생략 불가
		throw new MyException("안녕하세요", "예외 발생");
	}
}

// 사용자 정의 예외 클래스
@Data
class MyException extends Exception{
	private String title;
	
	public MyException() {	}
	public MyException(String title, String message) {
		super(message);
		this.title = title;
	}
	
	public void print() {
		System.out.println(title);
		System.out.println(getMessage());
	}
	
}


