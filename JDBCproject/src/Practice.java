import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "select * from emp where deptno=";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			Connection conn = DriverManager.getConnection(url,"hr","tiger");
			System.out.println("연결 성공");
			
			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
			
			
//			while(rs.next()) {
//				int empno = rs.getInt("empno");
//				System.out.print(empno + " ");
//				String ename = rs.getString("ename");
//				System.out.println(ename);
//				st.
//			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 불러오기 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패");
			e.printStackTrace();
		} 
		
		
			
		
		
	}
	
}
