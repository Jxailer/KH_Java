package day14.lottoEx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoEx1 {
	public static Scanner scan = new Scanner(System.in);
	public static int min=1, max = 45;
	public static Set<Integer> lotto = new HashSet<Integer>();
	public static ArrayList<Integer> userLotto = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성
		 * 단, 컬렉션을 이용한다.
		 * 
		 * 당첨번호: 6개 + 보너스 1개
		 * 사용자: 6개
		 * */
		random();
		printSet(lotto);
		enter();
		printArr(userLotto);
		compare(lotto, userLotto);
		
		

	}
	
	private static void compare(Set<Integer> set, ArrayList<Integer> list) {
		Iterator<Integer> it = set.iterator();
		int count=0;
		for(int i =0; i<lotto.size(); i++) {
			int tmp = it.next();
			if(tmp==list.get(i)) {
				count++;
			}
		}
		result(count);
		
	}

	private static void result(int count) {
		if(count==6) {
			System.out.println("1등입니다!");
		}
		else if(count==4) {
			System.out.println("3등입니다!");
		}
		
	}

	public static void random() {
		while(lotto.size()<6) {
			Random random= new Random();
			int tmp = random.nextInt(max - min + 1)+min;
			lotto.add(tmp);
		}
	}
	
	public static void printArr(ArrayList<Integer> list) {
		System.out.print("번호는: ");
		for(int i=0; i<list.size(); i++) {
			//get(index): index번지에 있는 인스턴스를 가져옴
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void printSet(Set<Integer> lotto2) {
		Iterator<Integer> it = lotto2.iterator();
		while(it.hasNext()) {
			int tmp = it.next();
			System.out.print(tmp+" ");
		}
		System.out.println();
	}
	
	public static void enter() {
		System.out.print("번호를 입력하세요: ");
		for(int i = 0; i<6; i++) {
			int tmp = scan.nextInt();
			userLotto.add(tmp);
		}
		scan.nextLine();
	}

}
