<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
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
	<h1>Product List</h1>
	
	<% List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list"); 
	for (ProductDTO productDTO : ar){
	%>
	<h3><%=productDTO.getProduct_num() %></h3>
	<h3><%=productDTO.getProduct_name() %></h3>

	<%} %>
	<hr>
	
	<!-- 안꺼내와도댄다, 형변환없이 추적해준다. -->
	<c:forEach items="${list}" var="dto"> <!-- page영역에 담김 (page: 현재 jsp에서만 사용가능한 영역)-->
		<h3>${ pageScope.dto.product_num }</h3>
		<h3>${dto.product_name }</h3>
	</c:forEach>
	
	<h3>${list}</h3>
	
	<a href="./detail?product_num=11">productDetail</a>
	
	
	<!-- 
	현재 url주소를 봐! 
	http://localhost/product/list
	같은 폴더안의 
	11L아님 전부 string으로 넘김
	 -->
</body>
</html>