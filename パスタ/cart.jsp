<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>カート</title>
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
		<style>
			#deleteButton{
				align:right;
			}
			#editButton{
				align:right;
			}
			#section_button{
				margin-right:100px;
				align:top;
			}
			#info_section{
				float:left;
			}
		</style>
	
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
	<h2 class="type1">カート</h2>
		<c:forEach var="product" items="${sessionScope.cart}">
			<h3>${product.productName}</h3>
			<section align="left" id="info_section">
				<figure>
					<section class="list">
						<a href="${pageContext.request.contextPath}/front/productdetail">
							<figure><img src="${pageContext.request.contextPath}/images/${product.productImagePath}" alt="${product.productName}" align="left"></figure>
						</a>
					</section>
					<span style="font-size: 16px;"> 色/${product.productColor}</span>
					<span style="font-size: 16px;"> サイズ/${product.productSize}</span><br>
					<span style="font-size: 16px;"> 注文数/${product.count}</span><br>
					<p><font size="3"><em>&yen;${product.productPrice}(税込)</em></font></p>
					
				</figure>
			</section>
			<section align="right" id="section_button">
					<p id="deleteButton">
						<form action="${pageContext.request.contextPath}/front/deletecart" method="post">
							<input type="hidden" name="productid" value="${product.productId}">
							<input type="submit" value="削除する">
						</form>
					</p>
					<p id="editButton">
						<form action="${pageContext.request.contextPath}/front/editcart" method="post">
							<input type="hidden" name="productid" value="${product.productId}">
							<input type="number" name="itemcount" value="1">注文数
							<input type="submit" value="注文数変更">
						</form>
					</p>
			</section>
		</c:forEach><br><br><br><br>
		
		<h3>${data.countProductsInfo}</h3>
	<section id="buyButton">
		<h1>ログインして購入</h1>
			<form action="${pageContext.request.contextPath}/front/cartlogin" method="post">
				<th>Email</th>
					<td><input type="email" name="email" value="" size="24"></td>
				<th>Password</th>
					<td><input type="password" name="pass" minlength="8" value="" size="24"><br></td>

				<p><input type="submit" value="ログイン"></p><br>
				
		<h1>会員登録せず購入</h1>
			<a href="${pageContext.request.contextPath}/front/nonmemberorder">
				<img src="${pageContext.request.contextPath}/images/no_member.png" width="240" height="80" alt="New Menber Resist">
			</a>
	</section>
	<section id="price">
		
	</section>
	</div><!--/sub-->

	<p id="pagetop"><a href="#">↑ PAGE TOP</a></p>

	</div><!--/contents-->
	</div><!--/container-->

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
