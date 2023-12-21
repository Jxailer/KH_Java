package day10;

public class SingleTonEx1 {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.getStr());
		s.setStr("abc");
		System.out.println(s.getStr());

		Singleton s2 = Singleton.getInstance();
		// str의 초기값인 "Hi"가 아닌, 앞에서 수정한 abc가 수정됨.
		System.out.println(s2.getStr());
		
		// 싱글톤 클래스의 인스턴스 s와 s2는 static한 같은 인스턴스를 공유하고 있기 때문에
		// s2에서 값을 수정하면 s에서 변경된 값을 확인할 수 있음.
		s2.setStr("def");
		System.out.println(s.getStr());
	}

}

class Singleton{
	// 본인 class의 인스턴스를 static으로 선언함
	private static Singleton singleton = new Singleton();
	private String str;
	
	// 생성자의 접근 제어자가 private
	private Singleton() {
		str = "Hi";
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str=str;
	}
}
