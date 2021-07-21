<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="member.Member"%>
<%
	//1. 사용자가 입력한 데이터를 받고
	// 입력데이터의 한글 처리!!!
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int resultCnt = 0;
	// 2. DB 처리 : insert
	// 데이터베이스 드라이버 로드
	Connection conn = null;
	MemberDao memdao = null;
	try {
		conn = ConnectionProvider.getConnection();
		resultCnt = memdao.insertMember(conn, new Member(id, pw, name));

	} catch (Exception e) {
	}
	if (resultCnt > 0) {
%>
<script>
	alert("등록되었습니다");
	location.href = "submit_result.jsp";
</script>
<%
	} else {
%>
<script>
	alert("등록되지 않았습니다. 이전페이지로 돌아갑니다");
	window.history.go(-1);
</script>
<%
	}
%>


