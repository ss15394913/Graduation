<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>注文確認</title>
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
			#image{
				width:120px;
				height:120px;
			}
		</style>
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
				<div id="main">
				
					<h3>ご注文された商品</h3>
					<c:forEach var="product" items="${sessionScope.cart}">
						<p>
							<a href="${pageContext.request.contextPath}/front/productdetail">
								<img id="image" src="${pageContext.request.contextPath}/images/${product.productImagePath}" align="left">
								商品名/${product.productName}<br>
								サイズ/${product.productSize}<br>
								注文数/${product.count}<br>
								<font size="3"><em>&yen;${product.productPrice}(税込)</em></font>
							</a>
						</p>
					</c:forEach>
					
					<h3>お届け先のお客様の情報</h3>
					名前：${data.firstname}&nbsp;${data.name}<br>
					ナマエ：${data.kanafirstname}&nbsp;${data.kananame}<br><br>
					
					<h3>お届け先住所</h3>
					〒郵便番号：${data.zipcode}<br>
					住所：${data.prefectures}&nbsp;${data.city}&nbsp;${data.blocknumber}&nbsp;${data.bildingname}<br><br>
					
					<h3>配達予定</h3>
					予定日：${data.delivery_request_day}<br>
					予定時間：${data.delivery_request_time}<br><br>
					
					<h3>お支払い方法</h3>
					${data.payment_information}<br><br><br>
					
				</div>
				<!--/main-->
				
				<table class="ta1">
					<tr>
						<th>注文合計</th>
						<td>${data.orderprice}</td>
					</tr>
					<tr>
						<th>手数料</th>
						<td>${data.comission}</td>
					</tr>
					<tr>
						<th>合計</th>
						<td>${data.totalprice}</td>
					</tr>
				</table>
			</div>
			<!--/contents-->
			<div align="center">
				<a href="${pageContext.request.contextPath}/front/ordercomp">
					<img src="${pageContext.request.contextPath}/images/buy.png" width="240" height="80" alt="New Menber Resist"></a>
				<a href="javascript:history.back();">
					<img src="${pageContext.request.contextPath}/images/notyet.png" width="240" height="80" alt="New Menber Resist"></a>
			</div>
		</div>
		<!--/container-->
		
		<p id="pagetop"><a href="#">↑ PAGE TOP</a></p>
		
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
