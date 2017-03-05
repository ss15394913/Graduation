<%@page pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>お問い合わせ</title>
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

	<body class="c1 s-n">
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


				<section>

					<h2>お問い合わせ</h2>
					<p>当社へのお問い合わせはこちらまでお願い致します。</p>
					
					<form action="${pageContext.request.contextPath}/front/contactcomp" method="post">
						<table class="ta1 mb1em">
							<tr>
								<th colspan="2" class="tamidashi"><font color="red">※</font>マークは入力必須です</th>
							</tr>
	                        
							<tr>
								<th>お名前<font color="red">※</font></th>
								<td><input type="text" name="お名前" size="30" class="ws" required></td>
							</tr>
	                        
							<tr>
								<th>メールアドレス<font color="red">※</font></th>
								<td><input type="text" name="メールアドレス" size="30" class="ws" required></td>
							</tr>
	                       
							<tr>
								<th>ご住所(都道府県)</th>
								<td>
									<select name="ご住所(都道府県)">
									<option value="" selected="selected">都道府県選択</option>
										<option value="北海道">北海道</option>
										<option value="青森県">青森県</option>
										<option value="岩手県">岩手県</option>
										<option value="宮城県">宮城県</option>
										<option value="秋田県">秋田県</option>
										<option value="山形県">山形県</option>
										<option value="福島県">福島県</option>
										<option value="茨城県">茨城県</option>
										<option value="栃木県">栃木県</option>
										<option value="群馬県">群馬県</option>
										<option value="埼玉県">埼玉県</option>
										<option value="千葉県">千葉県</option>
										<option value="東京都">東京都</option>
										<option value="神奈川県">神奈川県</option>
										<option value="新潟県">新潟県</option>
										<option value="富山県">富山県</option>
										<option value="石川県">石川県</option>
										<option value="福井県">福井県</option>
										<option value="山梨県">山梨県</option>
										<option value="長野県">長野県</option>
										<option value="岐阜県">岐阜県</option>
										<option value="静岡県">静岡県</option>
										<option value="愛知県">愛知県</option>
										<option value="三重県">三重県</option>
										<option value="滋賀県">滋賀県</option>
										<option value="京都府">京都府</option>
										<option value="大阪府">大阪府</option>
										<option value="兵庫県">兵庫県</option>
										<option value="奈良県">奈良県</option>
										<option value="和歌山県">和歌山県</option>
										<option value="鳥取県">鳥取県</option>
										<option value="島根県">島根県</option>
										<option value="岡山県">岡山県</option>
										<option value="広島県">広島県</option>
										<option value="山口県">山口県</option>
										<option value="徳島県">徳島県</option>
										<option value="香川県">香川県</option>
										<option value="愛媛県">愛媛県</option>
										<option value="高知県">高知県</option>
										<option value="福岡県">福岡県</option>
										<option value="佐賀県">佐賀県</option>
										<option value="長崎県">長崎県</option>
										<option value="熊本県">熊本県</option>
										<option value="大分県">大分県</option>
										<option value="宮崎県">宮崎県</option>
										<option value="鹿児島県">鹿児島県</option>
										<option value="沖縄県">沖縄県</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<th>ご住所(市区町村以下)</th>
								<td><input type="text" name="ご住所(市区町村以下)" size="30" class="wl"></td>
							</tr>
	                        
							<tr>
								<th>お問い合わせ項目<font color="red">※</font></th>
								<td>
									<label><input type="checkbox" name="お問い合わせ項目" value="お問い合わせ項目１">商品についてのご質問</label><br>
									<label><input type="checkbox" name="お問い合わせ項目" value="お問い合わせ項目２">返品・交換について</label><br>
									<label><input type="checkbox" name="お問い合わせ項目" value="お問い合わせ項目３">サイトの不具合について</label><br>
									<label><input type="checkbox" name="お問い合わせ項目" value="お問い合わせ項目４">当社へのご意見</label><br>
									<label><input type="checkbox" name="お問い合わせ項目" value="お問い合わせ項目５">その他</label><br>
							</tr>

							<tr>
								<th>お問い合わせ詳細<font color="red">※</font></th>
								<td><textarea name="お問い合わせ詳細" cols="30" rows="10" class="wl" required></textarea></td>
							</tr>
						</table>
						
						<p class="c">
							<input type="submit" value="送信">
						</p>
					</form>

				</section>

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
				<a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a>
				<br><br>
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
