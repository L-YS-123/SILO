package test1_1;

import java.sql.Connection;

class TestMain {
	static Connection con;
	
    public static void main(String[] args)  {
    	TestManager tm = new TestManager();
    	tm.listOut();

    }
}