<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Add</h1>
	<form action="/join" method="post">
		ID
		<input type="text" name="id">
		PW
		<input type="text" name="pw">
		NAME
		<input type="text" name="name">
		Address
		<input type="text" name="address">
		Phone
		<input type="text" name="phone">
		Email
		<input type="text" name="email">
		
		<button type="submit">등록</button>
	</form>

</body>
</html>