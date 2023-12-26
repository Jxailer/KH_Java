package day12.protected2;

import day12.protected1.A;
//다른 패키지에 위치하기 때문에 import를 해주어야함.

public class ProtectedEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* num1 : private
		 * num2 : default
		 * num3 : protected
		 * num4 : public
		 * */
		
		A a = new A();
//		a.num1 = 1;
//		a.num2 = 2;
//		a.num3 = 3;
		a.num4 = 4;
		
		B b = new B();
//		b.num1 = 1;
//		b.num2 = 2; 
		// default인 num2는 B와 protectedEx1가 같은 패키지 이기 때문에 접근할 수 있지 않을까?
//		// 애초에 B도 num2에 접근할 수가 없음.
//		b.num3 = 3; 
		// 같은 패키지 이지만 Protected Ex1이 B클래스의 자식 클래스가 아니기 때문에 접근 x
		b.num4 = 4;
		
	}

}
