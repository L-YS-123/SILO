package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {

		// Connection = 연결 객체 : 연결 정보를 가진다
		Connection conn = null;
		
		// Statement = sql을 실행할 메소드를 제공한다
		Statement stmt = null;
		
		// ResultSet = executeQuery() 반환타입 -> select의 결과 '테이블'을 담는 객체
		ResultSet rs = null;
		
		// Statement -> PreparedStatement : 성능개선
		PreparedStatement pstmt = null;
		
		
		try {
			
			// 1.드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");

			// 2.연결
			String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr"; // oracle sql 아이디
			String pw = "tiger";

			conn = DriverManager.getConnection(jdbcURL, user, pw);
			System.out.println("데이터베이스 연결 성공");
			
			// 3.sql처리
			stmt = conn.createStatement();
			
			int dno = 10;
			String otype = "deptno";
			
			String sqlSelect = 
					" select * from dept order by dname =  " ;
			
			rs = stmt.executeQuery(sqlSelect);
			
			// rs.next() -> db테이블의 다음행의 존재 유무 확인
			while(rs.next()) {
				int deptno = rs.getInt("deptno"); //deptno는 숫자
				System.out.println(deptno+"\t");
				String dname = rs.getString("dname"); //dname은 문자
				System.out.println(dname+"\t");
				String loc = rs.getString("loc"); //loc는 문자
				System.out.println(loc+"\t");
			}
			
			////////////////////////////////////////////////////////////////////
			// PreparedStatement -> Sql 먼저 등록  -> 매개변수처럼 ?를 이용해서 나중에 변수를 바인딩
			
			System.out.println("PreparedStatement 사용");
			System.out.println("============================");
			
			String sqlSelect2 = "select * from dept order by dname = ? " ;
			pstmt = conn.prepareStatement(sqlSelect2);
			// ? 변수에 데이터 바인딩
			pstmt.setInt(1, 10);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno"); //deptno는 숫자
				System.out.println(deptno+"\t");
				String dname = rs.getString("dname"); //dname은 문자
				System.out.println(dname+"\t");
				String loc = rs.getString("loc"); //loc는 문자
				System.out.println(loc+"\t");
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 클래스를 찾지 못함");
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
			
		} finally {
			
			// 4.close
			if (rs != null) {  // if 하는 이유?
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
			
			if (stmt != null) {  // if 하는 이유?
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
			
			if (conn != null) {  // if 하는 이유?
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}

		}

	}

}
