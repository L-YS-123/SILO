package test1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestManager extends TestDAO {
	TestManager() {
		super();
	}

	public void listOut() {

		try {
			con = DriverManager.getConnection(super.url, super.user, super.password);

			ArrayList<TestMemberInfo> list = super.saveList(con);

			for (TestMemberInfo mem : list) {
				System.out.printf("%d,%s,%s,%s,%s,%s,%d \n", mem.getMemcode(), mem.getName(), mem.getId(), mem.getPw(),
						mem.getAddress(), mem.getPhone(), mem.getPoint());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
