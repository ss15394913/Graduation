<%@ page contentType="text/html;utf-8"
	import="java.util.List"
	import="java.util.ArrayList"
	import="java.util.Iterator"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!--更新ボタン押すと直前の商品が追加されちゃう状態です-->
<!--塩澤、河野-->
	
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>Watercress_TOP</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<style>.ddmenu {display: none;}</style>
<![endif]-->
<script type="text/javascript" src="js/openclose.js"></script>
<script type="text/javascript" src="ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="top.html"><img src="images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
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


<head><title>商品一覧</title></head>
<body>
<%
	/*複数の商品を入れるためのリストを作成*/
	List name = new ArrayList();
	String def = "現在カートの中に商品はありません";
	
	/*ObjectのmaxNumをint型に変換*/
	/*getAttributeはObject型を返すので、一旦Integer型に変換してから
	int型に変換する必要がある*/
	
	Integer maxInteger = (Integer)session.getAttribute("maxNum");
	if(maxInteger==null){
		maxInteger=-1;
	}
	int maxInt = maxInteger.intValue();
	
	
	/*CartProductServletで先に+1されてるので数合わせのために-1する*/
	maxInt -= 1;
	
	/*0以上maxInt以下*/
	for(int j = 0;j <= maxInt;j ++){
		
		/*変数jと同じ数字のresultがname[j]に入る*/
		name.add((String)session.getAttribute("result" + j));
	}
	if(name == null){
		name.add(def);
	}
	if(maxInteger<=-1){
		name.add(def);
	}
	
%>
	<h1>商品一覧</h1>
	<form  method="post" action="EditCart">
	
	<table border="1">
		<tr><th>商品名</th></tr>
		<%
			int i=0;
			Iterator it = name.iterator();
			while(it.hasNext()){
				out.println(
				"<tr><td><input type="+"checkbox"+" name="+"listNumber"+" value="+i+">"
				+it.next()+"</td></tr>");
				i++;
			}
		%>
	</table>
	<br>
	<br>
	<br>
	<input type="submit" value="削除">
	</form>
	<br>
	<br>
	<h1>商品削除</h1>
	
	<a href="start.jsp">TOPへ</a>
</body>

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
</html>