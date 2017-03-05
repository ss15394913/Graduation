<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"
	import = "java.util.List"
	import = "java.util.Iterator"
	import = "java.util.ArrayList"
%>


<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title>Watercress_TOP</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="copyright" content="Template Party">
	<meta name="description" content="ここにサイト説明を入れます">
	<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">

	<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<style>.ddmenu {display: none;}</style>
	<![endif]-->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

</head>
<style>
	#return{
		border:solid 1px #ccc;
		padding:15px 30px;
		margin:0 0 20px;
		font-family:Arial, sans-serif;
		font-size:1.2em;
		text-transform:uppercase;
		font-weight:bold;
		color:#333;
		cursor:pointer;
	}
	
	#return:hover{
		cursor: pointer;
		-moz-transform: scale(1.1,1.1);
		-webkit-transform: scale(1.1,1.1);
		-o-transform: scale(1.1,1.1);
		-ms-transform: scale(1.1,1.1);
	}

</style>

<body id="top" class="c1">
	<br><br><br>
	<center>
		<h2>このアカウントは本登録が済んでいないもしくは</h2>
		<h2>既に退会済みのアカウントです。</h2>
		<h2>会員登録を済ませてから再度ログインを行ってください。</h2>
		<br><br>
		
		<form>
			<input type="button" value="入力ページに戻る" onClick="history.go(-1);" id="return">
		</form>
		
	</center>
</body>
</html>
