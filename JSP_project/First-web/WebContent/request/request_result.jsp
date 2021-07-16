<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 사용자가 전달한 데이터의 한글 처리
	request.setCharacterEncoding("utf-8");

	//String userId = request.getParameter("userId");
	//String userPw = request.getParameter("userPw");
	String userName = request.getParameter("username");
	String job = request.getParameter("job");

	String[] interests = request.getParameterValues("interest");
	
	
	//request.setAttribute("userId", userId);
	//request.setAttribute("userPw", userPw);
	request.setAttribute("userName", userName);
	request.setAttribute("job", job);
	request.setAttribute("age", 30);	// 30 -> auto Boxing
										// 숫자,문자열 타입은 변수와 달리 초기화 없이 가능
	
	
	
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

	<h1>request Form Test</h1>
	<hr>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%= userId %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<%= userName %>
			</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<%= job %>
			</td>
		</tr>
		<tr>
			<td>관심사항</td>
			<td>
			
				<%
				if(interests != null && interests.length > 0) {
					for(int i=0; i<interests.length; i++) {
						out.println(interests[i]+"<br>");
					}
				}
				%>
			
			</td>
		</tr>

		<tr>

			
		</tr>

	</table>



</body>
</html>