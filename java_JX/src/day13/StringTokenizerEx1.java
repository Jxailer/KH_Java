package day13;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {

	public static void main(String[] args) {
		String fruits = "사과,매,오렌지";
		String [] fruit = fruits.split(",");
		
		StringTokenizer st = new StringTokenizer(fruits, ",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		for(String tmp:fruit) {
			System.out.println(tmp);
		}
	}

}
