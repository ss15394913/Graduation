<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>商品一覧</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

    <div id="container">

        <header>
            <h1 id="logo"><a href="${pageContext.request.contextPath}/front/top"><img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
            <div class="headermenu">
                <ul>
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
                        <li><a href="${pageContext.request.contextPath}/front/productlist">TOPS</a></li>
                        <li><a href="${pageContext.request.contextPath}/front/productlist">BOTTOMS</a></li>
                        <li><a href="${pageContext.request.contextPath}/front/productlist">UNDER</a></li>
                        <li><a href="${pageContext.request.contextPath}/front/productlist">SHOES</a></li>
                        <li><a href="${pageContext.request.contextPath}/front/productlist">ACCESSORIES</a></li>
                    </ul>
                </li>
                <li class="arrow">
                    <a href="${pageContext.request.contextPath}/front/productlist">SALE</a>
                </li>
                <li class="arrow">
                    <a href="${pageContext.request.contextPath}/front/productlist">RANKING</a>
                </li>
                <li class="arrow">
                    <a href="${pageContext.request.contextPath}/front/productlist">ALLITEM</a>
                </li>
                <li class="arrow">
                    <a>HELP</a>
                    <ul class="ddmenu">
                        <li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
                        <li><a href="${pageContext.request.contextPath}/front/question">Q&A</a></li>
                </li>
            </ul>
        </nav>

        <div id="contents">

            <div id="main">

                <section>

                    <h2 class="type1">商品一覧</h2>

                    <h3>TOPS</h3>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer1.png" alt="商品名"></figure>
                            <h4>フライトジャケット \3,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer2.png" alt="商品名"></figure>
                            <h4>フィールドジャケット \3,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer3.png" alt="商品名"></figure>
                            <h4>サックジャケット　 \4,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer4.png" alt="商品名"></figure>
                            <h4>ランチコート　　　 \4,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer5.png" alt="商品名"></figure>
                            <h4>ノーフォークジャケット \5,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer6.png" alt="商品名"></figure>
                            <h4>デッキジャケット 　　\5,500</h4>
                        </a>
                    </section>

                    <br>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer7.png" alt="商品名"></figure>
                            <h4>皮ジャケット 　　　\6,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer8.png" alt="商品名"></figure>
                            <h4>皮ジャケット　　　 \6,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer9.png" alt="商品名"></figure>
                            <h4>ノーフォークジャケット　　 \7,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer10.png" alt="商品名"></figure>
                            <h4>ダウンジャケット　　\7,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer11.png" alt="商品名"></figure>
                            <h4>リーファーコート　　\8,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer12.png" alt="商品名"></figure>
                            <h4>バルマカーン　　　\8,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer13.png" alt="商品名"></figure>
                            <h4>フード付きジャンバー \9,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer14.png" alt="商品名"></figure>
                            <h4>フード付きジャンバー 　　\9,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer15.png" alt="商品名"></figure>
                            <h4>フード付きジャンバー \10,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer16.png" alt="商品名"></figure>
                            <h4>ウインドブレカー　　\3,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer17.png" alt="商品名"></figure>
                            <h4>ダウンジャケット　　\3,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer18.png" alt="商品名"></figure>
                            <h4>ダウンジャケット　　\4,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/item">
                            <figure><img src="${pageContext.request.contextPath}/images/outer19.png" alt="商品名"></figure>
                            <h4>デッキジャケット　　\4,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer20.png" alt="商品名"></figure>
                            <h4>チェスターコート　\5,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer21.png" alt="商品名"></figure>
                            <h4>モーズコート　　　\5,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer22.png" alt="商品名"></figure>
                            <h4>サックジャケット　　\6,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer23.png" alt="商品名"></figure>
                            <h4>カバーオール　　　\6,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer24.png" alt="商品名"></figure>
                            <h4>カバーオール　　　\7,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer25.png" alt="商品名"></figure>
                            <h4>皮ジャケット　　　\7,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer26.png" alt="商品名"></figure>
                            <h4>スタンダードコート　\8.000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer27.png" alt="商品名"></figure>
                            <h4>皮ジャケット　　　\8,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer28.png" alt="商品名"></figure>
                            <h4>ノーフォークジャケット \9,000</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer29.png" alt="商品名"></figure>
                            <h4>ダウンジャケット　\9,500</h4>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/outer30.png" alt="商品名"></figure>
                            <h4>皮ジャケット　　　\10,000</h4>
                        </a>
                    </section>

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
                <br>
                <br>
            </ul>
    </footer>

    <!--スライドショースクリプト-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/slide_simple_pack.js"></script>

    <!--スマホ用更新情報-->
    <script type="text/<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>


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
<script type="text/javascript" src="${pageContext.request.contextPath}/ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="${pageContext.request.contextPath}/front/top"><img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="${pageContext.request.contextPath}/front/userentry">会員登録</a>
<a href="${pageContext.request.contextPath}/front/login">ログイン</a>
</ul>
<div id="cart">
	<a href="${pageContext.request.contextPath}/front/cart">CART</a>
</div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}/front/productlist">TOPS</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">BOTTOMS</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">UNDER</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">SHOES</a></li>
    <li><a href="${pageContext.request.contextPath}/front/productlist">ACCESSORIES</a></li>
	</ul>
</li>
<li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">SALE</a>
</li>
<li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">RANKING</a>
</li>
<li class="arrow"><a href="${pageContext.request.contextPath}/front/productlist">ALLITEM</a>
</li>
<li class="arrow"><a>HELP</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}/front/contact">お問い合わせ</a></li>
    <li><a href="${pageContext.request.contextPath}/front/question">Q&A</a></li>
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
<br>
<br>
</ul>

</footer>javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
    </script>

</body>
</html>
