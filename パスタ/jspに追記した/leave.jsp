<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>退会確認</title>
	</head>
	<script>
		var arr = document.getElementById("memberid").value;
		parseInt(arr);
		if(arr >0){
			document.getElementById("usermenu").innerHTML = "<a href=\"${pageContext.request.contextPath}/front/mypage\">マイページ</a>&nbsp;<a href=\"${pageContext.request.contextPath}/front/logoutcomp\">ログアウト</a>";	
		}else{
			document.getElementById("usermenu").innerHTML = "<a href=\"${pageContext.request.contextPath}/front/userentry\">会員登録</a>&nbsp;<a href=\"${pageContext.request.contextPath}/front/login\">ログイン</a>";
		}
	</script>
	<body>
		<div align="center">
			<img src="${pageContext.request.contextPath}/images/leavetitle.png" width="600" height="300"alt="New Menber Resist"></a>
			<p><font size="3" face="メイリオ" >※この内容で「退会する」ボタンを押しますと必ず退会が完了いたします。ご注意下さい。</font></p>
			<p><font size="3" face="メイリオ" >※一度承った退会はキャンセルできませんので慎重にお手続きをお願い致します。</font></p>
		
		
			<a href="${pageContext.request.contextPath}/front/leavecomp">
				<img src="${pageContext.request.contextPath}/images/leave.png" width="240" height="80"alt="New Menber Resist">
			</a>
			
			<a href="${pageContext.request.contextPath}/front/top">
				<img src="${pageContext.request.contextPath}/images/noleave.png" width="240" height="80"alt="New Menber Resist">
			</a>
		</div>
	</body>
</html>