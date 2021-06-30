package test1_1;

import java.sql.Connection;
import java.sql.SQLException;

class TestMain {
	static Connection con;
	
    public static void main(String[] args)  {
    	TestManager tm = new TestManager();
    	try {
			tm.listOut();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}