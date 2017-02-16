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

</div>
<!--/contents-->

</div>
<!--/container-->
<br>
<br>		
		<form id="registform" class="h-adr" action="${pageContext.request.contextPath}/front/entrytemp" method="post">
			名前<input type="text" value="${data.memberName}" name="firstName" disabled>&nbsp;&nbsp;例：山田 太郎<br><br>
			
			
			ナマエ<label><input type="text" value="${data.memberKana}" name="kanalastname" pattern="^[ァ-ン]+$" disabled></label>
			&nbsp;&nbsp;例；ヤマダ タロウ
			<br><br>
			生年月日<input type="date" value="${data.memberBirthday}" name="memberBirthday" disabled>&nbsp;&nbsp;例:2000/01/01<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
		
			〒郵便番号<input type="text" value="${data.memberZipCode}" name="memberZipCode" class="p-postal-code" size="7" maxlength="7" autocomplete="postal-code" disabled>&nbsp;例:1648787<br><br>
		
			<input type="text" value="${data.memberAddress}" name="prefectures" class="p-region" autocomplete="address-level1" readonly required disabled/>&nbsp;例：東京都<br>
			市区町村<input type="text" name="municipality" class="p-locality" autocomplete="address-level2" required disabled/>&nbsp;例：中野区<br>
			番地<input type="text" name="address" class="p-street-address" autocomplete="address-line1" required disabled/>&nbsp;例：東中野4-2-3<br>
			建物名<input type="text" name="buildingName" class="p-extended-address" autocomplete="address-line2" required disabled/>&nbsp;例：専門学校東京テクニカルカレッジ<br><br>

			電話番号<input type="text" value="${data.memberPhoneNumber}" name="memberPhoneNumber" required disabled>例：0120444906<br><br>
			<div>
				<label for="emailInput">メールアドレス</label>&nbsp;&nbsp;例：example@example.com
			</div>
			
			<div>
				<input type="email" value="${data.memberEmail}" id="emailInput" autocomplete="email" maxlength="256" required disabled/>
			</div>
			
			
			
			<div>
				<label for="passInput">パスワード</label>&nbsp;&nbsp;例：password
			</div>
			
			<div>
				<input type="password" name='memberPassword' id="passInput" pattern="^[0-9A-Za-z]+$" required disabled/>
				<input id="passCheckBox"type="checkbox" onclick="CheckPass();" required disabled>パスワードのチェックをする
			</div>
			
			
				<FONT color="red">以上の内容で登録します</FONT><br>
			
			<input id="submitButton" type="submit" value="確認をする" >
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

<!--スライドショースクリプト-->
<script type="text/javascript" src="js/slide_simple_pack.js"></script>

<!--スマホ用更新情報-->
<script type="text/javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>