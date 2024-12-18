<%@page import="guestbook.vo.GuestbookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<GuestbookVo> list = (List<GuestbookVo>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook02/gb" method="post">
		<input type="hidden" name="a" value="insert" >
		<table border=1>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4>
					<textarea name="contents" cols=60 rows=5></textarea>
				</td>
			</tr>
			<tr>
				<td colspan=4 align=right>
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
	
	<%
		for(GuestbookVo vo: list){
	%>
		<br>
		<table width=510 border=1>
			<tr>
				<td>[<%=vo.getId() %>]</td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getRegDate() %></td>
				<td><a href="">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4><%=vo.getContents() %></td>
			</tr>
		</table>
	<%
		}
	%>
</body>
</html>