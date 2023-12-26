package day11.homework;

import java.util.Scanner;

import day11.product.Product;

public class HomeworkEx1 {
	/* 고등학생 성적을 관리하는 프로그램을 작성하세요.
	 * 메뉴
	 * 1. 학생관리
	 * - 학생 추기: 동일한 학생(학년, 반, 번호가 같은)이 있으면 안됨
	 * - 학생 수정
	 * - 학생 삭제
	 * 
	 * 2. 성적관리
	 * - 성적 추가: 과목과 점수를 입력
	 * - 성적 수정
	 * - 성적 삭제
	 * 
	 * 3. 프로그램 종료
	 * 
	 * - Student 클래스
	 * - Subject 클래스
	 *   - 쉬운 버전: 과목, 성적 총점
	 *   - 어려운 버전: 과목명, 성적(중간, 기말, 수행평가, 총점)
	 * */
	
	private static Scanner scan = new Scanner(System.in);
	private static int menu = 0;
	private static int count1 = 0;
	private static int count2 = 0;
	private static Student [] studs = new Student [10];
	private static Subject [] subs = new Subject[10];
	
	public static void main(String[] args) {
		while(menu!=3) {
			printMenu();
			
		}

	}
	public static void printMenu() {
		System.out.println("-------------");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 프로그램 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		menu=scan.nextInt();
		scan.nextLine();
		printStuMenu(menu);
	}
	public static void printStuMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 등록 기능 구현
			stuManage();
			break;
		case 2:
			//단어 검색 기능 구현
			scoreManage();
			break;
		case 3:
			//단어 수정 기능 구현
			System.out.println("프로그램을 종료합니다.");
			menu=3;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
	}
	
	// 학생 관리 메뉴
	public static void stuManage() {
		System.out.println("--학생 관리--");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.print("메뉴 선택: ");
		int menuNum=scan.nextInt();
		scan.nextLine();
		
		switch(menuNum) {
		case 1:
			//단어 등록 기능 구현
			stuAdd();
			break;
		case 2:
			//단어 검색 기능 구현
			stuEdit();
			break;
		case 3:
			stuDelete();
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
	}
	
	public static void stuAdd() {
		System.out.println("-------------");
		System.out.print("학생 이름: ");
		String name = scan.nextLine();
		System.out.print("학생 학년: ");
		int grade= scan.nextInt();
		scan.nextLine();
		System.out.print("학생 반: ");
		int classNum= scan.nextInt();
		scan.nextLine();
		System.out.print("학번: ");
		int stuNum = scan.nextInt();
		scan.nextLine();
		
		int i = searchStu(name);
		if(i<count1) {
			System.out.println("이미 존재하는 학생입니다!");
		}
		else {
			studs[i] = new Student(name, classNum, stuNum, grade);
			count1++;
//			System.out.println("products의 길이: "+count);
		}
		studs[i].printStuInfo();

	}
	public static void stuEdit() {
		System.out.println("--학생 수정--");
		stuList();
		System.out.print("수정할 학생 이름: ");
		String name = scan.nextLine();
		
		int i = searchStu(name);
		if(i<count1) {
			System.out.println("-------------");
			System.out.print("새 학생 이름: ");
			name = scan.nextLine();
			System.out.print("새 학생 학년: ");
			int grade= scan.nextInt();
			scan.nextLine();
			System.out.print("새 학생 반: ");
			int classNum= scan.nextInt();
			scan.nextLine();
			System.out.print("새 학번: ");
			int stuNum = scan.nextInt();
			scan.nextLine();
			 stuChange(i, name, classNum, stuNum, grade);
			
			
			studs[i].printStuInfo();
		}
		else {
			System.out.println("존재하지 않는 학생입니다!");
		}
		
	}
	
	public static void stuDelete() {
		System.out.println("--학생 삭제--");
		System.out.println("학생 이름: ");
		String name = scan.nextLine();
		
		int i = searchStu(name);
		if(i<count1) {
			Student [] tmp = new Student[studs.length];
			System.arraycopy(studs, 0, tmp, 0, i);
			System.arraycopy(studs, i+1, tmp, i, count1-i-1);
			count1--;
			studs=tmp;
		}
		else {
			System.out.println("해당 학생이 존재하지 않습니다!");
		}
		
		System.out.println("수정된 학생 목록: ");
		stuList();
	}
	
	public static int searchStu(String name) {
		int i;
		for(i=0; i<count1;i++) {
			if(studs[i].getName().equals(name)) {
//				System.out.println(i);
				return i;
			}
				
		}
		return count1;
	}
	
	public static void stuList() {
		for(int j = 0; j<count1; j++) {
			System.out.println((j+1)+". ----------");
			studs[j].printStuInfo();
		}
	}
	
	public static void stuChange(int i, String name, int classNum, int stuNum, int grade) {
		Student tmp = new Student(name, classNum, stuNum, grade);
		studs[i] = tmp;
	}
	
	// 성적 관리 메뉴
	public static void scoreManage() {
		System.out.println("--성적 관리--");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
		System.out.print("메뉴 선택: ");
		int menuNum=scan.nextInt();
		scan.nextLine();
		
		switch(menuNum) {
		case 1:
			//단어 등록 기능 구현
			subAdd();
			break;
		case 2:
			//단어 검색 기능 구현
			subEdit();
			break;
		case 3:
			subDelete();
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
	}
}
	
	public static void subAdd() {
		System.out.println("-------------");
		System.out.print("과목 이름: ");
		String name = scan.nextLine();
		System.out.print("중간고사 점수: ");
		int grade= scan.nextInt();
		scan.nextLine();
		System.out.print("기말고사 점수: ");
		int classNum= scan.nextInt();
		scan.nextLine();
		System.out.print("수행평가 점수: ");
		int stuNum = scan.nextInt();
		scan.nextLine();
		
		int i = searchSub(name);
		if(i<count2) {
			System.out.println("이미 존재하는 과목입니다!");
		}
		else {
			subs[i] = new Subject(name, classNum, stuNum, grade);
			count2++;
//			System.out.println("products의 길이: "+count);
		}
		subs[i].printSubInfo();

	}
	public static void subEdit() {
		System.out.println("--과목 수정--");
		subsList();
		System.out.print("수정할 과목 이름: ");
		String name = scan.nextLine();
		
		int i = searchStu(name);
		if(i<count2) {
			System.out.println("-------------");
			System.out.print("새 과목 이름: ");
			name = scan.nextLine();
			System.out.print("새 중간고사 점수: ");
			int grade= scan.nextInt();
			scan.nextLine();
			System.out.print("새 기말고사 점수: ");
			int classNum= scan.nextInt();
			scan.nextLine();
			System.out.print("새 수행평가 점수: ");
			int stuNum = scan.nextInt();
			scan.nextLine();
			 subsChange(i, name, classNum, stuNum, grade);
			
			
			subs[i].printSubInfo();
		}
		else {
			System.out.println("존재하지 않는 과목입니다!");
		}
		
	}
	
	public static void subDelete() {
		System.out.println("--과목 삭제--");
		System.out.println("과목 이름: ");
		String name = scan.nextLine();
		
		int i = searchSub(name);
		if(i<count2) {
			Subject [] tmp = new Subject[subs.length];
			System.arraycopy(subs, 0, tmp, 0, i);
			System.arraycopy(subs, i+1, tmp, i, count2-i-1);
			count2--;
			subs=tmp;
		}
		else {
			System.out.println("해당 과목이 존재하지 않습니다!");
		}
		
		System.out.println("수정된 과목 목록: ");
		subsList();
	}
	
	public static int searchSub(String name) {
		int i;
		for(i=0; i<count2;i++) {
			if(subs[i].getName().equals(name)) {
//				System.out.println(i);
				return i;
			}
				
		}
		return count2;
	}
	
	public static void subsList() {
		for(int j = 0; j<count2; j++) {
			System.out.println((j+1)+". ----------");
			subs[j].printSubInfo();
		}
	}
	
	
	public static void subsChange(int i, String name, int classNum, int stuNum, int grade) {
		Subject tmp = new Subject(name, classNum, stuNum, grade);
		subs[i] = tmp;
		}
	}
	

