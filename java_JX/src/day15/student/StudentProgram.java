package day15.student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentProgram implements Program{
	
	private Scanner scan= new Scanner(System.in);
	private List<Student> list = new ArrayList<Student>();

	@Override
	public void run() {
		System.out.println("------------------");
		System.out.println("프로그램을 실행합니다.");
		System.out.println("------------------");
		int menu=0;
		
		while(menu!=4) {
			printMenu();
			try {
				menu = scan.nextInt();
				scan.nextLine();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
			
		}
		
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.print("메뉴 입력: ");

		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			System.out.println("--학생 관리--");
			System.out.println("학생 추가");
			System.out.println("학생 수정");
			System.out.println("학생 삭제");
			System.out.print("메뉴 입력: ");
			int menu1 = scan.nextInt();
			studentManage(menu1, list);
			break;
		case 2:
			System.out.println("--성적 관리--");
			System.out.println("1. 성적 수정");
			System.out.println("2. 성적 삭제");
			System.out.print("메뉴 입력: ");
			int menu2 = scan.nextInt();
			scoreManage(menu2);
			break;
		case 3:
			System.out.println("--조회--");
			System.out.println("1. 학생 조회");
			System.out.println("2. 성적 조회");
			System.out.print("메뉴 입력: ");
			int menu3 = scan.nextInt();
			switch(menu3) {
			case 1:
				System.out.println("--학생 조회--");
				System.out.println("1. 전체");
				System.out.println("2. 학년 별");
				System.out.println("3. 반 별");
				System.out.println("4. 학생 별");
				System.out.print("메뉴 입력: ");
				int menu3_1 = scan.nextInt();
				scan.nextLine();
				searchStudent(menu3_1);
				break;
			case 2:
				System.out.println("--성적 조회--");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("메뉴 입력: ");
				int menu3_2 = scan.nextInt();
				scan.nextLine();
				searchScore(menu3_2);
				break;
			default:
				System.out.println();
			}
			break;
		}
		
	}
	
	
	
	
	
	
	private void printStudnet(Predicate<Student> p) {
		for(Student std:list) {
			if(p.test(std)) {
				System.out.println(std);
			}
		}
	}
	
	private void printSubject(Function<Student, Integer> f) {
		for(Student std:list) {
			System.out.println(std.getName()+" : "+f.apply(std));
		}
	}
	

	private void searchScore(int menu3_2) {
		switch(menu3_2) {
		case 1:
			System.out.println("--성적 조회--");
			
			return;
			
		case 2:
			
			return;
		case 3:
			
				return;
		}
		
	}

	private void searchStudent(int menu3_1) {
		switch(menu3_1) {
		case 1:
			System.out.println("--학생 조회--");
			
			return;
			
		case 2:
			
			return;
		case 3:
			
				return;
		}
		
	}

	private void scoreManage(int menu2) {
		switch(menu2) {
		case 1:
			System.out.println("--성적 수정--");
			System.out.println("1. 국어");
			System.out.println("2. 영어");
			System.out.println("3. 수학");
			System.out.print("메뉴 입력: ");
			int subject = scan.nextInt();
			
			// 학년 반 번호 성적 입렭
			System.out.print("학년 반 번호 이름 성적: ");
			int grade = scan.nextInt();
			int classNum = scan.nextInt();
			int num = scan.nextInt();
			String name = scan.next();
			int score = scan.nextInt();
			scan.nextLine();
			
			Student std = new Student(grade, classNum, num, name);
			int index = list.indexOf(std); 
			
			if(index==-1) {		//없으면 -1반환
				System.out.println("등록되지 않은 학생입니다.");
				return;
			}
			
			switch(subject) {
			case 1: 
			}
		case 3:
			
				return;
		}
	}
		


	private void studentManage(int menu, List<Student> list) {
		switch(menu) {
			case 1:
				insertStudent();
				break;
			case 2:
				updateStudnet();
				break;
			case 3:
				deleteStudent();
				break;
				}
			}
		
			
		
	private void deleteStudent() {
		System.out.println("--학생 삭제--");
		System.out.println("삭제할 학생 정보 입력 ");
		System.out.print("학년 반 번호 : ");
		int grade = scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		String name = scan.next();
		
		
		Student tmpStu3 = new Student(grade, classNum, num, name);
		if(list.remove(tmpStu3)){
			System.out.println(" 학생 정보를 삭제하였습니다."); 
		}else{
			System.out.println("등록되지 않은 학생 정보입니다.");
		}
		return;
	}

	private void updateStudnet() {
		System.out.println("--학생 수정--");
		System.out.println("기존 학생 정보 입력 ");
		System.out.print("학년 반 번호 이름: ");
		int grade = scan.nextInt();
		int classNum = scan.nextInt();
		int num = scan.nextInt();
		String name = scan.next();
		
		Student tmpStu2 = new Student(grade, classNum, num, name);
		// list에 tmpStu2와 일치하는 항목이 있으면 해당 항목의 번지수를 잔환함.

		int index = list.indexOf(tmpStu2); 
		
		if(index==-1) {		//없으면 -1반환
			System.out.println("등록되지 않은 학생입니다.");
			return;
		}
		
		Student std = list.get(index); // 일치하는 번지의 인스턴스를 가져옴.
		
		System.out.println("수정할 학생 정보 입력 ");
		System.out.print("학년 반 번호 이름: ");
		grade = scan.nextInt();
		classNum = scan.nextInt();
		num = scan.nextInt();
		name = scan.next();
		
		System.out.println("지워졌는가?: "+list.remove(index) );
		tmpStu2.setName(name);
		tmpStu2.setKor(std.getKor());
		tmpStu2.setEng(std.getEng());
		tmpStu2.setMath(std.getMath());
		list.add(tmpStu2);
		System.out.println("등록되었는가?: "+list.contains(tmpStu2));
		
		return;
		
	}

	private void insertStudent() {
		System.out.println("--학생 추가--");
		System.out.print("학생 학년: "); int grade = scan.nextInt();
		System.out.print("학생 반: "); int classNum = scan.nextInt();
		System.out.print("학생 번호: "); int num = scan.nextInt();
		scan.nextLine();
		
		System.out.print("학생 이름: "); String name = scan.next();
		Student tmpStu = new Student(grade, classNum, num, name);
		if(!list.contains(tmpStu)) {
			list.add(tmpStu);
			System.out.println("입력이 완료되었습니다.");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");
		return;
		
	}


}