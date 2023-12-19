package day08;

public class StudentMain2 {

	public static void main(String[] args) {
		// 5명의 학생을 저장하기 위한 배열을 생성하세요
		Student [] sdts = new Student[5]; // 0번지부터 4번지 까지 null로 초기화 되어있음.
		
//		학생 5명의 학생 정보를 출력하는 코드를 작성하세요
		for(int i = 0; i<sdts.length; i++) {
			sdts[i] = new Student(); // 각 번지마다 학생 인스턴트를 생성해줘야
			sdts[i].printInfo(); // 아래에서 출력될 수 있음.

		}
			
			
	}

}
