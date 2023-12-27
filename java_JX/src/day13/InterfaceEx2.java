package day13;

public class InterfaceEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(new Product());
		System.out.println();
		print(new Student());
	}

	public static void print(Print p) {
		p.print();
	}
}

interface Print{
	void print();
}

class Product implements Print{

	String name = "TV";
	String code = "TV001";
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("제품명: "+name);
		System.out.println("제품코드: "+code);
	}
	
}

class Student implements Print{
	int grade = 1, classNum = 1, num=1;
	String name="홍길동";
	
	@Override
	public void print() {
		System.out.println("이름: "+name);
		System.out.println("학년/반/번호: "+grade+" "+classNum+" "+num);
		
	}
	
}
