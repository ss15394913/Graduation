<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"
	import = "java.util.List"
	import = "java.util.Iterator"
	import = "java.util.ArrayList"
%>


<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<title>Watercress_TOP</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="copyright" content="Template Party">
	<meta name="description" content="ここにサイト説明を入れます">
	<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

	<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<style>.ddmenu {display: none;}</style>
	<![endif]-->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<div id="contents">
			<aside id="mainimg">
				<img class="slide_file" src="${pageContext.request.contextPath}/images/1.jpg" title="" alt="">
				<img class="slide_file" src="${pageContext.request.contextPath}/images/2.jpg" title="" alt="">
				<input type="hidden" id="slide_loop" value="0">
				<a href="${pageContext.request.contextPath}/front/productlist?searchTag=セール" id="slide_link">
					<img id="slide_image" src="${pageContext.request.contextPath}/images/1.jpg" alt="">
					<img id="slide_image2" src="${pageContext.request.contextPath}/images/2.jpg" alt="">
				</a>
			</aside>

			<div id="main">
				<section>
					<h2 class="mb15">NEW ARRIVALS</h2>

					<%! int count = 0; %>
					
					<%
						List list=(ArrayList)request.getAttribute("data");
						List newProductImage=(ArrayList)list.get(3);
						List saleProductImage=(ArrayList)list.get(4);
						List rankingProductImage=(ArrayList)list.get(5);
						count=0;
					%>
					
					<c:forEach var="newProduct" items="${data[0]}">
						<section class="list">
							<a href="${pageContext.request.contextPath}/front/productdetail?productName=${newProduct.productName}">
								<figure><img src="${pageContext.request.contextPath}/images/<%= newProductImage.get(count) %>" alt="商品名"></figure>
								<h4>${newProduct.productName}《${newProduct.productPrice}円》</h4>
								<p>${newProduct.productDescription}</p>
							</a>
						</section>

						<% if(count < 4){ count++; } %>

					</c:forEach>
				</section>

				<section>
					<h2 class="mb15">SALE</h2>

					<% count=0; %>
					<c:forEach var="saleProduct" items="${data[1]}">
						<section class="list">
							<a href="${pageContext.request.contextPath}/front/productdetail?productName=${saleProduct.productName}">
								<figure><img src="${pageContext.request.contextPath}/images/<%= saleProductImage.get(count) %>" alt="商品名"></figure>
								<h4>${saleProduct.productName}《${saleProduct.productPrice}円》</h4>
								<p>${saleProduct.productDescription}</p>
							</a>
						</section>
 
						<% if(count < 4){ count++; } %>

					</c:forEach>
				</section>

				<section>

					<h2 class="mb15">RANKING</h2>
					
					<% count=0; %>
					<c:forEach var="rankingProduct" items="${data[2]}">
						<section class="list">
							<a href="${pageContext.request.contextPath}/front/productdetail?productName=${rankingProduct.productName}">
								<figure><img src="${pageContext.request.contextPath}/images/<%= rankingProductImage.get(count) %>" alt="商品名"></figure>
								<h4>${rankingProduct.productName}《${rankingProduct.productPrice}円》</h4>
								<p>${rankingProduct.productDescription}</p>
							</a>
						</section>

						<% if(count < 4){ count++; } %>
					</c:forEach>
				</section>

			</div>
			<!--/sub-->

			<p id="pagetop"><a href="#">↑ PAGE TOP</a></p>

		</div>
		<!--/contents-->

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
				<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a>
				<br><br>
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
