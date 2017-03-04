<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>ログイン</title>
	</head>
	<body>
		<div align="center">
			<img src="${pageContext.request.contextPath}/images/login.png" alt="Login">
			<table border="0">
				<form action="${pageContext.request.contextPath}/front/logincomp" method="post">
					<tr>
						<th>Email</th>
							<td>
								<input type="email" name="email" size="24" required>
							</td>
					</tr>
					
					<tr>
						<th>Password</th>
						<td>
							<input type="password" name="pass" size="24" required>
						</td>
					</tr>
					
					<tr>
						<td colspan="2"><br>
							<div align="center"><input type="submit" value="GO"></div>
						</td>
					</tr>
				</form>
			</table>
		</div>
		
		<div align="center">
			<p id="pagetop"><a href="${pageContext.request.contextPath}/front/top">PAGE TOP</a></p>
		</div>
		
		<div align="center">
			<a href="${pageContext.request.contextPath}/front/userentry">
		</div>
		
		<div align="center">
			<img src="${pageContext.request.contextPath}/images/new_member.png" width="240" height="80"alt="New Menber Resist"></a>
		</div>
	</body>
</html>