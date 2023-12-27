package day13;

import java.util.Calendar;

public class CalendarEx1 {

	public static void main(String[] args) {
		// 캘린더 예제
		Calendar cal = Calendar.getInstance(); // 현재시간을 달력 형태로 가져옴
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		int month = cal.get(Calendar.MONTH)+1; // 월은 0부터 11이라 +1을 해야함.
		System.out.println(month);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);

	}

}
