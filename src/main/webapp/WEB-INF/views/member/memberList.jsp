<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="memberDTO" >
		<h4> <a href="./detail?id=${memberDTO.id}"> ${memberDTO.name} </a> </h4>
	</c:forEach>
	
	<a href="./productAdd"> 등록 </a>
</body>
</html>