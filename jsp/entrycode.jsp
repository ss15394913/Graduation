<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>

<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>コード入力</title>
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
            <h1 id="logo"><a href="${pageContext.request.contextPath}/top"><img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
            <div class="headermenu">
                <ul>
                    <a href="${pageContext.request.contextPath}/userentry">会員登録</a>
                    <a href="${pageContext.request.contextPath}/login">ログイン</a>
                </ul>
                <div id="cart"><a href="${pageContext.request.contextPath}/front/cart">CART</a></div>
        </header>

        <nav id="menubar">
            <ul>
                <li class="arrow">
                    <a>CATEGORY</a>
                    <ul class="ddmenu">
                        <li><a href="${pageContext.request.contextPath}/product/list">TOPS</a></li>
                        <li><a href="${pageContext.request.contextPath}/product/list2">BOTTOMS</a></li>
                        <li><a href="${pageContext.request.contextPath}/product/list3">UNDER</a></li>
                        <li><a href="${pageContext.request.contextPath}/product/list4">SHOES</a></li>
                        <li><a href="${pageContext.request.contextPath}/product/list5">ACCESSORIES</a></li>
                    </ul>
                </li>
                <li class="arrow">
                    <a href="${pageContext.request.contextPath}/productlist">SALE</a>
                </li>
                <li class="arrow">
                    <a href="${pageContext.request.contextPath}/productlist">RANKING</a>
                </li>
                <li class="arrow">
                    <a href="${pageContext.request.contextPath}/productlist">ALLITEM</a>
                </li>
                <li class="arrow">
                    <a>HELP</a>
                    <ul class="ddmenu">
                        <li><a href="${pageContext.request.contextPath}/contact">お問い合わせ</a></li>
                        <li><a href="${pageContext.request.contextPath}/question">Q&A</a></li>
                </li>
            </ul>
        </nav>

    </div>
    <!--/contents-->
    </div>
    <!--/container-->


    <br><br><br>


    <center>
        <FONT color="green" size="3">本登録を完了するにはメールで送られるコードを入力してください　</FONT>
        <br>
        <input type="text" name="code" /><br>
        <br><br>

        <input id="submitButton" type="submit" value="送信">

        <br><br><br><br><br><br><br><br><br><br>


        <footer>

            <div class="footermenu">
                <ul>
                    <a href="${pageContext.request.contextPath}/companyinfo">会社概要　　　</a>
                    <a href="${pageContext.request.contextPath}/tos">　　　利用規約</a>
                    <a href="${pageContext.request.contextPath}/sitemap">　　　サイトマップ</a>
                    <a href="${pageContext.request.contextPath}/privacypolicy">　　　個人情報保護方針</a>
                    <a href="${pageContext.request.contextPath}/deal">　　　特定商取引法</a>
                    <a href="${pageContext.request.contextPath}/contact">　　　お問い合わせ</a>
                    <a href="${pageContext.request.contextPath}/question">　　　Q&A</a>
                    <br>
                    <br>
                </ul>

                <center>
                    <small>Copyright&copy; <a href="top.html">Sample Online Shop</a>　All Rights Reserved.</small>
                    <span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>



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