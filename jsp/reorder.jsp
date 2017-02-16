<%@page pageEncoding="UTF-8"
 contentType="text/html;charset=UTF-8"%>


<!doctype html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>お支払い情報</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="copyright" content="Template Party">
    <meta name="description" content="ここにサイト説明を入れます">
    <meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
    <link rel="stylesheet" href="css/style.css">
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

        <html>
        <head>
            <meta charset="UTF-8">
            <title>お支払い情報入力</title>

            <script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
            <script src="${pageContext.request.contextPath}/inputDestruction.js" charset="UTF-8"></script>
            <script src="${pageContext.request.contextPath}/payinput.js" charset="UTF-8"></script>

            <style>
                #card_0 {
                    width: 120px;
                }

                #card_1 {
                    width: 35px;
                }

                #card_2 {
                    width: 18px;
                }

                #card_3 {
                    width: 18px;
                }

                .name {
                    width: 120px;
                }

                .req {
                    color: red;
                }
            </style>

        </head>
        <body>

            <br><br><br><br>
            <form class="h-adr" action="" method="post">
                <h3>お届け先住所</h3>

                性<input class="name" type="text" name="firstname" required><p class="req">※必須</p><nobr>

                    名<input class="name" type="text" name="lastname" required><p class="req">※必須</p><nobr>
                        &nbsp;&nbsp;例：山田&nbsp;太郎
                        <br><br>
                        セイ<input class="name" type="text" name="kanafirstname" required pattern="^[?@-??]+$"><p class="req">※必須</p><nobr>
                            メイ<input class="name" type="text" name="kanalastname" required pattern="^[?@-??]+$"><p class="req">※必須</p><nobr>
                                &nbsp;&nbsp;例：ヤマダ&nbsp;タロウ
                                <br><br>
                                <span class="p-country-name" style="display:none;">Japan</span>

                                <!--チェックボックスで住所を変更あるかないか-->
                                <input type="checkbox" id="change" name="del_add_change" value="notchange" onclick="changeRequiredAddressInfo();">届け先住所を変更する<br>

                                〒郵便番号<input type="text" id="address_0" class="p-postal-code" size="8" maxlength="8" autocomplete="postal-code">&nbsp;&nbsp;例：1648787<br><br>

                                都道府県　<input type="text" id="address_1" class="p-region" autocomplete="address-level1" readonly />&nbsp;&nbsp;例：東京都<br>
                                市区町村　<input type="text" id="address_2" class="p-locality" autocomplete="address-level2" />&nbsp;&nbsp;中野区<br>
                                番地　　　　<input type="text" id="address_3" class="p-street-address" autocomplete="address-line1" />&nbsp;&nbsp;東中野4-2-3<br>
                                建物名　　 <input type="text" id="address_4" class="p-extended-address" autocomplete="address-line2" />&nbsp;&nbsp;専門学校 東京テクニカルカレッジ<br><br>

                                電話番号<input type="text" name="phone_number" required><p class="req">※必須</p><nobr>
                                    半角数字のみ。ハイフン(-)は入れない。<nobr>
                                        例：09012345678<br>

                                        <br><br>
                                        <h3>配達時間指定</h3>
                                        配達希望日&nbsp;<p class="req">※必須</p><nobr>
                                            {
                                            3営業日後<input type="radio" name="delivery_request_day" value="3" required>
                                            4営業日後<input type="radio" name="delivery_request_day" value="4">
                                            5営業日後<input type="radio" name="delivery_request_day" value="5">
                                            6営業日後<input type="radio" name="delivery_request_day" value="6">
                                            7営業日後<input type="radio" name="delivery_request_day" value="7">
                                            <br>
                                            配達希望時間&nbsp;<p class="req">※必須</p><nobr>
                                                {
                                                指定なし<input type="radio" name="delivery_request_time" value="指定なし" required>
                                                午前<input type="radio" name="delivery_request_time" value="午前">
                                                12時～14時<input type="radio" name="delivery_request_time" value="12時～14時"><br>
                                                14時～16時<input type="radio" name="delivery_request_time" value="14時～16時">
                                                16時～18時<input type="radio" name="delivery_request_time" value="16時～18時">
                                                18時～20時<input type="radio" name="delivery_request_time" value="18時～20時">
                                                20時～21時<input type="radio" name="delivery_request_time" value="20時～21時">
                                                <br>

                                                <!-- クレジットか代引きのチェックボックス（クレジットの場合記述必須にする）-->
                                                <br><br>
                                                <h3>お支払方法の選択&nbsp;</h3><p class="req">※必須</p><nobr>
                                                    <input id="pay_card" type="radio" name="payment" value="クレジットカード" onclick="changeRequiredCardInfo();">
                                                    クレジットカード<br>
                                                    カード番号<input class="card" id="card_0" type="text" name="card_number" disabled>
                                                    セキュリティコード<input class="card" id="card_1" type="text" name="security_code" disabled="true">
                                                    年<input class="card" id="card_2" type="text" name="year" disabled="true">
                                                    月<input class="card" id="card_3" type="text" name="month" disabled="true">
                                                    <br>
                                                    半角数字のみ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    例：1234123412341234
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    年/月 例：20/10<br><br>

                                                    <input type="radio" name="payment" value="商品代引き" onclick="changeRequiredCardInfo();" required>商品代引き<br>手数料324円<br><br>

                                                    <table class="ta1">
                                                        <tr>
                                                            <th>注文合計</th>
                                                            <td>\13,000</td>
                                                        </tr>
                                                        <tr>
                                                            <th>手数料</th>
                                                            <td>\324</td>
                                                        </tr>
                                                        <tr>
                                                            <th>合計</th>
                                                            <td>\13,324</td>
                                                        </tr>
                                                    </table>
                                                    <br>
                                                    <p><input type="submit" value="注文する"></p>

            </form>
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
            <script type="text/javascript">
				if (OCwindowWidth() < 480) {
				open_close("newinfo_hdr", "newinfo");
				}
            </script>

        </body>
    </html>
