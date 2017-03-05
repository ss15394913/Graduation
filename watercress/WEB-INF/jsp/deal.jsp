<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!doctype html>

<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>特定商取引法に基づく表記</title>
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

				<div id="cart">
					<a href="${pageContext.request.contextPath}/front/cart">CART</a>
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
		</div>

		<div id="contents">

			<div align="center">
				<table>
					<h1>特定商取引法に基づく表記</h1><table bgcolor="#999999" border="0" cellpadding="9" cellspacing="1" style="font-size:13px;text-align:left">
						<tr><th bgcolor="#EEEEEE">販売社名</th><td bgcolor="#FFFFFF">株式会社Watercress</td></tr>
						<tr><th bgcolor="#EEEEEE">運営統括責任者</th><td bgcolor="#FFFFFF">塩澤麻人</td></tr>
						<tr><th bgcolor="#EEEEEE">所在地</th><td bgcolor="#FFFFFF">〒164-8787　東京都中野区東中野4-2-3</td></tr>
						<tr><th bgcolor="#EEEEEE">電話番号</th><td bgcolor="#FFFFFF">024-191-9810</td></tr>
						<tr><th bgcolor="#EEEEEE">メールアドレス</th><td bgcolor="#FFFFFF">as15304012@ga.tera-house.ac.jp</td></tr>
						<tr><th bgcolor="#EEEEEE">お支払い方法</th><td bgcolor="#FFFFFF">クレジットカード<br />代金引換<br /></td></tr>
						<tr><th bgcolor="#EEEEEE">商品代金以外の<br />必要金額</th><td bgcolor="#FFFFFF">代金引換の場合、代引き手数料<br />代引き手数料：324円<br />送料：5,000円以上お買い上げ頂いた場合無料　それ以外は一律410円</td></tr>
						<tr><th bgcolor="#EEEEEE">販売数量</th><td bgcolor="#FFFFFF">1個から</td></tr>
						<tr><th bgcolor="#EEEEEE">商品引渡し時期</th><td bgcolor="#FFFFFF">前払いの場合、指定日が無ければ入金確認後3日営業日以内で発送致します。<br />代引の場合、指定日が無ければご注文確認後2日営業日以内で発送致します。<br />その他の場合、指定日が無ければご注文後3日営業日以内で発送致します。<br />後払いの場合、商品到着後3日以内にご入金ください。<br /></td></tr>
						<tr><th bgcolor="#EEEEEE">商品引渡し方法</th><td bgcolor="#FFFFFF">当方にて手配後、運送会社による配送</td></tr>
	                    
						<tr>
							<th bgcolor="#EEEEEE">返品・不良品について</th>
							<td bgcolor="#FFFFFF">
								「不良品・当社の商品の間違え」の場合は当社が負担いたします。<br />
								配送途中の破損などの事故がございましたら、弊社までご連絡下さい。<br />
								送料・手数料ともに弊社負担で早急に新品をご送付致します。<br /><br />
								【返品対象】<br />「不良品・当社の商品の間違え」の場合<br /><br />
								【返品時期】<br />ご購入後5日以内にご連絡があった場合に返金可能となります。<br /><br />
								【返品方法】<br />お問い合わせフォームにて返金要請してください。<br />3日以内にご購入代金を指定の口座へお振込いたします。
							</td>
						</tr>
						<tr><th bgcolor="#EEEEEE">表現、及び商品に<br />関する注意書き</th><td bgcolor="#FFFFFF">本商品に示された表現や再現性には個人差があり、<br />必ずしも利益や効果を保証したものではございません。</td></tr>
				</table>
			</div>
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
					<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a>
					<br>
					<br>
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
