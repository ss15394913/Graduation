<!--
式言語で取得できるデータ
	resultData : Map<String, Object> 【jspで${data}で取り出される部分】
	┃
	┗"productInformation",List<ProductInformationBean> 商品詳細一件ずつのデータ
	┗"CategoryName",String 表示する商品のカテゴリ名
	┗"isSaleProduct",Boolean 商品がセール中であるか
	┗"productColors",List<String> 表示する商品に存在する色
	┗"productSizes",List<String> 表示する商品に存在するサイズ
	┗"productStockCounts",Map<String,Integer> 表示する商品の在庫数 javascriptへの受け渡しに使う
	┃┗(色,サイズ),Integer					キーは色とサイズの文字列を組み合わせて生成する
	┃
	┗"productsId",Map<String,String>		表示する商品のId javascriptへの受け渡しに使う
	┃┗(色,サイズ),String					キーは色とサイズの文字列を組み合わせて生成する
	┃
	┗"productImageData",List<Map>
	┗productImageData : Map<String,String> 該当する商品の画像と、それに附属する説明などのデータ
	┃
	┗"imagePath",String 商品画像のパス
	┗"description",String 商品の説明
-->

<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>商品詳細</title>
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
					<article>
						<h2>${data.productInformation[0].productName}</h2>
						<figure id="item-image">
							<img src="${pageContext.request.contextPath}/images/${data.productImageData[0].imagePath}" 
								alt="写真の説明を入れます" id="item_image1" align="left" width="550">
							<img src="${pageContext.request.contextPath}/images/${data.productImageData[0].imagePath}" 
								alt="写真の説明を入れます" id="item_image2" align="left" width="550">
							<p><font size="5"><b id="imgcaption">${data.productInformation[0].productName}</b></font></p>
							<p>
								<font size="3">
									<em>
										￥${data.productInformation[0].productPrice}(税込)
										<c:if test="${data.isSaleProduct}">
											→<font color="red" size="4">￥<fmt:formatNumber 
												value="${data.productInformation[0].productPrice*0.7}" 
												maxFractionDigits="0" minFractionDigits="0"
												groupingUsed="false" />
											(税込)　30%off
										</c:if>
									</em>
								</font>
							</p>
							
							<h1>color</h1><hr>
							<SELECT name="color" id="color">
								<c:forEach var="color" items="${data.productColors}">
									<OPTION value="${color}">${color}</OPTION>
								</c:forEach>
							</SELECT>
							
							<h1>size</h1><hr>
							<SELECT name="size" id="size">
								<c:forEach var="size" items="${data.productSizes}">
									<OPTION value="${size}">${size}</OPTION>
								</c:forEach>
							</SELECT>
							
							<h1>購入数</h1><hr>
							<!--testStockというパラメータを渡すと、在庫数が実際よりそのパラメータの数だけ
								多いかのように購入数を選択することができる。 -->
							<input type="number" id="itemCount" name="itemCount" min="1" max="999" value="1" style="width: 40px;">
							<span id="soldout"></span>
						</figure>
						
						<!--商品在庫をjstlで受け取り、javascriptに渡すためのタグ。（表示はされない）-->
						<c:forEach items="${data.productStockCounts}" var="entry">
							<div style="display:none" id="stock,${entry.key}">${entry.value+param.testStock}</div>
						</c:forEach>
						
						<!--商品IDをjstlで受け取り、javascriptに渡すためのタグ。（表示はされない） -->
						<c:forEach items="${data.productsId}" var="entry">
							<div style="display:none" id="id,${entry.key}">${entry.value}</div>
						</c:forEach>
						
						<!--商品画像のサムネイル。クリックすると拡大画像を表示する-->
						<p>
							<c:forEach var="imageData" items="${data.productImageData}">
								<img src="${pageContext.request.contextPath}/images/${imageData.imagePath}" 
									alt="${data.productInformation[0].productName}" class="thumbnail">
							</c:forEach>
						</p>
						
						
						<!--
						<h3>イメージチェンジプログラム（imgchg_pack.js）の使い方</h3>
						<p>サムネイル画像をクリックすると、上の大きな写真が入れ替わります。</p>
						<p>html側を見れば分かりますが、大きな画像の読みこみ行は<strong class="color1">２行</strong>あります。
							違う点はidの指定名が異なるだけですが必ず２行入れて下さい。</p>
						<p>サムネイルを増やしたい場合はhtml側のサムネイルの行をコピペで増やし、
							画像ファイル名やalt指定（大きな写真下に表示される説明文になります）を入れ替えて下さい。</p>
						<p>サムネイルの縦横比率は統一しておいた方がきれいに入れ替わります。※ここではあえて別々なサイズを配置しています。<br>
						また、サムネイルと拡大画像は兼用なので、大きな写真を準備しておいて下さい。
							サムネイルのサイズはcssフォルダのstyle.cssの「.thumbnail」のwidthとheightの値で変更できます。</p>
						-->
					</article>
					
					<a id="cartIn">
						<img src="${pageContext.request.contextPath}/images/cartin.png" width="240" height="80" alt="Cart in">
					</a>
					
					<p><a href="javascript:history.back()">&lt;&lt; 前のページに戻る</a></p>
					
				</div>
				<!--/main-->
				
				<div id="sub">
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
					<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a><br><br>
				</ul>
			</div>
		</footer>
		
		<!-- イメージチェンジ設定 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/imgchg_pack.js"></script>
		<script type="text/javascript">
			imgchg_start('item_image1', 'item_image2', 'thumbnail', 'imgcaption', 0);
		</script>
		
		<!--スマホ用メニューバー-->
		<img src="${pageContext.request.contextPath}/images/icon_bar.png" width="20" height="23" alt="" id="menubar_hdr" class="close">
		<script type="text/javascript">
			if (OCwindowWidth() < 480) {
				open_close("menubar_hdr", "menubar");
			}
		</script>
		
		
		<!-- 色やサイズが選択される度に、購入個数を1に戻し、最大値を変更する-->
		<script type="text/javascript">
			function changeItemCount(){
				var itemCountElm = document.getElementById("itemCount");
				var stockId = "stock," + document.getElementById("color").value
				 + "," + document.getElementById("size").value;
				var soldoutElm = document.getElementById("soldout");
				
				if(parseInt(document.getElementById(stockId).textContent) >= 1){
					/*取得した値が1以上の場合の処理*/
					itemCountElm.max = document.getElementById(stockId).textContent;
					itemCountElm.value = 1;
					itemCountElm.min = 1;
					itemCountElm.disabled = false;
					soldoutElm.innerHTML = "";
				}else{
					/*取得した値が0以下（売り切れ）の場合の処理*/
					itemCountElm.min = 0;
					itemCountElm.value = 0;
					itemCountElm.max = 0;
					itemCountElm.disabled = true;
					soldoutElm.innerHTML = "選択した色とサイズの在庫がありません。";
				}
			}
			changeItemCount();
			document.getElementById("color").addEventListener("change",changeItemCount);
			document.getElementById("size").addEventListener("change",changeItemCount);
		</script>
		
		<!---->
		<script type="text/javascript">
			document.getElementById("cartIn").addEventListener("click",function(){
				if(document.getElementById("itemCount").value >= 1){
					var itemCount = document.getElementById("itemCount").value;
					var productIdElmId = "id," + document.getElementById("color").value
						+ "," + document.getElementById("size").value;
					var productId = document.getElementById(productIdElmId).innerHTML;
					window.location.href = "${pageContext.request.contextPath}/front/addcart"
						+ "?productid=" + productId
						+ "&itemcount=" + itemCount;
				}
			});
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
