<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    	// 쿠키의 삭제: 쿠키 유지시간을 0으로 설정해주면 된다
    	Cookie c = new Cookie("cname", "");
    	c.setMaxAge(0); // 숫자는 초단위
    	response.addCookie(c); // 응답
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

<h1>쿠키가 삭제되었습니다</h1>
<a href="viewCookie.jsp">쿠키 보기</a>


</body>
</html>