package comp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {

	String sql;
	
	public Dao(String sql) {
		this.sql = sql;
	}
	
	private PreparedStatement pstmt = null;
	
	int deleteData(Connection con, String inputData) {

		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputData);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
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
		}
		return result;
	}
}
