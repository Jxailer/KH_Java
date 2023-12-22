package day11.product;

import java.util.Scanner;

public class ProductMain {
	/* 제품을 관리하는 프로그램을 구현하세요.
	 * 메뉴
	 * 1. 제품 입고
	 *  - 제품을 판매하기 위해 다른 곳에서 구매함
	 *  - 기존의 있는 제품은 수량 추가, 새 제품은 새로 등록.
	 *  2. 제품 판매
	 *  - 입고된 제품을 판매함
	 *  3. 제품 수정 [가격]
	 *  4. 매출 내역 조회
	 *  5. 종료.
	 * */
	private static Scanner scan = new Scanner(System.in);
	
	private static Product products[] = new Product[10];
	private static int count = 0;
	private static int sales = 0;
	
	public static void main(String[] args) {
		int menu=0;
		
		do {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
			
		}while(menu!=6);

	}

	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//제품 입고
			importProduct();
			break;
		case 2:
			//제품 판매
			sellProduct();
			break;
		case 3:
			//제품 수정
			updateProduct();
			break;
		case 4:
			//매출 내역 조회
			printSales();
			break;
		case 5:
			// 상품 삭제
			deleteProduct();
			break;
		case 6:
			System.out.println("프로그램 종료!");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
	}
	
	
	// 메서드 정의 영역
	
	public static void printMenu() {
		System.out.println("-------------");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 가격 수정");
		System.out.println("4. 매출 조회");
		System.out.println("5. 제품 삭제");
		System.out.println("6. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
	}
	public static void importProduct() {
		System.out.println("--제품 입고--");
		System.out.println("제품 이름: ");
		String name = scan.nextLine();
		System.out.println("제품 가격: ");
		int cost = scan.nextInt();
		scan.nextLine();
		System.out.println("제품 갯수: ");
		int amount = scan.nextInt();
		scan.nextLine();
		
		int i = searchProduct(name);
		if(i<count) {
			int current = products[i].getAmount();
			products[i].setAmount(current+amount);
//			System.out.println("products의 길이: "+count);
			
		}
		else {
			products[i] = new Product(name, cost, amount);
			count++;
//			System.out.println("products의 길이: "+count);
		}
		products[i].printProduct();
		if(count==products.length) {
			expandArr();
		}
		
		
	}
	public static void sellProduct() {
		System.out.println("--제품 구매--");
		System.out.println("현재 상품 목록: ");
		for (int i =0; i<count;i++) {
			System.out.println(products[i].getName());
		}
		System.out.println("-------------");
		System.out.println("구매 제품 이름: ");
		String name = scan.nextLine();
		System.out.println("구매 갯수: ");
		int amount = scan.nextInt();
		scan.nextLine();
		
		int i = searchProduct(name);
		if(i<count) {
			int current = products[i].getAmount();
			if(current<amount) {
				System.out.println("현재 재고는 "+current+"개 입니다. "+current+"개 만큼만 구매합니다. ");
				amount = current;
			}
			int total = amount*products[i].getCost();
			products[i].setAmount(current-amount);
			System.out.println("가격은 총 "+total+"원 입니다.");
			System.out.println("남은 갯수: "+products[i].getAmount());
			sales += total;
			
		}
		else {
			System.out.println("해당 제품이 존재하지 않습니다!");
		}
	}
	public static void updateProduct() {
		System.out.println("--가격 수정--");
		System.out.println("제품 이름: ");
		String name = scan.nextLine();
		System.out.println("수정 가격: ");
		int cost = scan.nextInt();
		scan.nextLine();
		
		int i = searchProduct(name);
		if(i<count) {
			int current = products[i].getCost();
			
			products[i].setCost(cost);
			System.out.println("변경된 가격은 "+products[i].getCost()+"원 입니다.");
			
		}
		else {
			System.out.println("해당 제품이 존재하지 않습니다!");
		}
	}
	public static void printSales() {
		System.out.println("--총 매출--\n"+sales+"원");
	}
	public static void deleteProduct() {
		System.out.println("--제품 삭제--");
		System.out.println("제품 이름: ");
		String name = scan.nextLine();
		
		int i = searchProduct(name);
		if(i<count) {
			if(i==0) {
				
			}
			Product [] tmp = new Product[products.length];
			System.arraycopy(products, 0, tmp, 0, i);
			System.arraycopy(products, i+1, tmp, i, count-i-1);
			count--;
			products=tmp;
		}
		else {
			System.out.println("해당 제품이 존재하지 않습니다!");
		}
		
		System.out.println("수정된 제품 목록: ");
		for(int j = 0; j<count; j++) {
			System.out.println((j+1)+". ----------");
			products[j].printProduct();
		}
		
	}
	
	public static void expandArr() {
		Product tmp [] = new Product[products.length+10]; // 기존 상품 목록 보다 더 큰 목록 생성
		System.arraycopy(products, 0, tmp, 0, count); // 기존 기록을 새 기록에 복사
		products=tmp;
		System.out.println("배열의 길이: "+products.length);
	}
	
	public static int searchProduct(String name) {
		int i;
		for(i=0; i<count;i++) {
			if(products[i].getName().equals(name)) {
//				System.out.println(i);
				return i;
			}
				
		}
		return count;
	}
	
}
