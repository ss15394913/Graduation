<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>ログアウト</title>
	</head>
	<body>
		<div align="center">
			<img src="${pageContext.request.contextPath}/images/logoutcomp.png" width="600" height="350"alt="New Menber Resist"></a>
			<p>※3秒後に自動的にページが移動します</p>
		</div>
		
		<script>
			function move(){
				location.href="${pageContext.request.contextPath}/front/top";	//URLを指定
			}
			setTimeout("move()", 3000);					//3秒後に実行
		</script>
	</body>
</html>