class Student{
	private String name;
	private int grade, classNum, stuNum;
	private Subject [] subs;
	
	public Student() {
		
	}
	public Student(String name, int classNum, int stuNum, int grade) {
		this.name=name;
		this.classNum=classNum;
		this.stuNum=stuNum;
		this.grade=grade;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
//	public Subject getKor() {
//		return kor;
//	}
//	public void setKor(Subject kor) {
//		this.kor = kor;
//	}
//	public Subject getMath() {
//		return math;
//	}
//	public void setMath(Subject math) {
//		this.math = math;
//	}
//	public Subject getEng() {
//		return eng;
//	}
//	public void setEng(Subject eng) {
//		this.eng = eng;
//	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void printStuInfo() {
		System.out.println("학생 이름: "+name);
		System.out.println("학년, 반: "+grade+"학년 "+classNum+"반" );
		System.out.println("학번: "+stuNum);
	}
	
}

class Subject{
	private String name=" ";
	private int middleScore, finalScore, test;
	private int total;
	
	public Subject() {
		
	}
	
	public Subject(String subName, int middleScore, int finalScore, int test) {
		this.name=subName;
		this.middleScore=middleScore;
		this.finalScore=finalScore;
		this.test=test;
		this.total=middleScore+finalScore+test;
	}
	
	public Subject(String subName) {
		this.name=subName;
	}

	public String getName() {
		return name;
	}

	public void setName(String subName) {
		this.name = subName;
	}

	public int getMiddleScore() {
		return middleScore;
	}

	public void setMiddleScore(int middleScore) {
		this.middleScore = middleScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public int getTotal() {
		return total;
	}

	public void printSubInfo() {
		System.out.println("-------------");
		System.out.println(name+" 과목 정보:");
		System.out.println("중간고사: "+middleScore);
		System.out.println("기말고사: "+finalScore);
		System.out.println("수행평사: "+test);
		System.out.println("-------------");
		System.out.println("총점: "+total);
	}
	
	
}
