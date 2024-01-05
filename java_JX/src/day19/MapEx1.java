package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		/* put(k, v)
		 * - k, v값을 이용해서 추가.
		 * - k가 중복되면 v만 수정됨. (k중복 x) 이전 v값을 반환함.
		 * */
		map.put("abc", "def");
		String prev = map.put("abc", "def");
		System.out.println(map);
		System.out.println(prev);
		
		/* get(k): k와 일치하는 v를 리턴함
		 * */
		String str = map.get("abc");
		System.out.println(str);
		
		/* contains(k): k와 일치하는 key가 있는지 지 알려줌
		 * boolean 값 반환*/
		System.out.println(map.containsKey("abc"));
		
		/* remove(k): k와 일치하는 요소를 삭제한 후 value를 반환함*/
		str = map.remove("abc");
		System.out.println(str);
		
		map.put("zxc", "123");
		map.put("gello", "hi");
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
	}

}
