package day08;

public class Student {
	// 학생의 국어, 영어, 수학 성적을 관리하기 위한 프로그램을 작성하려고 한다.
	int korScore;
	int engScore;
	int mathScore;
	int grade, classNum;
	
	String name;
	int studentNum;
	
	
	public Student() {
		
	}
	
	public Student(String name, int studentNum, int grade, int classNum) {
		this.name=name;
		this.studentNum=studentNum;
		this.grade=grade;
		this.classNum=classNum;
//		printInfo();
	}
	
	public Student(String name, int studentNum, int grade, int classNum, int kor, int eng, int math) {
		this.name=name;
		this.studentNum=studentNum;
		this.grade=grade;
		this.classNum=classNum;
		korScore = kor;
		engScore = eng;
		mathScore = math;
	}
	
	
	
	public void changeName(String newName) {
		name = newName;
	}
	public void changeNumber(int newNum) {
		studentNum = newNum;
	}
	
	// 학생 점수 바꾸기. 국어1, 영어2, 수학3
	public void changeScore(int subject, int score) {
		switch(subject){
			case 1 :
			korScore=score;
			break;
			case 2:
			engScore=score;
			break;
			case 3:
			mathScore=score;
			break;
		}
	}
	
	public void printInfo() {
		System.out.println("이름: "+name);
		System.out.println("번호: "+studentNum);
		System.out.println("학년: "+grade);
		System.out.println("반 : "+classNum);
		System.out.println("------------------------");
		
	}
	
	public void printScore() {
		printInfo();
		System.out.println(name+"의 성적");
		System.out.println("국어: "+korScore);
		System.out.println("영어: "+engScore);
		System.out.println("수학: "+mathScore);
		System.out.println("------------------------");
	}
}

