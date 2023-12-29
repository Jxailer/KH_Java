package day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LamdaEx2 {

	public static void main(String[] args) {
		// 람다식을 이용하여 리스트를 정렬하는 예제
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1123);
		list.add(13);
		list.add(112);
		list.add(1126);
		list.add(641);
		list.add(21);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(list);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.addAll(list);
		
		
		System.out.println("정렬 전: "+list);
		
		// 방법 1로 정렬 및 출력
		// 구현 클래스를 만들기.
		list.sort(new ListA());
		System.out.println("방법 1 정렬 후: "+list);
		
		// 방법 2로 정렬 및 출력
		list2.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		System.out.println("방법 2 정렬 후: "+list2);
		
		// 방법 3으로 정렬 및 출력
		list3.sort((o1,o2)->{
			return o1-o2;
		});
		System.out.println("방법 3 정렬 후: "+list3);
		
		// 방법 3-1로 정렬 및 출력 (람다식의 간결화)
		list.sort((o1,o2)-> o1-o2);
	}

}

class ListA implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}


	
	
}