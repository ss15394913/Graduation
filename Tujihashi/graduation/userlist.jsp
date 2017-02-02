<%@ page pageEncoding = "Windows-31J"
	contentType = "text/html;charset=Windows-31J" %>
	
	<%--JSTL 1.1.2coreタグライブラリ--%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	
	<html>
	<head><title>登録されたユーザー</title></head>
	<body>
	
		<h1>登録されたユーザー<h1>
		<table border = "1">
		<tr><th>ユーザー名</th><th>パスワード</th><th>郵便番号</th></tr>
		<c:forEach var = "user" items = "${users}">
			<tr><td>${user.memberName}</td><td>${user.memberPassword}</td><td>${user.memberAddress}</td></tr>
		</c:forEach>
		</table>
		
	</body>
	</html>