package day13;

public class StringEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcde";
		
		// 0번지에 있는 문자를 반환함
		System.out.println("charAt");
		System.out.println(str.charAt(0));
		
		// 두 문자열이 같은지를 반환함
		System.out.println("\nequals");
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("abcde"));
		
		// 있으면 문자열의 시작 번지를 반환함. 없으면 -1
		System.out.println("\nindexOf");
		System.out.println(str.indexOf("cdf"));
	
		// 있으면 있다, 없으면 없다 반환
		System.out.println("\ncontains");
		System.out.println(str.indexOf("cd"));
		
		// 문자열의 길이를 반환
		System.out.println("\nlength");
		System.out.println(str.length());

		// 문자열을 바꿔서 새 문자열을 반환
		System.out.println("\nreplace");
		String str2 = str.replace("cd", "aa");
		System.out.println(str);
		System.out.println(str2);
		
		// 부분 문자열을 반환함
		// 1번지 부터 3번지 앞까지(2번지 까지)
		System.out.println("\nsubstring");
		String str3 = str.substring(1, 3);
		System.out.println(str);
		System.out.println(str3);
		
		// 대문자로
		System.out.println("\ntoUpperCase");
		String str4 = str.toUpperCase();
		System.out.println(str);
		System.out.println(str4);
		
		// 소문자로
		System.out.println("\ntoLowerCase");
		String str5 = str4.toLowerCase();
		System.out.println(str4);
		System.out.println(str5);
		
		// 시작 문자 앞의 공백을 제거, 마지막 문자 뒤의 공백을 제거
		System.out.println("\ntrim");
		String str6 = "\n\nabc\tdef\t\t";
		System.out.println("str6:"+str6);
		String str7 = str6.trim();
		System.out.println("str7: "+str7);
		
		// 문자열에서 문자열들을 추출해서 배열로 만들기
		System.out.println("\nsplit");
		String fruits = "사과,배,오렌지";
		String []fruitArray = fruits.split(",");
		System.out.println(fruits);
		for(String tmp: fruitArray) {
			System.err.println(tmp);
		}
		
	}

}
