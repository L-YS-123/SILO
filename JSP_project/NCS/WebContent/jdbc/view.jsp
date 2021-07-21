<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="member.Member"%>

<%
	List<Member> list = (List<Member>) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 1px solid #aaa;
}
</style>
<script>
	
</script>
</head>
<body>

	<table>
		<tr>
			<th>회원 아이디</th>
			<th>회원 비밀번호</th>
			<th>회원이름</th>
		</tr>

		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
		%>

		<tr>
			<td><%=list.get(i).getId()%></td>
			<td><%=list.get(i).getPw()%></td>
			<td><%=list.get(i).getName()%></td>
		</tr>

		<%
				}
			}
		%>

	</table>



</body>
</html>