package test1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestManager extends TestDAO {
	TestManager() {
		super();
	}

	Connection con;

	// 1. 받아온 리스트를 for-each 문으로 출력
	public void listOut() {

		try {
			con = DriverManager.getConnection(url, user, password);
//			ArrayList<TestMemberInfo> list = super.saveList(con);
			
			for (TestMemberInfo tmi : super.saveList(con)) {
				System.out.printf("%d,%s,%s,%s,%s,%s,%d \n", tmi.getMemcode(), tmi.getName(), tmi.getId(), tmi.getPw(),
						tmi.getAddress(), tmi.getPhone(), tmi.getPoint());
				System.out.println(tmi.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}
}
