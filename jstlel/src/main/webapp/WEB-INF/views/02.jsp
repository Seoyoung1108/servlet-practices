<%@page import="jstlel.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// page scope
	UserVo vo4 = new UserVo();
	vo4.setId(4L);
	vo4.setName("둘리4");
	pageContext.setAttribute("vo", vo4);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>scope(객체의 존속범위)</h4>
	${vo.id }<br>
	${vo.name }
	
	== request scope ==<br>
	${requestScope.vo.id }<br>
	${requestScope.vo.name }
	
	<!-- sessionScope, applicationScope -->
</body>
</html>