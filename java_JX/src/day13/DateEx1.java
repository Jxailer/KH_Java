package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DateEx1 {
	//고치기

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println(date);
		
		//Date => String
		/* 시간 패턴은, 화면에 보여줄 시간 패턴을 문자열로 지정해야함.*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = format.format(date);
		System.out.println(str);
		
		//String => date
		Date date2 = format.parse(str);
		System.out.println(date2);
		
		System.out.println();
		Board board = new Board("제목", "내용", new Date());
		System.out.println(board.getRegDate());
		
		Board board2 = new Board("제목2", "내용", null);
		board2.setRegDate("2023-12-27 19:00:00");
		System.out.println(board2);

	}

}

@AllArgsConstructor
@Data
class Board{
	String title, contents;
	Date regDate; // 작성일
	
	public void setRegDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			regDate = format.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
