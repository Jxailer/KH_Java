package day15.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
	/* 학생 국어, 영어, 수학 성적 관리 프로그램을 작성하세요
	 * - Program 인터페이스를 생성하여 활용
	 *  / void run()
	 *  / void printMenu()
	 *  /- void runMenu(int menu)
	 *  
	 * - Program 인터페이스를 구현한 StudentProgram 클래스를 생성해서 활용함.
	 * 
	 * - 학생 정보를 Student 클래스를 생성해서 활용함
	 *  / 학년, 반, 번호, 이름, 국어, 영어, 수학
	 * 
	 * - 리스트 활용
	 * 
	 * - 예외처리 활용
	 * 
	 * - 기능
	 *  - 학생 관리
	 *   / 학생 추가
	 *   / 학생 수정
	 *   / 학생 삭제
	 *   
	 *  - 성적 관리
	 *   / 성적 추가
	 *   / 성적 수정
	 *   / 성적 삭제
	 *   
	 *  - 조회
	 *   - 학생 조회
	 *    / 전체
	 *    / 학년
	 *    / 반
	 *    / 학생(학년, 반, 번호 이용)
	 *    
	 *   - 성적 조회
	 *    /국어
	 *    /영어
	 *    /수학
	 *    
	 * */
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	
	public static void main(String[] args) {
		Program p = new StudentProgram();
		p.run();

	}

}


	

