// 판매제품 정보 보기(출력)

package Selling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadSaledProduct {

	public static void main(String[] args) {
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "tiger";

		String sql = "Select * from SALE";

		try {
			SaleInfo si = new SaleInfo();
			si.getSaleCode();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드");

			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("로그인 성공");

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("=======================판매정보출력=======================");
			while (rs.next()) {
				int saleCode = rs.getInt("SALECODE");
				System.out.print("SALECODE:"+saleCode+"\t");
				String sname = rs.getString("SNAME");
				System.out.print("SNAME:"+sname+"\t");
				int price = rs.getInt("PRICE");
				System.out.print("PRICE:"+price+"\t");
				String saleDate = rs.getString("SALEDATE");
				System.out.print("SALEDATE:"+saleDate+"\t");
				int memCode = rs.getInt("MEMCODE");
				System.out.println("MEMCODE:"+memCode+"\t");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("로그인 실패");
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					rs.close();
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

	}

}
