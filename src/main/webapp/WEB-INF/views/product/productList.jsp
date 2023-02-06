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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
	
	<div class="cal-6">
	<table class="table table-hover">
		<thead><th>상품번</th> <th>상품명</th> </thead>

		<tbody>
			<c:forEach items="${list}" var="dto1"> <!-- page영역에 담김 (page: 현재 jsp에서만 사용가능한 영역)-->
				<tr>
				<td> <a href="./detail?product_num=${dto1.product_num}"> ${dto1.product_name } </a></td>
				<td>${dto1.product_num}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
		<a class="btn btn-danger " href="./productAdd">상품등록</a>
	</div>

	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>