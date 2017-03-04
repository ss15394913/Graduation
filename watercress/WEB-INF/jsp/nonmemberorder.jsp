<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>お支払い情報</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="copyright" content="Template Party">
		<meta name="description" content="ここにサイト説明を入れます">
		<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<style>.ddmenu {display: none;}</style>
		<![endif]-->
		<style>
			#card_0 {width: 120px;}
			#card_1 {width: 35px;}
			#card_2 {width: 18px;}
			#card_3 {width: 18px;}
			.name {width: 120px;}
			.req {color: red;}
		</style>
		<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/openclose.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ddmenu_min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/inputDestruction.js" charset="UTF-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/memberorder.js" charset="UTF-8"></script>
	</head>
	<body id="top" class="c1">
		<div id="container">
		
		<header>
			<h1 id="logo">
				<img src="${pageContext.request.contextPath}/images/logo.png" width="275" alt="Sample Online Shop" onclick="showTop()">
			</h1>
			<div class="headermenu">
				<ul>
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
		</nav><br><br><br><br>
		
		<form class="h-adr" action="ordercheck" method="post">
			<h3>お届け先住所</h3>
			
			性<input class="name" type="text" name="firstname" required><p class="req">※必須</p>
			名<input class="name" type="text" name="name" required><p class="req">※必須</p>&nbsp;&nbsp;例：山田&nbsp;太郎<br><br>
			
			セイ<input class="name" type="text" name="kanafirstname" required pattern="^[ァ-ンヴー]+$*"><p class="req">※必須</p>
			メイ<input class="name" type="text" name="kananame" required pattern="^[ァ-ンヴー]+$"><p class="req">※必須</p>&nbsp;&nbsp;例：ヤマダ&nbsp;タロウ<br><br>
			
			<span class="p-country-name" style="display:none;">Japan</span>
			〒郵便番号<input type="text" id="address_0" class="p-postal-code" size="7" maxlength="7" name="zipcode" autocomplete="postal-code"  value="${data.addr0}">&nbsp;&nbsp;例：1648787<br><br>
			
			都道府県　<input name="prefectures" type="text" id="address_1" class="p-region" autocomplete="address-level1" />&nbsp;&nbsp;例：東京都<br>
			市区町村　<input name="city" type="text" id="address_2" class="p-locality" autocomplete="address-level2" />&nbsp;&nbsp;中野区<br>
			番地　　　　<input name="blocknumber" type="text" id="address_3" class="p-street-address" autocomplete="address-line1" />&nbsp;&nbsp;東中野4-2-3<br>
			建物名　　 <input name="bildingname" type="text" id="address_4" class="p-extended-address" autocomplete="address-line2" />&nbsp;&nbsp;専門学校 東京テクニカルカレッジ<br><br>
			
			電話番号<input type="text" name="phonenumber" required><p class="req" pattern="^[0-9]">※必須</p>
				半角数字のみ。ハイフン(-)は入れない。&nbsp;例：09012345678<br><br><br>
			
			<h3>配達時間指定</h3>
			配達希望日&nbsp;<p class="req">※必須</p>
				3営業日後<input type="radio" name="delivery_request_day" value="3" required>
				4営業日後<input type="radio" name="delivery_request_day" value="4">
				5営業日後<input type="radio" name="delivery_request_day" value="5">
				6営業日後<input type="radio" name="delivery_request_day" value="6">
				7営業日後<input type="radio" name="delivery_request_day" value="7"><br>
			配達希望時間&nbsp;<p class="req">※必須</p>
				指定なし<input type="radio" name="delivery_request_time" value="指定なし" required>
				午前<input type="radio" name="delivery_request_time" value="午前">
				<input type="radio" name="delivery_request_time" value="12時～14時">12時～14時<br>
				<input type="radio" name="delivery_request_time" value="14時～16時">14時～16時
				<input type="radio" name="delivery_request_time" value="16時～18時">16時～18時
				<input type="radio" name="delivery_request_time" value="18時～20時">18時～20時
				<input type="radio" name="delivery_request_time" value="20時～21時">20時～21時<br>
			
			<!-- クレジットか代引きのチェックボックス（クレジットの場合記述必須にする）--><br><br>
			<h3>お支払方法の選択&nbsp;</h3><p class="req">※必須</p>
			<input id="pay_card" type="radio" name="payment_method" value="creditCard" onclick="changeRequiredCardInfo();">
			クレジットカード<br>カード番号<input class="card" id="card_0" type="text" name="creditcardnumber" disabled>
			セキュリティコード<input class="card" id="card_1" type="text" name="securitycode" disabled="true">
			年<input class="card" id="card_2" type="text" name="expirationdate_year" disabled="true">
			月<input class="card" id="card_3" type="text" name="expirationdate_month" disabled="true"><br>
			半角数字のみ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;例：1234123412341234
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			年/月 例：20/10<br><br>
			
			<input type="radio" name="payment_method" value="cashOnDelivery" onclick="changeRequiredCardInfo();" required>商品代引き<br>手数料324円<br><br>
			
			<table class="ta1">
				<tr>
					<th>注文合計</th>
					<td id="order_total" name="order_total">${data.orderprice}円</td>
				</tr>
				<tr>
					<th>手数料</th>
					<td id ="comission" name="comission">0円</td>
				</tr>
				<tr>
					<th>合計</th>
					<td id="payment_total" name="total_price">${data.totalprice}円</td>
				</tr>
			</table><br>
			
			<input type="hidden" value="" name="orderprice">
			<input id="hiddentotalprice" type="hidden" value="" name="totalprice">
			<p><input type="submit" value="注文する"></p>
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
</html>
