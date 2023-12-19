package day08;

public class StudentMain {
	public static void main(String [] arg) {
		Student student1 = new Student();
		Student student2 = new Student("홍길동", 1, 2, 3);
		
		student1.printInfo();
		
		student2.changeScore(1, 100);
		student2.changeScore(2, 50);
		student2.changeScore(3, 70);
		
		student1.printScore();
		
		student2.printInfo();
		student2.printScore();
	}
}
