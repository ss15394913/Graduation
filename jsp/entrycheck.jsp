<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>入力内容確認</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<style>.ddmenu {display: none;}</style>
<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/openclose.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

<div id="container">
<header>
<h1 id="logo"><a href="${pageContext.request.contextPath}/front/top">
<img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="${pageContext.request.contextPath}/front/userentry">会員登録</a>
<a href="${pageContext.request.contextPath}/front/login">ログイン</a>
</ul>
<div id="cart">
	<a href="${pageContext.request.contextPath}/front/cart">CART</a>
</div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}/front/productlist">TOPS</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">BOTTOMS</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">UNDER</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">SHOES</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">ACCESSORIES</a></li>
	</ul>
</li>
<li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">SALE</a>
</li>
<li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">RANKING</a>
</li>
<li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">ALLITEM</a>
</li>
<li class="arrow"><a>HELP</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
    <li><a href="${pageContext.request.contextPath}/front/question">Q&A</a></li>
</li>
</ul>
</nav>

<html>
	<head>
	
<br><br><br>

<h2 class="mb15">入力内容確認</h2>

<table class="ta1">
<tr>
<th>氏名</th>
<td></td>
</tr>
<tr>
<th>ふりがな</th>
<td></td>
</tr>
<tr>
<th>生年月日</th>
<td></td>
</tr>
<tr>
<th>郵便番号</th>
<td></td>
</tr>
<tr>
<th>住所</th>
<td></td>
</tr>
<tr>
<th>電話番号</th>
<td></td>
</tr>
<tr>
<th>メールアドレス</th>
<td></td>
</tr>


</table>

<center><a href="${pageContext.request.contextPath}/front/entrytemp"><img src="${pageContext.request.contextPath}/images/entry.png" width="240" height="80"alt="New Menber Resist"></a>
<a href="${pageContext.request.contextPath}/front/userentry"><img src="${pageContext.request.contextPath}/images/back.png" width="240" height="80"alt="New Menber Resist"></a>

</section>



<footer>

<div class="footermenu">
<ul>
<a href="${pageContext.request.contextPath}/front/companyinfo">会社概要　　　</a>
<a href="${pageContext.request.contextPath}/front/tos">　　　利用規約</a>
<a href="${pageContext.request.contextPath}/front/sitemap">　　　サイトマップ</a>
<a href="${pageContext.request.contextPath}/front/privacypolicy">　　　個人情報保護方針</a>
<a href="${pageContext.request.contextPath}/front/deal">　　　特定商取引法</a>
<a href="${pageContext.request.contextPath}/front/contact">　　　お問い合わせ</a>
<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a>
<br>
<br>
</ul>
</footer>

<!--スライドショースクリプト-->
<script type="text/javascript" src=" ${pageContext.request.contextPath}/js/slide_simple_pack.js"></script>

<!--スマホ用更新情報-->
<script type="text/javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>
