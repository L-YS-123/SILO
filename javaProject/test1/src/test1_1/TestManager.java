package test1_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestManager extends TestDAO {
	TestManager() {
		super();
	}

	// 1. 받아온 리스트를 for-each 문으로 출력
	public void listOut() throws SQLException {

		// for(반환타입	참조변수명 : 배열) { }
		for (TestMemberInfo tmi : super.saveList(con)) {	// extends로 TestDAO 상속했기 때문에 connection 따로 연결 안 해주어도 됨 
			System.out.printf("%d, %s, %s, %s, %s, %s, %d \n", tmi.getMemcode(), tmi.getName(), tmi.getId(), tmi.getPw(),
					tmi.getAddress(), tmi.getPhone(), tmi.getPoint());
		}
		


	}
}
