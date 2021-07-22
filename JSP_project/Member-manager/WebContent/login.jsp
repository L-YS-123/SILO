<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="util.CookieBox"%>
<%@page import="util.ConnectionProvider" %>
<%@page import="domain.Member" %>
<%
	// 사용자가 전달한 데이터를 받고 -> DB에서 확인 -> 로그인 처리
	// 로그인 처리 -> session객체에 사용자 정보를 저장
	// reid 확인하고 값을 받아오면 쿠키 설정
	
	String memberId = request.getParameter("memberid");
	String password = request.getParameter("password");
	String reid = request.getParameter("reid");
	
	
	boolean loginChk = false;
	
	Connection conn = null;
	MemberDao dao = null;
	
	if(memberId !=null && password !=null && memberId.trim().length()>0 && password.trim().length()>0) {
		
		try{
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			Member member = dao.selectByIdPw(conn, memberId, password);
			
			if(member != null) {
				// 회원의 정보를 Session 객체에 저장
				session.setAttribute("member", member);
				loginChk = true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	// ID 저장을 위한 쿠키 설정
	// reid 값의 유무 체크
	if(reid !=null && reid.equals("on")) {
		// 쿠키 저장: 사용자 ID를 저장
		response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 60*60*24*365));
	} else {
		// 쿠키값을 저장하지 않는다
		response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 0));
	}
	
	if(loginChk) {
		response.sendRedirect("index.jsp");
	} else {
		%>
		<script>
			alert('아이디 또는 비밀번호가 일치하지 않습니다');
			history.go(-1);
		</script>
		<% 
	}
	
%>

<script>
	alert('로그인 되었습니다');
	location.href='<%= request.getContextPath()%>
	'; // /mm/
</script>