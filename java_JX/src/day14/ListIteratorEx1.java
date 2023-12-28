package day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorEx1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(); // 업캐스팅
		
		list.add(123);
		list.add(33);
		list.add(11233);
		list.add(12123);
		list.add(11243);
		list.add(141223);
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()){
			Integer tmp = it.next();
			System.out.println(tmp);
		}

	}

}
