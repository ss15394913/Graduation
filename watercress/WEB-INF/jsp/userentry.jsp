<%@ page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>アカウント登録</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="copyright" content="Template Party">
		<meta name="description" content="ここにサイト説明を入れます">
		<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<style>.ddmenu {display: none;}</style>
		<![endif]-->
		<style>.name {width: 120px;}</style>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/openclose.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ddmenu_min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/userentry.js"></script>
		<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
	</head>
	
	<body id="top" class="c1">
		<input type="hidden" value="${sessionScope.login}" id="memberid">
		<div id="container">
		
			<header>
				<h1 id="logo">
					<img src="${pageContext.request.contextPath}/images/logo.png" width="275" alt="Sample Online Shop" onclick="showTop()">
				</h1>
				<div class="headermenu">
					<ul id="usermenu">
						<a href="${pageContext.request.contextPath}/front/userentry">会員登録</a>
						<a href="${pageContext.request.contextPath}/front/login">ログイン</a>
					</ul>
					<div id="cart"><a href="${pageContext.request.contextPath}/front/cart">CART</a></div>
				</div>
			</header>
			<nav id="menubar">
				<ul>
					<li class="arrow">
						<a>CATEGORY</a>
						<ul class="ddmenu">
							<li><a href="${pageContext.request.contextPath}/front/productlist?category=tops">TOPS</a></li>
							<li><a href="${pageContext.request.contextPath}/front/productlist?category=bottoms">BOTTOMS</a></li>
							<li><a href="${pageContext.request.contextPath}/front/productlist?category=under">UNDER</a></li>
							<li><a href="${pageContext.request.contextPath}/front/productlist?category=shoes">SHOES</a></li>
							<li><a href="${pageContext.request.contextPath}/front/productlist?category=accessories">ACCESSORIES</a></li>
						</ul>
					</li>
					
					<li class="arrow">
						<a href="${pageContext.request.contextPath}/front/productlist?searchTag=セール">SALE</a>
					</li>
					
					<li class="arrow">
						<a href="${pageContext.request.contextPath}/front/productlist?sort=purchaseDesc">RANKING</a>
					</li>
					
					<li class="arrow">
						<a href="${pageContext.request.contextPath}/front/productlist">ALLITEM</a>
					</li>
					
					<li class="arrow">
						<a>HELP</a>
						<ul class="ddmenu">
							<li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
							<li><a href="${pageContext.request.contextPath}/front/question">Q&A</a></li>
						</ul>
					</li>
				</ul>
			</nav><br><br>
			<div id="main">
				<h2>アカウント登録</h2>
				<form id="registform" class="h-adr" action="${pageContext.request.contextPath}/front/entrycheck" method="post">
					
					&nbsp;&nbsp;性&nbsp;<input type="text" class="name" name="firstName" value="${data.firstName}" required>&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;名&nbsp;<input type="text" class="name" name="lastName" value="${data.lastName}" required>&nbsp;例：山田 太郎&nbsp;<span style="color: red;">※必須</span><br><br>
					
					セイ<label><input type="text" class="name" name="kanaFirstName" pattern="^[ァ-ンヴー]+$" value="${data.fKana}" required></label>&nbsp;&nbsp;&nbsp;
					メイ<label><input type="text" class="name" name="kanaLastName" pattern="^[ァ-ンヴー]+$" value="${data.lKana}" required></label>&nbsp;例：ヤマダ タロウ&nbsp;<span style="color: red;">※必須</span><br><br>
					
					生年月日<input type="date" name="memberBirthday" required>&nbsp;例:2000/01/01&nbsp;<span style="color: red;">※必須</span><br><br>
					
					<span class="p-country-name" style="display:none;">Japan</span>
					〒<input type="text" name="memberZipCode" class="p-postal-code" size="7" maxLength="7" 
						autocomplete="postal-code" required>&nbsp;例：1648787&nbsp;<span style="color: red;">※必須</span><br>
					
					都道府県<input type="text" name="prefectures" class="p-region" />&nbsp;例：東京都&nbsp;<span style="color: red;">※必須</span><br>
					市区町村<input type="text" name="municipality" class="p-locality"  />&nbsp;例：中野区&nbsp;<span style="color: red;">※必須</span><br>
					　番地　<input type="text" name="address" class="p-street-address" />&nbsp;例：東中野4-2-3&nbsp;<span style="color: red;">※必須</span><br>
					&nbsp;建物名&nbsp;&nbsp;<input type="text" name="buildingName" class="p-extended-address" />&nbsp;例：専門学校東京テクニカルカレッジ<br><br>
					
					電話番号<input type="text" name="memberPhoneNumber" minlength="10" maxlength="11" required>&nbsp;例：0120444906&nbsp;※半角数字のみ、ハイフン(-)は入れない&nbsp;<span style="color: red;">※必須</span><br><br>
					
					<div><label for="emailInput">メールアドレス</label>&nbsp;例：example@example.com&nbsp;<span style="color: red;">※必須</span></div>
					<div><input type="email" name="memberEmail" id="emailInput" autocomplete="email" maxlength="256" required /></div>
					
					<div><label for="emailConfirm">メールアドレス確認</label></div>
					<div><input type="email" id="emailConfirm" autocomplete="email" required onblur="CheckEmail(this)" /></div>
					
					<div><label for="passInput">パスワード</label>&nbsp;例：password&nbsp;※8文字以上&nbsp;<span style="color: red;">※必須</span></div>
					<div>
						<input type="password" name='memberPassword' id="passInput" pattern="^[0-9A-Za-z]+$" required />
						<input id="passCheckBox"type="checkbox" onclick="CheckPass();" required>パスワードのチェックをする
					</div>
					
					
					<div><label for="passConfirm">パスワード確認</label></div>
					<div><input type="password" id="passConfirm" required pattern="^[0-9A-Za-z]+$" /><p id="passMessage"></p></div>
					
					利用規約・個人情報保護方針に同意する<input type="checkbox" id="agreeButton" name="consent" required onclick="arrivalButton()"/><br><br>
					
					<input id="submitButton" type="submit" value="確認する" >
				</form>
			</div>
			<!--/main-->
		</div>
		<!--/container-->
		
		<footer>
			<div class="footermenu">
				<ul>
					<a href="${pageContext.request.contextPath}/front/companyinfo">会社概要　　　</a>
					<a href="${pageContext.request.contextPath}/front/tos">　　　利用規約</a>
					<a href="${pageContext.request.contextPath}/front/sitemap">　　　サイトマップ</a>
					<a href="${pageContext.request.contextPath}/front/privacypolicy">　　　個人情報保護方針</a>
					<a href="${pageContext.request.contextPath}/front/deal">　　　特定商取引法</a>
					<a href="${pageContext.request.contextPath}/front/contact">　　　お問い合わせ</a>
					<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a><br><br>
				</ul>
			</div>
			
			<div align="center">
				<small>Copyright&copy; <a href="${pageContext.request.contextPath}/front/top">Sample Online Shop</a>　All Rights Reserved.</small>
				<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>
			</div>
		</footer>
		
		<!--スライドショースクリプト-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/slide_simple_pack.js"></script>
		
		<!--スマホ用更新情報-->
		<script type="text/javascript">
			if (OCwindowWidth() < 480) {
				open_close("newinfo_hdr", "newinfo");
			}
		</script>
		
		<!--トップ表示-->
		<script>
			function showTop(){
				location.href = "${pageContext.request.contextPath}/front/top";
			}
		</script>
		
		<script>
			var arr = document.getElementById("memberid").value;
			parseInt(arr);
			if(arr >0){
				document.getElementById("usermenu").innerHTML = "<a href=\"${pageContext.request.contextPath}/front/mypage\">マイページ</a>&nbsp;<a href=\"${pageContext.request.contextPath}/front/logoutcomp\">ログアウト</a>";	
			}else{
				document.getElementById("usermenu").innerHTML = "<a href=\"${pageContext.request.contextPath}/front/userentry\">会員登録</a>&nbsp;<a href=\"${pageContext.request.contextPath}/front/login\">ログイン</a>";
			}
		</script>
	</body>
</html>
