package dept.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {

	DeptDao dao = DeptDao.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetDeptList() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		List<Dept> list = dao.getDeptList(conn);
		assertNotNull("list is not null", list);

	}

	@Test
	public void testInsertDept() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		int resultCnt = dao.insertDept(conn, new Dept(777, "이름", "위치"));

		assertNotNull("resultCnt is not null", resultCnt);
		// java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '777' for
		// key 'dept.PRIMARY' 에러발생
		// 입력은 됨
	}

	@Test
	public void testDeleteDept() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		int resultCnt = dao.deleteDept(conn, 9);

		assertNotNull("resultCnt is not null", resultCnt);
	}

	@Test
	public void testSelectByDeptno() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		Dept dept = dao.selectByDeptno(conn, 10);
		
		assertNotNull("new dept is not null",dept);

	}

	@Test
	public void testUpdateDept() throws SQLException {
		Connection conn = ConnectionProvider.getConnection();
		int resultCnt = dao.updateDept(conn, new Dept(777,"제이","유닛"));
		
		assertNotNull("resultCnt is not null",resultCnt);
	}

}
