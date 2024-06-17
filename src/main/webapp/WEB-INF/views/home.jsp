<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<h1>안녕</h1>
<%
	Object obj = request.getAttribute("name");
	out.println(obj);
%>
	<p>${name}</p>
</body>
</html>