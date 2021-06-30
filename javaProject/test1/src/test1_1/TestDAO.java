package test1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "tiger";

	String sql = "select * from member ";
	
	// 1. db데이터 불러와서 어레이리스트에 저장
	ArrayList<TestMemberInfo> saveList(Connection con) {	// 매개변수로  Connection con을 입력해야 db에 연결이 되는듯?
		
		ArrayList<TestMemberInfo> list = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			TestMemberInfo tmi = new TestMemberInfo();
			
			// memberinfo 타입 리스트 생성 -> rs.next()가 있으면 list에 저장
			while (rs.next()) {
				tmi = new TestMemberInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				
				list.add(tmi);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}
}
