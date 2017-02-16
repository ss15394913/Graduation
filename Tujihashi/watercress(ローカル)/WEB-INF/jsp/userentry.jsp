<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>Watercress_TOP</title>
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
<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>

</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="${pageContext.request.contextPath}/front/top"><img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="${pageContext.request.contextPath}/front/userentry">会員登録</a>
<a href="${pageContext.request.contextPath}/front/login">ログイン</a>
</ul>
<div id="cart"><a href="#">CART</a></div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}/list">TOPS</a></li>
    <li><a href="${pageContext.request.contextPath}/list2">BOTTOMS</a></li>
    <li><a href="${pageContext.request.contextPath}/list3">UNDER</a></li>
    <li><a href="${pageContext.request.contextPath}/list4">SHOES</a></li>
    <li><a href="${pageContext.request.contextPath}/list5">ACCESSORIES</a></li>
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
    <li><a hre
<!--/container-->
<br>
<br>
	<p>登録画面</p>
		<form id="registform" class="h-adr" action="${pageContext.request.contextPath}/front/entrycheck" method="post">
			名前<input type="text" name="memberName" required>例：山田 太郎<br><br>
			
			
			ナマエ<label><input type="text" value="" name="memberKana" pattern="^[ァ-ン]+$" required></label>
			例；ヤマダ タロウ
			<br><br>
			生年月日<input type="date" name="memberBirthday" required>&nbsp;&nbsp;例:2000/01/01<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
		

		    〒<input type="text" name="memberZipCode" class="p-postal-code" size="7" maxlength="7">
		    <br>

		    都道府県<input type="text" name="memberAddress" class="p-region" readonly /><br>
		    市区<input type="text" name="memberAddress" class="p-locality" readonly /><br>
		    町村<input type="text" name="memberAddress" class="p-street-address" /><br>
		    ビル名<input type="text" name="memberAddress" class="p-extended-address" />
			<br><br>

			電話番号<input type="text" name="memberPhoneNumber" required>例：0120444906<br><br>
			<div>
				<label for="emailInput">メールアドレス</label>&nbsp;&nbsp;例：example@example.com
			</div>
			
			<div>
				<input type="email" name="memberEmail" id="emailInput" autocomplete="email" maxlength="256" required />
			</div>
			
			<div>
				<label for="emailConfirm">メールアドレス確認</label>
			</div>
			
			<div>
				<input type="email" id="emailConfirm" autocomplete="email" required onblur="CheckEmail(this)" />
			</div>
			
			<div>
				<label for="passInput">パスワード</label>&nbsp;&nbsp;例：password
			</div>
			
			<div>
				<input type="password" name='memberPassword' id="passInput" pattern="^[0-9A-Za-z]+$" required />
				<input id="passCheckBox"type="checkbox" onclick="CheckPass();" required>パスワードのチェックをする
			</div>
			
			
<!--/contents-->

</div><"Confirm">パスワード確認</label>
			</div>
			
			<div>
				<input type="password" id="passConfirm" required pattern="^[0-9A-Za-z]+$" />
				<p id="passMessage"></p>
			</div>
				利用規約・個人情報保護方針に同意する<input type="checkbox" id="agreeButton" name="consent" required onclick="arrivalButton()"/>
			
			<input id="submitButton" type="submit" value="確認をする" >
		</form>

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

<center><small>Copyright&copy; <a href="${pageContext.request.contextPath}/front/top">Sample Online Shop</a>　All Rights Reserved.</small>
<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>



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
