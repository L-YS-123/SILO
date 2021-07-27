package guest.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JdbcDriverLoad extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		String jdbcDriver = config.getInitParameter("jdbcdriver");
		
		try {
			jdbcDriver = jdbcDriver == null ? "com.mysql.cj.jdbc.Driver": jdbcDriver ;
			Class.forName(jdbcDriver);
			System.out.println("mysql driver load..!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
