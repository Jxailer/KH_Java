package DBpackage.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class DBmain {
	public static void main (String [] args) {
		
		//MySQL 설치 시 port 번호를 수정하지 않았다면 3306
		String url = "jdbc:mysql://localhost:3306/test";
		String id = "root";
		String pw = "root"; // 개인 비번일 경우 지우고 Git에 올려야함.
		
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw); // 연결 객체를 생성함.
		} catch (SQLException e){
			System.out.println("연결 실패");
		} catch (ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
		
		// 3. 쿼리를 이용하여 코드 작성 
		
		// 3-1. Statement 클래스 이용하기
		/*	- `Statement` 클래스는 간단한 쿼리를 이용할 때 사용
			- 실행될 때마다 SQL엔진에서 새로 파싱 되고 매번 컴파일 됨
			- 샘플 코드(insert/update/delete 동일)
		 */
		
//		String sql = "쿼리";
//		Statement stmt = null; // java.sql.statement import 하기
//		try{
//			stmt = con.createStatement();
//			// 백그라운드에서 mySQL 실행중인지 확인
//			// 안될 경우 workbench에서 인스턴스 실행하기.
//			stmt.execute(sql);
//		} catch (SQLException e){
//			// 오타 혹은 classpath 설정 여부 확인
//			System.out.println("예외 발생");
//		}
		
		// insert문 예제
//		String sql = "insert into member values('qwerty', 'pwasd', 'asd@naver.com', now())";
//		Statement stmt = null;
//		try{
//			stmt = con.createStatement();
//			stmt.execute(sql);					// 쿼리 실행
//			System.out.println("회원 추가 성공");
//		} catch (SQLException e){
//			System.out.println("예외 발생");
//		}
		
		
		
		
		
		
		
		// =====================================================================================
		
		// 3-2. PreparedStatement  클래스를 이용한 방법
		/*
		 	- `PreparedStatement` 는 쿼리를 반복적으로 사용할 때 유용
			- 쿼리가 미리 컴파일 되어 있어 성능상의 이점이 있음
			- 바인딩 변수를 통해 동적으로 값을 변경
			- 샘플 코드(insert/update/delete)
		 */
		
		// insert문 예제 ---------------------------
		//String sql = "쿼리";
		//예시 ?을 이용하여 값을 동적으로 변경 (동적 바인딩)
//		String sql2 = "insert into member values(?,?,?,now())";
//		PreparedStatement pstmt = null;
//		try{
//			pstmt = con.prepareStatement(sql2);		// 객체가 만들어질 때 이미 sql을 통해 세팅이 맞춰져 있음.
//			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
//			pstmt.setString(1, "qwerasd");
//			pstmt.setString(2, "pwe");
//			pstmt.setString(3, "qwe@naver.com");
////			pstmt.setInt(2, 123); 					// 자료형에 맞춰 코드를 변경
//			//쿼리가 적용된 행의 개수를 리턴.
//			pstmt.executeUpdate();					// return 값이 int형임.
//			System.out.println("회원 추가 성공 2");
//		}catch(SQLException e){
//			System.out.println("예외 발생");
//		}
		
		// update문 예제 --------------------------
		//String sql = "쿼리";
		//예시 ?을 이용하여 값을 동적으로 변경
//		String sql = "update member set pw = ? where id = ?";
//		PreparedStatement pstmt = null;
//		try{
//			pstmt = con.prepareStatement(sql);
//			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
//			pstmt.setString(1, "newPw");
//			pstmt.setString(2, "qwerty");
//			//쿼리가 적용된 행의 개수를 리턴.
//			pstmt.executeUpdate();
//			System.out.println("비번 수정 성공");
//		}catch(SQLException e){
//			System.out.println("예외 발생");
//		}
		
		// delete문 예제 ---------------------------
//		String sql = "delete from member where id = ?";
//		PreparedStatement pstmt = null;
//		try{
//			pstmt = con.prepareStatement(sql);
//			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
//			pstmt.setString(1, "qwerty");
//			//쿼리가 적용된 행의 개수를 리턴.
//			pstmt.executeUpdate();
//			System.out.println("회원 삭제 성공");
//		}catch(SQLException e){
//			System.out.println("예외 발생");
//		}
		
		// select뮨 예제 ---------------------------
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try{
			pstmt = con.prepareStatement(sql);
			//쿼리에 ?가 있다면 pstmt.setXX을 통해 바인딩
			rs = pstmt.executeQuery();		// executeUpdate()가 아님!
			//검색된 행(레코드 만큼 반복)
			while(rs.next()){
				//검색 결과 첫번째 열이 id, 두번째 열이 pw이라고 가정
				//첫번째 열이 문자열이기 때문에 getString()을 이용
				//정수라면 getInt()
				String dbid = rs.getString(1);
				String dbpw = rs.getString(2);
				String dbemail = rs.getString(3);
				Date dbRegDate = rs.getDate(4);
//				System.out.println("ID : " + dbid + ", PW : " + dbpw+ ", EMAIL : " + dbemail+ ", RegDate : " + dbRegDate);
				Member member = new Member(dbid, dbpw, dbemail, dbRegDate);
				System.out.println(member);
				list.add(member);
			}
		} catch (SQLException e){
			System.out.println("예외 발생");
		}
		
		
		
		
	}
}

@Data
@AllArgsConstructor
class Member{
	String id, pw, email;
	Date regeDate;
	
	
}
