<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Detail</h1>
	<% ProductDTO productDTO = (ProductDTO)request.getAttribute("dto"); %>
	<% if(productDTO != null) { %>
	<h3><%= productDTO.getProductName() %></h3>
	<h3><%= productDTO.getProductDetail() %></h3>
	
	<hr>
	<h3>${requestScope.dto.product_name }</h3>
	<h3>${dto.product_detail }</h3>
	<h3>${dto.getProduct_detail() }</h3>
	<h3>${dto.product_score * 10 }</h3>
	<%} %>
	

</body>
</html>