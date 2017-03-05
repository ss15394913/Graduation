<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
	<head>
	    <meta charset="utf-8">
	    <title>会社概要</title>
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
					<ul class="ddmenu">//koko
						<li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
						<li><a href="${pageContext.request.contextPath}/front/question">Q&A</a></li>
				</li>
			</ul>
		</nav>

		<div id="contents">

		<div id="main">

			<section>

				<h2 class="mb15">会社概要</h2>

					<table class="ta1">

						<tr>
							<th>社名</th>
							<td>株式会社Watercress</td>
						</tr>
                        
						<tr>
							<th>本社</th>
							<td>〒164-8787<br>東京都中野区東中野4-2-3</td>
						</tr>
                        
						<tr>
							<th>代表者</th>
							<td>代表取締役社長　塩澤麻人</td>
						</tr>
                        
						<tr>
							<th>設立</th>
							<td>1996年4月4日</td>
						</tr>
                        
						<tr>
							<th>事業内容</th>
							<td>
								商品企画・生産・物流・販売までの自社一貫コントロールにより、高品質・低価格のカジュアルブランド
								「Watercress」を提供する製造小売業
							</td>
						</tr>
					</table>

			</section>


		</div>
            
		<!--/main-->

			<div id="sub">

				<nav class="box1">
					<h2>MENU</h2>
					<ul class="submenu mb10">
						<li><a href="${pageContext.request.contextPath}/front/companyinfo">会社概要</a></li>
						<li><a href="${pageContext.request.contextPath}/front/tos">利用規約</a></li>
						<li><a href="${pageContext.request.contextPath}/front/sitemap">サイトマップ</a></li>
						<li><a href="${pageContext.request.contextPath}/front/privacypolicy">個人情報保護方針</a></li>
						<li><a href="${pageContext.request.contextPath}/front/deal">特定商取引法</a></li>
					</ul>
				</nav>


			</div>
		
		<!--/contents-->
		
		<div id="sub">
			
				<nav class="box1">
					<h2>MENU</h2>
					<ul class="submenu mb10">
						<li><a href="${pageContext.request.contextPath}/front/companyinfo">会社概要</a></li>
						<li><a href="${pageContext.request.contextPath}/front/tos">利用規約</a></li>
						<li><a href="${pageContext.request.contextPath}/front/sitemap">サイトマップ</a></li>
						<li><a href="${pageContext.request.contextPath}/front/privacypolicy">個人情報保護方針</a></li>
						<li><a href="${pageContext.request.contextPath}/front/deal">特定商取引法</a></li>
					</ul>
				</nav>
			</div>
		
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

		</footer>
        
		<!--スマホ用メニューバー-->
		<img src="${pageContext.request.contextPath}/images/icon_bar.png" width="20" height="23" alt="" id="menubar_hdr" class="close">
		<script type="text/javascript">
			if (OCwindowWidth() < 480) {
			open_close("menubar_hdr", "menubar");
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
