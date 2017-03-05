<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>編集完了</title>
	</head>
	
	<body>
		<div align="center"><img src="${pageContext.request.contextPath}/images/cartedit.png" width="600" height="350"alt="New Menber Resist"></a></div>
		<div align="center"><p>※3秒後に自動的にページが移動します</p></div>
		
		<script>
			function move(){
				location.href="${pageContext.request.contextPath}/front/cart";	//URLを指定
			}
				setTimeout("move()", 3000);					//3秒後に実行
		</script>
	</body>
</html>
