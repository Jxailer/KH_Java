package day16.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentMain {
	public static Scanner scan = new Scanner(System.in);
	public static List<Student> list = new ArrayList<Student>();
	public static int menu = 0;
	public static String fileName = "src/day16/board/BoardMain.txt";
	
	/* 다음 기능을 가진 프로그램을 만드세요
	 * - 학생 관리 프로그램
	 * - 기능
	 * 1. 학생 추가
	 * 2. 학생 조회
	 * 3. 종료
	 * 
	 * - 학생은 학년, 반, 번호, 이름을 가진다.
	 * - 저장기능과 불러오기 기능을 통해 학생 정보들을 유지한다.
	 * */
	public static void main (String [] args) {
		while(menu!=4) {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			runMenu(menu);
		}

	}

	private static void runMenu(int menu2) {
		switch(menu) {
		case 1:
			// 학생 추가
			addStu();
			break;
		case 2:
			// 학생 조회
			printStu();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private static void printStu() {
		System.out.println("--학생 조회--\n");
//		list.stream().forEach(s->System.out.println(s));
		
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (List<Student>)ois.readObject();
			System.out.println("학생정보를 불러왔습니다.");
		}catch(Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
//			try {
//					
//					Student tmp = (Student)ois.readObject();
//					System.out.println(tmp);
//				} catch (ClassNotFoundException e) {
//					System.out.println("클래스를 찾을 수 없습니다.");
//				}
//			} catch (FileNotFoundException e) {
//				System.out.println("파일을 찾을 수 없습니다.");
//				e.printStackTrace();
//			} catch (IOException e) {
//				System.out.println("파일을 쓰는 도중에 문제가 발생하였습니다.");
//			}
		System.out.println();
	
	}

	private static void addStu() {
		System.out.println("--학생 추가--");
		System.out.print("학생 이름:");
		String name = scan.nextLine();
		System.out.print("학년: ");
		int grade = scan.nextInt();
		System.out.print("반: ");
		int classNum = scan.nextInt();
		System.out.print("번호: ");
		int num = scan.nextInt();
		
		Student std = new Student(name, grade, classNum, num);
		
		// 같은 학생이 있는지 확인
		if(!list.contains(std)) {
			list.add(std);
			
			try(FileOutputStream fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos)){
					oos.writeObject(list);
				} catch (IOException e) {
					System.out.println("저장에 실패했습니다.");
				}
			
			System.out.println("학생을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");
		
		
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴 입력: ");
	}
	
	
	
}
