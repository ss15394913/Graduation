<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>


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

            <aside id="mainimg">
                <img class="slide_file" src="${pageContext.request.contextPath}/images/1.jpg" title="front/productlist" alt="">
                <img class="slide_file" src="${pageContext.request.contextPath}/images/2.jpg" title="front/productlist" alt="">
                <input type="hidden" id="slide_loop" value="0">
                <a href="front/productlist" id="slide_link">
                    <img id="slide_image" src="${pageContext.request.contextPath}/images/1.jpg" alt="">
                    <img id="slide_image2" src="${pageContext.request.contextPath}/images/2.jpg" alt="">
                </a>
            </aside>

            <div id="main">

                <section>

                    <h2 class="mb15">NEW ARRIVALS</h2>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>説明文は短めに入力して下さい。沢山詰め込むと表示が途中で切れます。</p>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                            <span class="osusume">PICKUP</span>
                        </a>
                    </section>

                    <section class="list">
                        <a href="front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                            <span class="sumi">SOLD OUT</span>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                        </a>
                    </section>

                </section>

                <section>

                    <h2 class="mb15">SALE</h2>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>説明文は短めに入力して下さい。沢山詰め込むと表示が途中で切れます。</p>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                            <span class="osusume">PICKUP</span>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                            <span class="sumi">SOLD OUT</span>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                        </a>
                    </section>


                </section>

                <section>

                    <h2 class="mb15">RANKING</h2>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>説明文は短めに入力して下さい。沢山詰め込むと表示が途中で切れます。</p>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                            <span class="osusume">PICKUP</span>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                            <span class="sumi">SOLD OUT</span>
                        </a>
                    </section>

                    <section class="list">
                        <a href="${pageContext.request.contextPath}/front/productdetail">
                            <figure><img src="${pageContext.request.contextPath}/images/sample1.jpg" alt="商品名"></figure>
                            <h4>商品名《XXX円》</h4>
                            <p>商品の簡単な説明をここに入れます。</p>
                        </a>
                    </section>


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

    </footer>

    <!--スライドショースクリプト-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/slide_simple_pack.js"></script>

    <!--スマホ用更新情報-->
    <script type="text/javascript">
		if (OCwindowWidth() < 480) {
		open_close("newinfo_hdr", "newinfo");
		}
    </script>

</body>
</html>
