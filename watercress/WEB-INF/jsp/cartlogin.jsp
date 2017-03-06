<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>ログイン</title>
	</head>
	<body>
		<div align="center">
			<img src="${pageContext.request.contextPath}/images/login.png" alt="Login">
			<table border="0">
				<form action="${pageContext.request.contextPath}/front/cartlogin" method="post">
					<tr><th>Email</th>
						<td><input type="email" name="email" size="24" required></td>
					</tr>
					<tr><th>Password</th>
						<td><input type="password" name="pass" size="24" required><br></td>
					</tr>
					<tr>
						<td colspan="2"><br>
							<div align="center"><input type="submit" value="GO"></div>
						</td>
					</tr>
				</form>
			</table>
		</div><br>
		<div align="center">
			<table>
				<tr>
					<th><h2>${sessionScope.message1}</h2></th>
				</tr>
				<tr>
					<td><h3>${sessionScope.message2}</h3></td>
				</tr>
				<tr>
					<td><h3>${sessionScope.message3}</h3></td>
				</tr>
			</table>
		</div>
		
		
		<div align="center">
			<p id="pagetop"><a href="${pageContext.request.contextPath}/front/top">PAGE TOP</a></p>
			<a href="${pageContext.request.contextPath}/front/userentry"><img src="${pageContext.request.contextPath}/images/new_member.png" width="240" height="80"alt="New Menber Resist"></a>
		</div>
	</body>
</html>
