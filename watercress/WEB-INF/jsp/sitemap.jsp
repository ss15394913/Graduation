<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>


<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>サイトマップ</title>
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
		<input type="hidden" value="${sessionScope.login}">
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
			<br><br><br><br><br><br>
			
			<table border="0" cellspacing="40" cellpadding="6" align="center">
				<tr>
					<td class="sm1">
						<h4><font color="#CCCCFF">■</font>TOPS</h4>
						
						<ul class="tops">
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=outer">
								<li><font color="blue"><u>OUTER</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=shirt">
								<li><font color="blue"><u>SHIRT</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=sweat">
								<li><font color="blue"><u>SWEAT</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=sweater">
								<li><font color="blue"><u>SWEATER</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=t-shirt">
								<li><font color="blue"><u>T-SHIRT</u></font></li></a>
						</ul>
					</td>
					
					<td class="bottoms">
						<h4><font color="#CCCCFF">■</font>BOTTOMS</h4>
						<ul class="slk1">
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=pants">
								<li><font color="blue"><u>PANTS</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=denim">
								<li><font color="blue"><u>DENIM</u></font></li></a><br><br><br>
						</ul>
					</td>
					
					<td class="under">
						<h4><font color="#CCCCFF">■</font>UNDER</h4>
						<ul class="slk1">
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=boxer">
								<li><font color="blue"><u>BOXER</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=trunks">
								<li><font color="blue"><u>TRUNKS</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=sox">
								<li><font color="blue"><u>SOX</u></font></li></a><br><br>
						</ul>
					</td>
					
					<td class="shoes">
						<h4><font color="#CCCCFF">■</font>SHOES</h4>
						<ul class="slk1">
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=sneakers">
								<li><font color="blue"><u>SNEAKERS</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=sandals">
								<li><font color="blue"><u>SANDALS</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=boots">
								<li><font color="blue"><u>BOOTS</u></font></li></a><br><br>
						</ul>
					</td>
					
					<td class="accesories">
						<h4><font color="#CCCCFF">■</font>ACCESSORIES</h4>
						<ul class="slk1">
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=belt">
								<li><font color="blue"><u>BELT</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=hat">
								<li><font color="blue"><u>HAT</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=bug">
								<li><font color="blue"><u>BAG</u></font></li></a>
							<a href="${pageContext.request.contextPath}/front/productlist?subCategory=watch">
								<li><font color="blue"><u>WATCH</u></font></li></a><br>
						</ul>
					</td>
				</tr>
			</table><br><br><br><br><br><br>
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
			
			<p id="pagetop"><a href="#">↑ PAGE TOP</a></p>
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
