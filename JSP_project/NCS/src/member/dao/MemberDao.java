package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.dao.MemberDao;
import jdbc.util.JdbcUtil;
import member.Member;

public class MemberDao {

	private MemberDao() {}
	
	private static MemberDao memdao = new MemberDao();
	
	public static MemberDao getInstance() {
		return memdao == null ? new MemberDao() : memdao;
	}


	public List<Member> getMemList(Connection conn) {
		
		List<Member> list = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt=conn.createStatement();
			String sql = "select * from ncs";
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Member>();
			
			while(rs.next()) {
				list.add(new Member(rs.getString("id"),
						rs.getString("pw"),
						rs.getString("name")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return list;
	}
	
	
	public int insertMember(Connection conn, Member member) {
		
		int resultCnt=0;
		PreparedStatement pstmt=null;
		
		String sql="insert into ncs values (?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt ;
		
	}
	

}
