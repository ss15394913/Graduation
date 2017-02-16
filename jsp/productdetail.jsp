<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

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

                <article>

                    <h2>フライトジャケット</h2>

                    <figure id="item-image">
                        <img src="${pageContext.request.contextPath}/images/outer1.png" alt="写真の説明を入れます" id="item_image1" align="left">
                        <img src="${pageContext.request.contextPath}/images/outer1.png" alt="写真の説明を入れます" id="item_image2" align="left">
                        <p id="imgcaption"> <font size="5"><b>フライトジャケット</b></font></p>

                        <p><font size="3"><em>\10,000(税込)→<font color="red" size="4">\7,000(税込)　30%off</em></font></p>
                        <h1>color</h1>
                        <hr>
                        <SELECT name="color">
                            <OPTION value="color1">dark brown</OPTION>
                        </SELECT>

                        <h1>size</h1>
                        <hr>
                        <SELECT name="size">
                            <OPTION value="s">S</OPTION>
                            <OPTION value="m">M</OPTION>
                        </SELECT>
                    </figure>

                    <p>
                        <img src="${pageContext.request.contextPath}/images/outer1.png" alt="詳細画像１の説明文をここに入れます" class="thumbnail">
                        <!--<img src="images/sample2.jpg" alt="詳細画像２の説明文をここに入れます" class="thumbnail">
                        <img src="images/sample3.jpg" alt="詳細画像３の説明文をここに入れます" class="thumbnail">
                        <img src="images/sample4.jpg" alt="詳細画像４の説明文をここに入れます" class="thumbnail">
                        <img src="images/sample5.jpg" alt="詳細画像５の説明文をここに入れます" class="thumbnail">
                        <img src="images/sample6.jpg" alt="詳細画像６の説明文をここに入れます" class="thumbnail">
                        </p>

                        <h3>イメージチェンジプログラム（imgchg_pack.js）の使い方</h3>
                        <p>サムネイル画像をクリックすると、上の大きな写真が入れ替わります。</p>
                        <p>html側を見れば分かりますが、大きな画像の読みこみ行は<strong class="color1">２行</strong>あります。違う点はidの指定名が異なるだけですが必ず２行入れて下さい。</p>
                        <p>サムネイルを増やしたい場合はhtml側のサムネイルの行をコピペで増やし、画像ファイル名やalt指定（大きな写真下に表示される説明文になります）を入れ替えて下さい。</p>
                        <p>サムネイルの縦横比率は統一しておいた方がきれいに入れ替わります。※ここではあえて別々なサイズを配置しています。<br>
                        また、サムネイルと拡大画像は兼用なので、大きな写真を準備しておいて下さい。サムネイルのサイズはcssフォルダのstyle.cssの「.thumbnail」のwidthとheightの値で変更できます。</p>
                        -->
                </article>

                <a href="${pageContext.request.contextPath}/front/cartaddcomp"><img src="${pageContext.request.contextPath}/images/cartin.png" width="240" height="80" alt="Cart in"></a>

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
                <a href="${pageContext.request.contextPath}/front/question">　　　Q&A</a>
                <br>
                <br>
            </ul>

    </footer>

    <!-- イメージチェンジ設定 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/imgchg_pack.js"></script>
    <script type="text/javascript">
imgchg_start('item_image1', 'item_image2', 'thumbnail', 'imgcaption', 0);
    </script>

    <!--スマホ用メニューバー-->
    <img src="images/icon_bar.png" width="20" height="23" alt="" id="menubar_hdr" class="close">
    <script type="text/javascript">
		if (OCwindowWidth() < 480) {
			open_close("menubar_hdr", "menubar");
		}
    </script>

</body>
</html>
