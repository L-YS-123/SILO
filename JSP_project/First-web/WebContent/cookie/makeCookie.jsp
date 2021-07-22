<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.CookieBox" %>

<%
	// 쿠키는 문자열 데이터를 사용자의 브라우저에 저장
	// 쿠키 생성 -> response.add(cookie값)
	// Cookie("이름(문자열)", "값(문자열)")
	Cookie cookie = new Cookie("cname","test");
	// 쿠키를 브라우저로 응답
	// response.addCokie(cookie);
	response.addCookie(CookieBox.makeCookie("cname","손흥민"));
	//response.addCookie(new Cookie("number","7"));
	response.addCookie(CookieBox.makeCookie("number", "7"));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
	
</script>
</head>
<body>
	<h1>쿠키 저장</h1>
			
	<a href="viewCookie.jsp">쿠키 보기</a>
	
			
	
</body>
</html>