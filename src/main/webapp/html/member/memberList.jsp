<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Member List</h3>
	<c:forEach items="${list}" var="dto1">
		<h3> <a href=".detail?id=${dto1.id}"> ${dto1.name } </a> </h3>
	</c:forEach>
	
</body>
</html>