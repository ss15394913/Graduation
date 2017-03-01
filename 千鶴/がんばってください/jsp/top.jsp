<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<title>Watercress_TOP</title>
</head>
<body id="top" class="c1">

<div id="container">

<header>
    <h1 id="logo">
        <a href="${pageContext.request.contextPath}/front/top"><img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a>
    </h1>
    <div class="headermenu">
        <ul>
            <a href="${pageContext.request.contextPath}/front/userentry">会員登録</a>
            
            <a href="${pageContext.request.contextPath}/front/editaccount">登録情報の変更</a>
            
            <a href="${pageContext.request.contextPath}/front/login">ログイン</a>
            <a href="${pageContext.request.contextPath}/front/logoutcomp">ログアウト</a>
            <a href="${pageContext.request.contextPath}/front/leave">退会</a>
        </ul>
        <div id="cart"><a href="${pageContext.request.contextPath}/front/cart">CART</a></div>
    </div>
</header>

<nav id="menubar">
<ul>
    <li class="arrow"><a>CATEGORY</a>
        <ul class="ddmenu">
            <li><a href="${pageContext.request.contextPath}/front/list">TOPS</a></li>
            <li><a href="${pageContext.request.contextPath}/front/list">BOTTOMS</a></li>
            <li><a href="${pageContext.request.contextPath}/front/list">UNDER</a></li>
            <li><a href="${pageContext.request.contextPath}/front/list">SHOES</a></li>
            <li><a href="${pageContext.request.contextPath}/front/list">ACCESSORIES</a></li>
	    </ul>
    </li>
    <li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">SALE</a></li>
    <li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">RANKING</a></li>
    <li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">ALLITEM</a></li>
    <li class="arrow"><a>HELP</a>
        <ul class="ddmenu">
            <li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
            <li><a href="${pageContext.request.contextPath}/front/question">Q&amp;A</a></li>
        </ul>
    </li>
</ul>
</nav>

<div id="contents">

<aside id="mainimg">
<img class="slide_file" src="${pageContext.request.contextPath}/images/1.jpg" title="${pageContext.request.contextPath}/front/top" alt="">
<img class="slide_file" src="${pageContext.request.contextPath}/images/2.jpg" title="${pageContext.request.contextPath}/front/top" alt="">
<input type="hidden" id="slide_loop" value="0">
<a href="${pageContext.request.contextPath}/front/top" id="slide_link">
<img id="slide_image" src="${pageContext.request.contextPath}/images/1.jpg" alt="">
<img id="slide_image2" src="${pageContext.request.contextPath}/images/1.jpg" alt=""></a>
</aside>

<div id="main">

<section>

<h2 class="mb15">NEW ARRIVALS</h2>

    <section class="list">
    <a href="${pageContext.request.contextPath}/front/item">
    <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
    <h4>商品名《XXX円》</h4>
    <p>説明文は短めに入力して下さい。沢山詰め込むと表示が途中で切れます。</p>
    </a>
    </section>

    <section class="list">
    <a href="${pageContext.request.contextPath}/front/item">
    <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
    <h4>商品名《XXX円》</h4>
    <p>商品の簡単な説明をここに入れます。</p>
    <span class="osusume">PICKUP</span>
    </a>
    </section>

    <section class="list">
    <a href="${pageContext.request.contextPath}/front/item">
    <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
    <h4>商品名《XXX円》</h4>
    <p>商品の簡単な説明をここに入れます。</p>
    <span class="sumi">SOLD OUT</span>
    </a>
    </section>

    <section class="list">
    <a href="${pageContext.request.contextPath}/front/item">
    <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
    <h4>商品名《XXX円》</h4>
    <p>商品の簡単な説明をここに入れます。</p>
    </a>
    </section>

</section>

<section>

<h2 class="mb15">SALE</h2>

    <section class="list">
    <a href="${pageContext.request.contextPath}/front/item">
    <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
    <h4>商品名《XXX円》</h4>
    <p>説明文は短めに入力して下さい。沢山詰め込むと表示が途中で切れます。</p>
    </a>
    </section>
</section>

<section>

<h2 class="mb15">RANKING</h2>

    <section class="list">
    <a href="${pageContext.request.contextPath}/front/item">
    <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
    <h4>商品名《XXX円》</h4>
    <p>説明文は短めに入力して下さい。沢山詰め込むと表示が途中で切れます。</p>
    </a>
    </section>
</section>

</div>
<!--/sub-->

<p id="pagetop"><a href="#">↑ PAGE TOP</a></p>

</div>
<!--/contents-->

</div>
<!--/container-->

<footer>

</footer>

<!--スライドショースクリプト-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/slide_simple_pack.js"></script>

<!--スマホ用更新情報-->
<script type="text/javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>