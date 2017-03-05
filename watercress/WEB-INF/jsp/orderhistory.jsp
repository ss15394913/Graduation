<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"
	import="java.util.List"
	import="java.util.ArrayList"
	import="java.util.Iterator"
	import="java.util.Map"
	import="java.util.HashMap"
	import="java.util.Iterator"
	import="java.util.Set"
	import="java.util.HashSet"
	import="bean.ProductBean"
	import="bean.ProductImageBean"
	import="bean.PurchaseHistoryBean"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<div id="cart"><a href="#">CART</a></div>
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
				<h2 class="type1">注文履歴</h2><br>
				
				<!--<input type="hidden" name="pageNum" value="1">-->
				
				
				<%
					int sumPrice = 0;
					Map<String,Object> data = (HashMap<String,Object>)request.getAttribute("data");

					List<String> keyList = new ArrayList<String>();
					for (Map.Entry<String,Object> entry : data.entrySet()) {
						keyList.add(entry.getKey()); 
					}
					
					List<List> products = new ArrayList<List>();
					for(int i=0;i<keyList.size();i++){
						products.add(((ArrayList)data.get(keyList.get(i))));
					}

					int count = 0;
					
					Iterator keiesIterator =keyList.iterator();
					while(keiesIterator.hasNext()){
						String key = (String)keiesIterator.next();
						
						out.print("<h3>"+key+"</h3>");
						out.println("<div style=\"width:980px; height:250px; overflow-x:auto;\">");
						Iterator productsIterator = (products.get(count)).iterator();
						while(productsIterator.hasNext()){
						
							List list = (ArrayList)productsIterator.next();
							
							
							out.println("<section class=\"list\">");
							
							out.println("<a href=\"");
				%>
				${pageContext.request.contextPath}
				<%
							out.print("/front/productdetail\">");
							
							out.print("<figure><img src=\"");
				%>
				${pageContext.request.contextPath}
				<%
							out.print("/images/"
							 + ((ProductImageBean)list.get(2)).getProductImagePath() +
							"\"></figure>");
							
							out.print("<h4>"+((ProductBean)list.get(1)).getProductName()+"<br>￥"+((ProductBean)list.get(1)).getProductPrice()+"</h4>");
							
							out.println("</a>");
							
							out.println("</section>");
							
							sumPrice += ((ProductBean)list.get(1)).getProductPrice();
							
						}
						out.println("</div>");
						out.print( "<table class=\"ta1\"><tr><th>合計金額</th><td>￥"
						+ sumPrice +
						"</td></tr></table>" );
						sumPrice = 0;
						count++;
					} 
					
				%>
				</div>
				<!--/main-->
				
				<div id="sub"></div>
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
					<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a><br><br>
				</ul>
			</div>
			
			<div align="center">
				<small>Copyright&copy; <a href="top.html">Sample Online Shop</a>　All Rights Reserved.</small>
				<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>
			</div>
		</footer>
		
		<!--スライドショースクリプト-->
		<script type="text/javascript" src="js/slide_simple_pack.js"></script>
		
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
