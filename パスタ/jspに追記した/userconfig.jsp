<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>アカウント設定</title>
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ddmenu_min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/userentry.js"></script>
		<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
	</head>
	<input type=”hidden” value="${sessionScope.login}">
	<body id="top" class="c1">
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
					<div id="cart">
						<a href="${pageContext.request.contextPath}/front/cart">CART</a>
					</div>
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
			</nav>
			<form id="registform" class="h-adr" action="userconfigcomp" method="post"><br><br><br>
				<h3>アカウント設定編集</h3>
				性<input type="text" name="firstname" value="${data.fName}" required>   
				名<input type="text" name="lastname" value="${data.lName}" required> 例：山田 太郎<br><br>
				
				セイ<label><input type="text" name="kanafirstname" pattern="^[ァ-ン]+$" value="${data.fKana}" required></label>   
				メイ<label><input type="text" name="kanalastname" pattern="^[ァ-ン]+$" value="${data.lKana}" required></label> 例：ヤマダ タロウ<br><br>
				
				生年月日<input type="date" name="birthday" value="${data.birth}" required>&nbsp;&nbsp;例:2000/01/01<br><br>
				
				<span class="p-country-name" style="display:none;">Japan</span>
				〒郵便番号<input type="text" class="p-postal-code" size="7" maxlength="7" name="code"
					autocomplete="postal-code" value="${data.post}" required> 例:1648787<br><br>
				都道府県<input type="text" class="p-region" autocomplete="address-level1"  name="region"
					value="${data.add1}" readonly required /> 例：東京都<br>
				市区町村<input type="text" class="p-locality" autocomplete="address-level2"  name="locality"
					value="${data.add2}" required /> 例：中野区<br>
				番地<input type="text" class="p-street-address" autocomplete="address-line1" name="street"
					value="${data.add3}" required /> 例：東中野4-2-3<br>
				建物名<input type="text" class="p-extended-address" autocomplete="address-line2" name="extended"
					value="${data.add4}" /> 例：専門学校東京テクニカルカレッジ<br><br>
				
				電話番号<input type="text" name="phone_number" value="${data.phone}" required> 例：0120444906<br><br>
				
				<div><label for="emailInput">メールアドレス</label> 例：example@example.com</div>
				<div><input type="email" id="emailInput" name="email" autocomplete="email" maxlength="256" value="${data.email}" required /></div>
				
				<div><label for="emailConfirm">メールアドレス確認</label></div>
				<div><input type="email" id="emailConfirm" autocomplete="email" maxlength="256" value="${data.email}" required onblur="CheckEmail(this)" /></div>
				
				<div><label for="passInput">パスワード</label> 例：password</div>
				<div><input type="password" id="passInput" name="password" pattern="^[0-9A-Za-z]+$" required />
					<input id="passCheckBox" type="checkbox" onclick="CheckPass();" required>パスワードのチェックをする
				</div>
				
				<div><label for="passConfirm">パスワード確認</label></div>
				<div><input type="password" id="passConfirm" required pattern="^[0-9A-Za-z]+$" /><p id="passMessage"></p></div>
				
				<input id="submitButton" type="submit" value="設定変更">
			</form>
		</div>
		
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
	</body>
	<script>
		var arr = document.getElementById("memberid").value;
		parseInt(arr);
		if(arr >0){
			document.getElementById("usermenu").innerHTML = "<a href=\"${pageContext.request.contextPath}/front/mypage\">マイページ</a>&nbsp;<a href=\"${pageContext.request.contextPath}/front/logoutcomp\">ログアウト</a>";	
		}else{
			document.getElementById("usermenu").innerHTML = "<a href=\"${pageContext.request.contextPath}/front/userentry\">会員登録</a>&nbsp;<a href=\"${pageContext.request.contextPath}/front/login\">ログイン</a>";
		}
	</script>
</html>
