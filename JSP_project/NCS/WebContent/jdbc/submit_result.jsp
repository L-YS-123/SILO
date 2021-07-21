<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.JdbcUtil"%>

<%
	Connection conn = null;
	MemberDao memdao = MemberDao.getInstance();

	try {

		conn = ConnectionProvider.getConnection();

		request.setAttribute("result", memdao.getMemList(conn));

	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JdbcUtil.close(conn);
	}
%>

<jsp:forward page="view.jsp" />
<!--  list_view.js : view 의 역할만!!!! -->