<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>マイページ</title>
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

<body>

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
                    </ul>
                </li>
            </ul>
        </nav>

        <div id="contents">


            <div id="main">

                <section>

                    <h1>
                        <img src="${pageContext.request.contextPath}/images/icon.jpg" align="middle" width="50" height="50">
                        プロフィール
                    </h1>

                    <section>
                        <table class="ta1">
                            <tr>
                                <th>お名前</th>
                                <td>河野洋輝</td>
                            </tr>
                            <tr>
                                <th>メールアドレス</th>
                                <td>baketsu.gmail.com</td>
                            </tr>
                            <tr>
                                <th>生年月日</th>
                                <td>1996年12月28日</td>
                            </tr>
                            <tr>
                                <th>住所</th>
                                <td>東京都江東区南砂7-2-6-302</td>
                            </tr>
                            <tr>
                                <th>電話番号</th>
                                <td>080-2269-1826</td>
                            </tr>
                        </table>

                    </section>

                    <hr>

                    <h1>
                        <img src="${pageContext.request.contextPath}/images/icon.jpg" align="middle" width="50" height="50">
                        お気に入り一覧
                    </h1>
                    <br>
                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="images/outer8.png" alt="商品名"></figure>
                            <h4>皮ジャケット　　　 \6,500</h4>
                        </a>
                    </section>
                    <br><br>
                    <br><br><br><br><br><br><br>
                    <hr>

                    <h1>
                        <img src="${pageContext.request.contextPath}/images/icon.jpg" align="middle" width="50" height="50">
                        会員限定セール
                    </h1>
                    <br>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/boxer2.jpg" alt="商品名"></figure>
                            <h4>ボクサーパンツ<br> \1,000</h4>
                            <span class="osusume">SALE</span>
                        </a>
                    </section>

            </div>

            </section>


        </div>
        <!--/main-->

        <div id="sub">

            <nav class="box1">
                <h2>MENU</h2>
                <ul class="submenu mb10">
                    <li><a href="${pageContext.request.contextPath}/front/top">TOP</a></li>
                    <li><a href="${pageContext.request.contextPath}/front/userconfig">アカウント設定</a></li>
                    <li><a href="${pageContext.request.contextPath}/front/orderhistory">購入履歴</a></li>
                    <li><a href="${pageContext.request.contextPath}/front/leave">退会手続き</a></li>
                </ul>
            </nav>


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
    <!--スマホ用メニューバー-->
    <img src="${pageContext.request.contextPath}/images/icon_bar.png" width="20" height="23" alt="" id="menubar_hdr" class="close">
    <script type="text/javascript">
 		if (OCwindowWidth() < 480) {
			open_close("menubar_hdr", "menubar");
		}
    </script>

</body>
</html>
