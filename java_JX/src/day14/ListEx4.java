package day14;

import java.util.ArrayList;
import java.util.Comparator;

public class ListEx4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(1);
		list.add(5);
		list.add(5);
		list.add(8);
		list.add(5);
		list.add(-10);
		list.add(100);
		list.add(2135);
		
		
		System.out.println(list); // 반복문을 이용하지 않아도 내용을 출력할 수 있음.
		
		// indexOf(A): A와 일치하는 요소가 몇 번지에 있는지 알려주는 메서드. 없으면 -1 반환.
		System.out.println();
		System.out.println(list.indexOf(10));
		
		// contains(A): A와 일치하는 요소가 있는지 없는 지를 알려주는 메서드. 없으면 -1 반환.
		System.out.println();
		System.out.println(list.contains(2));
		
		// remove(A): A요소를 삭제하고 삭제 여부를 알려줌.
		// remove(index) : index 번지 에있는 요소를 삭제후, index번지에 있는 요소를 반환함.
		System.out.println();
		list.remove(new Integer(10)); // 사용되지 않는 방법. (구버전)
		list.remove(1);
		System.out.println(list);
		
		// sort(Comparator<? super Integer> c) : 
		// 비교기준이 있는 메서드를 가진 Comparator 인트페이스를 구현한 구현 클래스의 인스턴스가 와야함.
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1 - o2;
			}
			
		});
		System.out.println(list);
	}

}
