package day14;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;

public class ListEx5 {

	public static void main(String[] args) {
		List<A> list = new ArrayList<A>();
		list.add(new A(1));
		list.add(new A(10));
	
		System.out.println(list.indexOf(new A(1)));
		/*contains와 indexOf는 A 클래스의 equals를 이용하여
		 * 두 인스턴스가 같은지 다른지를 비교한다.
		 * 따라서 @EqualsAndHashCode가 없으면 위치값이 달라서
		 * -1을 반환한다.
		 * 
		 * 일반적으로 클래스에 equals를 오버라이딩 하는 것이 좋다.*/
	}

}

@EqualsAndHashCode // 
class A{
	private int num =1;
	
	public void print() {
		System.out.println(num);
	}
	
	public A(int num) {
		this.num = num;
	}
}
