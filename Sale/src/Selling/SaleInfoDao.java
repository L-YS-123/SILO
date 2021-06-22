package Selling;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;

	int Dao(Connection conn, SaleInfo saleinfo) {

		Calculator calc = new Calculator();
		
		int result = 0;

		try {
			// 1. 오라클 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");

			// 2. db연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			System.out.println("db연결 성공");

			conn = DriverManager.getConnection(jdbcUrl, user, pw);

			String sql = "insert into sale (saleCode ,sname, price) values( ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);

//			pstmt.setInt(1, 1);
//			pstmt.setString(2, "Americano");
//			pstmt.setInt(3, calc.americano);
//
//			pstmt.setInt(1, 2);
//			pstmt.setString(2, "Cafelatte");
//			pstmt.setInt(3, calc.cafelatte);
//
//			pstmt.setInt(1, 3); // 왜 이거만 들어갔지? -> 배열로 처리해야하나?
//			pstmt.setString(2, "Cafemocca");
//			pstmt.setInt(3, calc.cafemocca);
			
//			ArrayList<SaleInfo> list = new ArrayList<>();
//			list.add(new SaleInfo(0,"Americano",calc.americanoPrice));
//			list.add(new SaleInfo(1,"Cafelatte",calc.cafelattePrice));
//			list.add(new SaleInfo(2,"Cafemocca",calc.cafemoccaPrice));
			
//			SaleInfo[] array = new SaleInfo[10];
//			array[0] = new SaleInfo(1,"Americano",calc.americanoPrice);
//			array[1] = new SaleInfo(2,"Cafelatte",calc.cafelattePrice);
//			array[2] = new SaleInfo(3,"Cafemocca",calc.cafemoccaPrice);
			

			result = pstmt.executeUpdate();
			System.out.println("result갯수(업뎃횟수): "+result);
			
			
			if(result > 0) {
				System.out.println("데이터 저장 완료");
			} else {
				System.out.println("저장 실패");
			}
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}

}
