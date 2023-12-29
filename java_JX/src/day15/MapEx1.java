package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("abc123", "123!");
		map.put("abc123", "121233!");
		map.put("abc1223", "123!");
		map.put("abc1123", "123!");
		map.put("admin", "admin");
		map.put("def", "def");
		
		// 키 값에 해당하는 요소를 삭제하고 반환함.
		System.out.println();
		System.out.println(map.remove("abc123"));
		System.out.println(map);
		
		// map의 키값들을 모아 Set으로 만듦.
		// keySet을 이용한 반복문 예제
		System.out.println();
		Set<String> keySet = map.keySet(); 
		for(String tmp: keySet) {
			String value = map.get(tmp);
			System.out.print(value+", ");
		}
		
		//entrySet을 이용한 반복문 예제
		System.out.println("\n");
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		for(Map.Entry<String, String> tmp : entrySet) {
			System.out.print(tmp.getKey()+" ");
		}
		
		// 내부 클래스의 인스턴스를 생성하는 예제
		A a = new A();
		A.B b = a.new B();
	}

}
class Entry1<K, V>{
	V key;
	V value;
}

// 내부 클래스
class A{
	public class B{
		
	}
}
