<!--
式言語で取得できるデータ
data : List<Map> 【${data}】
 ┃
 ┗Map<String, Object>
   ┃
   ┗"productCatalog",ProductCatalogBean
   ┗"tagNames",List<String>
-->


<%@page pageEncoding="UTF-8"
   contentType="text/html;charset=UTF-8"
   %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>カートへ商品の追加</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" type="text/css" href="../css/style.css" />

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<style>.ddmenu {display: none;}</style>
<![endif]-->
<script type="text/javascript" src="../../js/openclose.js"></script>
<script type="text/javascript" src="ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="top.html"><img src="../../images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="userentry.html">会員登録</a>
<a href="login.html">ログイン</a>
</ul>
<div id="cart"><a href="#">CART</a></div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="list.html">TOPS</a></li>
    <li><a href="list2.html">BOTTOMS</a></li>
    <li><a href="list3.html">UNDER</a></li>
    <li><a href="list4.html">SHOES</a></li>
    <li><a href="list5.html">ACCESSORIES</a></li>
	</ul>
</li>
<li class="arrow"><a href="productlist.html">SALE</a>
</li>
<li class="arrow"><a href="productlist.html">RANKING</a>
</li>
<li class="arrow"><a href="productlist.html">ALLITEM</a>
</li>
<li class="arrow"><a>HELP</a>
    <ul class="ddmenu">
    <li><a href="contact.html">お問い合わせ</a></li>
    <li><a href="question.html">Q&A</a></li>
</li>
</ul>
</nav>
<%
	
%>
	<h1>カートへ商品の追加</h1>
	<form action="${pageContext.request.contextPath}/front/addcart" method="post">
		<input type="hidden" name="productid" value="1">商品ID
		<input type="hidden" name="itemcount" value="2">商品個数
		<input type="submit" value="idが1の商品を２個注文">
	</form>
	<form action="${pageContext.request.contextPath}/front/addcart" method="post">
		<input type="hidden" name="productid" value="1">商品ID
		<input type="hidden" name="itemcount" value="5">商品個数
		<input type="submit" value="idが1の商品を５個注文">
	</form>
	<form action="${pageContext.request.contextPath}/front/addcart" method="post">
		<input type="hidden" name="productid" value="2">商品ID
		<input type="hidden" name="itemcount" value="3">商品個数
		<input type="submit" value="idが2の商品を注文">
	</form>
<footer>
<div class="footermenu">
<ul>
<a href="companyinfo.html">会社概要　　　</a>
<a href="tos.html">　　　利用規約</a>
<a href="sitemap.html">　　　サイトマップ</a>
<a href="privacypolicy.html">　　　個人情報保護方針</a>
<a href="deal.html">　　　特定商取引法</a>
<a href="contact.html">　　　お問い合わせ</a>
<a href="question.html">　　　Q&A</a>
<br>
<br>
</ul>

<center><small>Copyright&copy; <a href="top.html">Sample Online Shop</a>　All Rights Reserved.</small>
<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>

</footer>
</body>
</html>
