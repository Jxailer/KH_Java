package day12.protected2;

import day12.protected1.A;
// 다른 패키지에 위치하기 때문에 import를 해주어야함.

public class B extends A{

	public void print() {
//		System.out.println(num1); // private (자식 클래스에서도 접근 x)
//		System.out.println(num2); // default (다른 패키지 접근 x)
		System.out.println(num3); // protected (자식 클래스이기에 접근 o)
		System.out.println(num4); // public
		
	}
}
