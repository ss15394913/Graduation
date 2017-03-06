<!--
式言語で取得できるデータ
 resultData : Map<String, Object> 【式言語で${data}で取り出される部分】
 ┃
 ┗"productCount",Integer 検索条件に該当する商品の数
 ┃
 ┗"pageNumber",Integer 表示するページ番号
 ┃
 ┗"productData" : List<Map>
   ┗productData : Map<String, Object> 商品一件ずつのデータ
     ┃
     ┗"catalog",ProductCatalogBean このBeanの内容通りの、名前などのデータ
     ┗"tagNames",List<String> その商品に付加されているタグの名前のList
     ┗"colors",List<String> その商品の色の画像パスのList
     ┗"isFavorite",Boolean その商品はログイン中の会員のお気に入りであるか
     ┗"categoryName",String その商品のカテゴリ名
-->


<%@page pageEncoding="UTF-8"
   contentType="text/html;charset=UTF-8"
   %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
					<li class="arrow"><a>CATEGORY</a>
						<ul class="ddmenu">
							<li><a href="productlist?category=tops">TOPS</a></li>
							<li><a href="productlist?category=bottoms">BOTTOMS</a></li>
							<li><a href="productlist?category=under">UNDER</a></li>
							<li><a href="productlist?category=shoes">SHOES</a></li>
							<li><a href="productlist?category=accessories">ACCESSORIES</a></li>
							<!--<li><a href="productlist?subCategory=outer">サブカテゴリのリンクテスト：outer</a></li>-->
						</ul>
					</li>
						
					<li class="arrow"><a href="productlist?searchTag=セール">SALE</a></li>
					<li class="arrow"><a href="productlist?sort=purchaseDesc">RANKING</a></li>
					<li class="arrow"><a href="productlist">ALLITEM</a></li>
					<li class="arrow"><a>HELP</a>
						<ul class="ddmenu">
							<li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
							<li><a href="${pageContext.request.contextPath}/front/question">Q&A</a></li>
						</ul>
					</li>
				</ul>
			</nav><br/><br/><br/>
			
			<section id="main">
				
				<h2 class="mb15" style="font-size:25px;">商品一覧</h2>
				
				<div>
					<!--検索フォームの初期値を設定する-->
					<c:if test="${paramValues.sort[0] == 'nameAsc'}">
						<c:set var="nameAsc" value="selected" />
					</c:if>
					<c:if test="${paramValues.sort[0] == 'nameDesc'}">
						<c:set var="nameDesc" value="selected" />
					</c:if>
					<c:if test="${paramValues.sort[1] == 'priceAsc'}">
						<c:set var="priceAsc" value="selected" />
					</c:if>
					<c:if test="${paramValues.sort[1] == 'priceDesc'}">
						<c:set var="priceDesc" value="selected" />
					</c:if>
					<c:if test="${paramValues.sort[2] == 'purchaseAsc'}">
						<c:set var="purchaseAsc" value="selected" />
					</c:if>
					<c:if test="${paramValues.sort[2] == 'purchaseDesc'}">
						<c:set var="purchaseDesc" value="selected" />
					</c:if>
					<c:if test="${param.searchTag=='セール'}">
						<c:set var="saleTag" value="selected" />
					</c:if>
					<c:if test="${param.searchTag=='冬季限定'}">
						<c:set var="winterOnlyTag" value="selected" />
					</c:if>
					
					
					<form action="productlist" method="get">
						<input type="hidden" name="category" value="${param.category}">
						<input type="hidden" name="subCategory" value="${param.subCategory}">
						<input type="hidden" name="pageNumber" value="1">
						<h3>検索</h3>
						名前<input type="text" name="searchText" size="40" value="${param.searchText}">
						タグ<select name="searchTag">
								<option value=""></option>
								<option value="冬季限定" ${pageScope.winterOnlyTag}>冬季限定</option>
								<option value="セール" ${pageScope.saleTag}>セール</option>
							</select><br/>
						並び替え<br/>
						
						名前順
						<select name="sort">
							<option value=""></option>
							<option value="nameAsc" ${pageScope.nameAsc}>五十音順</option>
							<option value="nameDesc" ${pageScope.nameDesc}>五十音の逆順</option>
						</select>
						値段順
						<select name="sort">
							<option value=""></option>
							<option value="priceAsc" ${pageScope.priceAsc}>値段の安い順</option>
							<option value="priceDesc" ${pageScope.priceDesc}>値段の高い順</option>
						</select>
						購入数順
						<select name="sort">
							<option value=""></option>
							<option value="purchaseDesc" ${pageScope.purchaseDesc}>購入数が多い順</option>
							<option value="purchaseAsc" ${pageScope.purchaseAsc}>購入数が少ない順</option>
						</select>
						<input type="submit" value="検索">
					</form>
				</div>
				
				<h3>
					<c:if test="${param.subCategory!=null}">
						${param.subCategory}
					</c:if>
					<c:if test="${param.category!=null}">
						${param.category}
					</c:if>
					<c:if test="${param.searchTag=='セール'}">
						セール中の商品
					</c:if>
					<c:if test="${param.searchTag=='冬季限定'}">
						冬季限定の商品
					</c:if>
					<c:if test="${param.category==null}">
						<c:if test="${param.category==null}">
							<c:if test="${param.searchTag==null}">
								全ての商品
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${param.sort == 'purchaseDesc'}">
						購入数ランキング
					</c:if>
				</h3>
				
				<!-- テスト用パラメータ取得
					選択カテゴリ：${param.category}
					選択サブカテゴリ：${param.subCategory}
					並べ替え：${paramValues.sort[0]} ${paramValues.sort[1]} ${paramValues.sort[2]}
				-->
				
			</section>
			
			<%
				int productCount = 0;
				int cnt = 0;
			%>
			
			<table style="table-layout: fixed;">
				<tr>
					<c:forEach var="product" items="${data.productsData}">
					<%
						productCount += 1;
						pageContext.setAttribute("productCount",productCount);
					%>
					
					<td width="194" height="320">
						<section class="list" style="position:relative; height:100%;">
							<figure>
								<a href ="productdetail?productName=${product.catalog.productName}">
									<img src="${pageContext.request.contextPath}/images/
									${product.catalog.productImagePath}" alt="商品の画像">
									
									
									<!-- 各タグの表示 -->
									<c:forEach var="tagName" items="${product.tagNames}">
										<c:if test="${tagName == '冬季限定'}">
											<!--
											<img class="冬季限定タグ画像のクラス" 
											src="${pageContext.request.contextPath}/images/tag.hoge" alt="冬季限定">
											-->
										</c:if>
										<c:if test="${tagName == 'セール'}">
											<!--
											<img class="セールタグ画像のクラス" 
											src="${pageContext.request.contextPath}/images/tag.hoge" alt="セール">
											-->
										</c:if>
									</c:forEach>
									
									<!-- 売り切れの表示 -->
									<c:if test="${product.catalog.productStockCount == 0}">
										<span class="sumi">SOLD OUT</span>
									</c:if>
									<!-- 売り切れの表示 -->
									<c:if test="${product.isFavorite == false}">
									<div name="favorite">
									<form action="productlist" method="get" onsubmit="return false;">
										<input type="image" src="${pageContext.request.contextPath}/images/nonfavo.png" 
											data-condition=false name="${product.catalog.exampleProductId}" class="favoButton">
									</form>
									<!-- /favorite -->
									</div>
									</c:if>
									
									<c:if test="${product.isFavorite == true}">
									<div name="favorite">
									<form action="productlist" method="get" onsubmit="return false;">
										<input type="image" src="${pageContext.request.contextPath}/images/favo.png" 
											data-condition=true name="${product.catalog.exampleProductId}" class="favoButton">
									</form>
									<!-- /favorite -->
									</div>
									</c:if>
									<%out.print("<script>var arr = document.getElementById(\"memberid\").value;parseInt(arr);if(arr <=0){document.getElementsByName(\"favorite\")[" + cnt + "].innerHTML = \"\";}</script>");cnt ++;%>
									</figure>
									<h4 style="position: absolute">${product.catalog.productName}
									<br/> ￥${product.catalog.productPrice}<br/></h4>
								</a>
						</section>
					</td>
					<c:if test="${pageScope.productCount % 5 == 0}" >
					</tr>
					<tr height="80">
					</tr>
					<tr>
					</c:if>
				</c:forEach>
				</tr>
			</table>
			
			<div align="center">
				<!-- 現在のページが1ページ目でなければ、前のページへ移動するリンクを表示 -->
				<c:if test="${data.pageNumber > 1}" >
					<a href ="productlist?category=${param.category}
					&subCategory=${param.subCategory}&pageNumber=${data.pageNumber-1}
					&sort=${paramValues.sort[0]}&sort=${paramValues.sort[1]}&sort=${paramValues.sort[2]}">
					前のページへ</a>
				</c:if>
				
				
				<!-- 商品数１５毎に１個、ページ移動ボタンを増やす -->
				<%
					int pageCount = 0;
				%>
				<c:forEach items="${data.productCount}" step="15">
						<%
							pageCount += 1;
							pageContext.setAttribute("pageCount",pageCount);
						%>
					<a href ="productlist?category=${param.category}
					&subCategory=${param.subCategory}&pageNumber=${pageScope.pageCount}
					&sort=${paramValues.sort[0]}&sort=${paramValues.sort[1]}&sort=${paramValues.sort[2]}">
					${pageScope.pageCount}</a>
				</c:forEach>
				
				
				<!-- 現在のページが最後のページでなければ、次のページへ移動するリンクを表示 -->
				<c:if test="${data.pageNumber < pageScope.pageCount}" >
					<a href ="productlist?category=${param.category}
					&subCategory=${param.subCategory}&pageNumber=${data.pageNumber+1}
					&sort=${paramValues.sort[0]}&sort=${paramValues.sort[1]}&sort=${paramValues.sort[2]}">
					次のページへ</a>
				</c:if>
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
					<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a><br><br>
				</ul>
			</div>
			<div align="center">
				<small>Copyright&copy; <a href="${pageContext.request.contextPath}/front/top">Sample Online Shop</a>　All Rights Reserved.</small>
				<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>
			</div>
		</footer>
		
		<%out.print("<script>$(\".favoButton\").click(function() {var productId = $(this).attr(\"name\"); var button = this;if($(this).data('condition') == false){$.ajax({url: '");%>${pageContext.request.contextPath}<%out.print("/front/addfavorite?productId='+productId,type: 'GET', dataType: \"text\",}).done(function(data, textStatus, jqXHR) {$(button).attr({src: \"");%>${pageContext.request.contextPath}<%out.print("/images/favo.png\"});$(button).data('condition',true);}).fail(function(data, textStatus, jqXHR){console.log(textStatus);});}else if($(this).data('condition') == true){$.ajax({url: '");%>${pageContext.request.contextPath}<%out.print("/front/removefavorite?productId='+productId,");%>${product.catalog.exampleProductId}<%out.print("type: 'GET',dataType: \"text\",}).done(function(data, textStatus, jqXHR) {$(button).attr({src: \"");%>${pageContext.request.contextPath}<%out.print("/images/nonfavo.png\"});$(button).data('condition',false);}).fail(function(data) {console.log(\"error\");});}});</script>");%>
		
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
