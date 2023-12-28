package day14;

import java.util.ArrayList;

public class ListEx1 {

	public static void main(String[] args) {
//		List<Integer> list = new List<Integer>(); 
		// 리스트는 인터페이스라서 인스턴스 직접 생성이 불가능함.
		
		// ArrayList는 List의 구현 클래스.
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			list.add(i+1);
		}
		for(int i=0; i<list.size(); i++) {
			//get(index): index번지에 있는 인스턴스를 가져옴
			System.out.print(list.get(i)+" ");
		}
	}

}
