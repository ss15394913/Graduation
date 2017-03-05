<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>よくあるお問い合わせ</title>
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
		
			<style type="text/css">
				<!--
				#QandA-1 {
					width: 100%;
					font-family: メイリオ;
					font-size: 14px; /*全体のフォントサイズ*/
				}
				#QandA-1 h2 {

				}
				#QandA-1 dt {
					background: #444; /* 「Q」タイトルの背景色 */
					color: #fff; /* 「Q」タイトルの文字色 */
					padding: 8px;
					border-radius: 2px;
				}
				#QandA-1 dt:before {
					content: "Q.";
					font-weight: bold;
					margin-right: 8px;
				}
				#QandA-1 dd {
					margin: 24px 16px 40px 32px;
					line-height: 140%;
					text-indent: -24px;
				}
				#QandA-1 dd:before {
					content: "A.";
					font-weight: bold;
					margin-right: 8px;
				}

				-->
			</style>

			<div id="QandA-1">
				<br>
				<h2>　　よくあるご質問</h2>
				<dl>
					<dt>商品の購入には必ず会員登録が必要ですか？</dt>
					<dd>会員登録をしなくてもご購入頂けます。</dd>
					<dt>返品したいのですが出来ますか？</dt>
					<dd>返品の際はお問い合わせフォームに記入・送信後
					<br>当社に着払いで送って頂ければ可能です。
					<br>後日新しい商品をお送り致します。</dd>
					<dt>送料はいくらかかりますか？</dt>
					<dd>5,000円以上ご購入頂くと送料無料でご利用頂けます。
					<br>その他は一律送料410円になります。</dd>
				</dl>
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
						<br><br>
					</ul>
				</div>
			</footer>
			
			<script>
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
		</div>
	</body>
</html>
