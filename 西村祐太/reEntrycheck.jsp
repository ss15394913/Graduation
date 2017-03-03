<%@ page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>Watercress_TOP</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="${pageContext.request.contextPath}css/style.css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<style>.ddmenu {display: none;}</style>
<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}js/openclose.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="${pageContext.request.contextPath}top.html"><img src="${pageContext.request.contextPath}images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="${pageContext.request.contextPath}userentry.html">会員登録</a>
<a href="${pageContext.request.contextPath}login.html">ログイン</a>
</ul>
<div id="cart"><a href="#">CART</a></div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}list.html">TOPS</a></li>
    <li><a href="${pageContext.request.contextPath}list2.html">BOTTOMS</a></li>
    <li><a href="${pageContext.request.contextPath}list3.html">UNDER</a></li>
    <li><a href="${pageContext.request.contextPath}list4.html">SHOES</a></li>
    <li><a href="${pageContext.request.contextPath}list5.html">ACCESSORIES</a></li>
	</ul>
</li>
<li class="arrow"><a href="{pageContext.request.contextPath}productlist.html">SALE</a>
</li>
<li class="arrow"><a href="{pageContext.request.contextPath}productlist.html">RANKING</a>
</li>
<li class="arrow"><a href="{pageContext.request.contextPath}productlist.html">ALLITEM</a>
</li>
<li class="arrow"><a>HELP</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}contact.html">お問い合わせ</a></li>
    <li><a href="${pageContext.request.contextPath}question.html">Q&A</a></li>
</li>
</ul>
</nav>

</div>
<!--/contents-->

</div>
<!--/container-->
<br>
<br>
		<p>このメールアドレスは既に利用されております</p>
		<form id="registform" class="h-adr" action="${pageContext.request.contextPath}/front/entrytemp" method="post">
			性　：　${data.firstName}
			<input type="hidden" name="firstName" value="${data.firstName}">
                &nbsp;&nbsp;&nbsp;
        	名　：　${data.lastName}
        	<input type="hidden" name="lastName" value="${data.lastName}">&nbsp;&nbsp;<br><br>

        	セイ　：　${data.fKana}
        	<label><input type="hidden" name="kanaFirstName" pattern="^[ァ-ン]+$" value="${data.fKana}" ></label>
       	 	&nbsp;&nbsp;&nbsp;
               
       	 	メイ　：　${data.lKana}
       	 	<label><input type="hidden" name="kanaLastName" pattern="^[ァ-ン]+$" value="${data.lKana}" ></label>
                &nbsp;&nbsp;
			<br><br>
			
			生年月日　：　${data.birth}
			<input type="hidden" value="${data.birth} name="memberBirthday"><br><br>
			
			〒郵便番号　：　${data.post}
			<input type="hidden" value="${data.post}" name="memberZipCode" class="p-postal-code" size="7" maxlength="7" autocomplete="postal-code" ><br><br>
			
			〒都道府県　：　${data.add1}
			<input type="hidden" value="${data.add1}" name="prefectures" class="p-region" autocomplete="address-level1" /><br>
			
			〒市区町村　：　${data.add2}
			<input type="hidden" value="${data.add2}" name="municipality" class="p-locality" autocomplete="address-level2"/><br>
			
			〒番地　：　${data.add3}
			<input type="hidden" value="${data.add3}" name="address" class="p-street-address" autocomplete="address-line1" /><br>
			
			〒建物名　：　${data.add4}
			<input type="hidden" value="${data.add4}" name="buildingName" class="p-extended-address" autocomplete="address-line2" /><br><br>

			〒電話番号　：　${data.phone}
			<input type="hidden" value="${data.phone}" value="${data.memberPhoneNumber}" name="memberPhoneNumber" ><br><br>
			<div>
				<label for="emailInput">メールアドレス</label>　：　${data.email}
			</div>
				
			<div>
				<input type="hidden" value="${data.email}" id="emailInput" autocomplete="email" maxlength="256" />
			</div>
			
			
			
			<div>
				<label for="passInput">パスワード</label>　：　${data.password}
			</div>
			
			<div>
				<input type="hidden" value="${data.password}" name='memberPassword' id="passInput" pattern="^[0-9A-Za-z]+$" />
				
			</div>
			
			
				<FONT color="red">以上の内容で登録します</FONT><br>
			
			<input id="submitButton" type="submit" value="確認をする" >
		</form>

<footer>

<div class="footermenu">
<ul>
<a href="${pageContext.request.contextPath}companyinfo.html">会社概要　　　</a>
<a href="${pageContext.request.contextPath}tos.html">　　　利用規約</a>
<a href="${pageContext.request.contextPath}sitemap.html">　　　サイトマップ</a>
<a href="${pageContext.request.contextPath}privacypolicy.html">　　　個人情報保護方針</a>
<a href="${pageContext.request.contextPath}deal.html">　　　特定商取引法</a>
<a href="${pageContext.request.contextPath}contact.html">　　　お問い合わせ</a>
<a href="${pageContext.request.contextPath}question.html">　　　Q&A</a>
<br>
<br>
</ul>

<center><small>Copyright&copy; <a href="${pageContext.request.contextPath}top.html">Sample Online Shop</a>　All Rights Reserved.</small>
<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>



</footer>

<!--スライドショースクリプト-->
<script type="text/javascript" src="${pageContext.request.contextPath}js/slide_simple_pack.js"></script>

<!--スマホ用更新情報-->
<script type="${pageContext.request.contextPath}text/javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>