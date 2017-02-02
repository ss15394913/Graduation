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
<a href="usercheck.html" >登録情報確認ページ</a>
		
		<form id="registform" class="h-adr" action="" method="post">
			性<input type="text" name="lastName" required>
			&nbsp;&nbsp;&nbsp;
			名<input type="text" name="firstName" required>&nbsp;&nbsp;例：山田 太郎<br><br>
			
			セイ<label><input type="text" value="" name="kanafirstname" pattern="^[ァ-ン]+$" required></label>
			&nbsp;&nbsp;&nbsp;
			メイ<label><input type="text" value="" name="kanalastname" pattern="^[ァ-ン]+$" required></label>
			&nbsp;&nbsp;例；ヤマダ タロウ
			<br><br>
			生年月日<input type="date" name="memberBirthday" required>&nbsp;&nbsp;例:2000/01/01<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
		
			〒郵便番号<input type="text" name="memberZipCode" class="p-postal-code" size="7" maxlength="7" autocomplete="postal-code" required>&nbsp;例:1648787<br><br>
		
			都道府県<input type="text" name="prefectures" class="p-region" autocomplete="address-level1" readonly required/>&nbsp;例：東京都<br>
			市区町村<input type="text" name="municipality" class="p-locality" autocomplete="address-level2" required/>&nbsp;例：中野区<br>
			番地<input type="text" name="address" class="p-street-address" autocomplete="address-line1" required/>&nbsp;例：東中野4-2-3<br>
			建物名<input type="text" name="buildingName" class="p-extended-address" autocomplete="address-line2" required/>&nbsp;例：専門学校東京テクニカルカレッジ<br><br>

			電話番号<input type="text" name="memberPhoneNumber" required>例：0120444906<br><br>
			<div>
				<label for="emailInput">メールアドレス</label>&nbsp;&nbsp;例：example@example.com
			</div>
			
			<div>
				<input type="email" id="emailInput" autocomplete="email" maxlength="256" required />
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
			
			<div>
				<label for="passConfirm">パスワード確認</label>
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
