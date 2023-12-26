package day12.product;

import java.util.Scanner;

public class ProductMain {

	public static Scanner scan = new Scanner(System.in);
	public static int menu = 0;
	
	public static Product products[] = new Product[30];
	public static int count=0;
	
	public static TV tvs[] = new TV[10];
	public static Aircon aircons[] = new Aircon[10];
	public static Laptop laptops[] = new Laptop[10];
	
	public static int tvCount = 0;
	public static int airconCount = 0;
	public static int laptopCount = 0;
	
	
	/* 제품을 추가하는 프로그램을 작성하세요
	 * 제품은 TV, 에어컨, 컴퓨터만 추가 가능함.
	 * 공통: 브랜드, 제품코드, 제품명
	 * - TV: 화면크기
	 * - 에어컨: 냉방면적
	 * - 노트북: CPU, 램, 용량
	 * 
	 * TV, 에어컨, 노트북 클래스를 만들어야함
	 * Product 클래스(부모 클래스)
	 * 
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴선택: 1
	 * ----------------
	 * 추가할 제품
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택: 1
	 * ---------------
	 * TV 추가
	 * 브랜드: 삼성
	 * 제품코드: ABDSW123
	 * 제품명: 올레드풀모션벽걸이형
	 * 화면크기(cm): 123
	 * 등록이 완료됐습니다.
	 * --------------
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴선택: 1
	 * ---------------
	 * 추가할 제품
	 * 1. TV
	 * 2. 에어컨
	 * 3. 보트북
	 * 제품 선택: 3
	 * --------------
	 * 에어컨 추가
	 * 브랜드: 삼성
	 * 제품코드: aSDJA1
	 * 제품명: 나나나나ㅏ나나
	 * 냉방면적(m2): 56.9
	 * 등록이 완료됐습니다.
	 * 
	 * */
	
	public static void main(String[] args) {
		while(menu!=3) {
			printMenu();
		}

	}
	public static void printMenu() {
		System.out.println("--------");
		System.out.println("메뉴");
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료하기");
		System.out.print("메뉴 선택: ");
		menu = scan.nextInt();
		scan.nextLine();
		runMenu(menu);
	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			addProduct();
			break;
		case 2:
			productInfo();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	public static void addProduct() {
		int size;
		System.out.println("--제품추가--");
		System.out.println("1. TV");
		System.out.println("2. 에어컨");
		System.out.println("3. 노트북");
		System.out.print("메뉴 선택: ");
		int prod = scan.nextInt();
		scan.nextLine();
		
		System.out.print("브랜드: ");
		String brand = scan.nextLine();
		System.out.print("제품코드: ");
		String code = scan.nextLine();
		System.out.print("제품명: ");
		String name = scan.nextLine();
		
		switch(prod) {
		case 1:
			System.out.print("화면크기(cm): ");
			size = scan.nextInt();
			scan.nextLine();
			tvs[tvCount] = new TV(brand, code, name, size);
			tvs[tvCount].printInfo();
			products[count++]=tvs[tvCount++];
			System.out.println(count);
			break;
		case 2:
			System.out.print("냉방면적(m2): ");
			double area = scan.nextDouble();
			scan.nextLine();
			aircons[airconCount] = new Aircon(brand, code, name, area);
			aircons[airconCount].printInfo();
			products[count++]=aircons[airconCount++];
			System.out.println(count);
			break;
		case 3:
			System.out.print("CPU: ");
			String cpu = scan.nextLine();
			System.out.print("램: ");
			int ram = scan.nextInt();
			scan.nextLine();
			laptops[laptopCount] = new Laptop(brand, code, name, cpu, ram);
			laptops[laptopCount].printInfo();
			products[count++]=laptops[laptopCount++];
			System.out.println(count);
			break;
			
		}
	}
	public static void productInfo(){
		System.out.println("--제품 확인--");
		if(count==0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		for(int i = 0; i<count; i++) {
			System.out.println((i+1)+".");
			products[i].printInfo();
		}
	}
	public static void expandArr(Product [] arr) {
		Product [] tmp = new Product[arr.length+10];
		
	}

}
