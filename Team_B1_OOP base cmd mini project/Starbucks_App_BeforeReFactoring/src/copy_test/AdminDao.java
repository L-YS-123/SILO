package copy_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {
	
	
	
	// 싱글톤
	private AdminDao() {}
	
	static private AdminDao adminDao = new AdminDao();
	
	public static AdminDao getInstance()	{
		return adminDao;
	}
	
	// 1. 전체 데이터 출력 - 관리자
	// 반환 타입 List<Dept>
	// 매개변수 - Connection 객체 : Statement
	ArrayList<Admin> getList(Connection con){
		
		ArrayList<Admin> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			// sql문
			String sql = "select * from member order by memcode";
			pstmt = con.prepareStatement(sql);
			// 결과 받아오기
			rs = pstmt.executeQuery(sql);
			
			list = new ArrayList<>();
					
			// 리스트 저장
			while(rs.next()) {
				Admin admin = new Admin(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getString(6),
										rs.getInt(7)
										);
				list.add(admin);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	ArrayList<Admin> getList(Connection con, String currentId){
		
		ArrayList<Admin> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			// sql문
			String sql = "select * from member where id = " + "'" + currentId + "'";
			pstmt = con.prepareStatement(sql);
			// 결과 받아오기
			rs = pstmt.executeQuery(sql);
			
			list = new ArrayList<>();
					
			// 리스트 저장
			while(rs.next()) {
				Admin admin = new Admin(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getString(6), 
										rs.getInt(7)
										);
				list.add(admin);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	// 2. 데이터 입력
	int insertMem(Connection con, Admin admin) {
		
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getId());
			pstmt.setString(3, admin.getPw());
			pstmt.setString(4, admin.getAddress());
			pstmt.setString(5, admin.getPhone());
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;						
	}
	
	// 데이터 수정
	int editMem(Connection con, Admin admin, String currentId) {
		
		int result = 0;		
		PreparedStatement pstmt = null;

		try {
			// sql문 where절 수정해야함. 현재 임의값
			String sql = "update member set name = ?, pw =?, address = ?, phone = ? where id = " +"'"+currentId+"'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getPw());
			pstmt.setString(3, admin.getAddress());
			pstmt.setString(4, admin.getPhone());
			
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
	
	// 데이터 삭제
	int deleteMem(Connection con, String currentId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "delete from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, currentId);
			
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

	
	// 멤버 아이디 필요!
	
	
	// 포인트 보기 -> Read: select
	
	int readPoint(Connection con , String currentId) {
		// 현재 포인트(havePoint)를 read해서 return 한다. 
		// member의 id가 필요하다. 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		int havePoint = 0 ;
		
		
		try {
			String readPoint = "select point from member where id = ?";
			pstmt= con.prepareStatement(readPoint);
			
			pstmt.setString(1, currentId);
			rs = pstmt.executeQuery();

			
			while(rs.next()) {
				havePoint = rs.getInt("point");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return havePoint;
	}
	
	

}
