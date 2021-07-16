<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<%@ include file="include/header.jsp"%>
	<hr>
	<%@ include file="include/navigation.jsp" %>
	
	<div id="wrap">
	<%@ include file="include/news.jsp" %>
	<%@ include file="include/shopping.jsp" %>
	</div>
	
	실행된 jsp->html 결과를 가져온다
	<jsp:include page="footer.jsp">
		<jsp:param value="email" name="test@gmail.com"/>
		<jsp:param value="010-0000-0000" name="tel"/>
	</jsp:include>
	
	
	
	
	
</body>
</html>