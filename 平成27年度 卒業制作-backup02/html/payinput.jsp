<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>This is payinput</title>
		
			<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
			<script src="inputDestruction.js" charset="UTF-8"></script>
			<script src="payinput.js" charset="UTF-8"></script>

		<style>	
			#card_0{
				width:120px;
			}
			
			#card_1{
				width:35px;
			}
			
			#card_2{
				width:18px;
			}
			
			#card_3{
				width:18px;
			}
			
			.name{
				width:120px;
			}
			.req{
				color:red;
			}
		</style>
		
	</head>
	<body >
		<a href="top.html" >トぷぱげ</a>
		
		<form class="h-adr" action="" method="post">
			<h3>お届け先住所</h3>

			性<input class="name" type="text" name="firstname" required><p class="req">※必須</p><nobr>
			&nbsp;&nbsp;&nbsp;
			名<input class="name" type="text" name="lastname"required><p class="req">※必須</p><nobr>&nbsp;&nbsp;例：山田&nbsp;太郎
			<br><br>
			セイ<input class="name" type="text" name="kanafirstname" required pattern="^[?@-??]+$"><p class="req">※必須</p><nobr>
			メイ<input class="name" type="text" name="kanalastname" required pattern="^[?@-??]+$"><p class="req">※必須</p><nobr>&nbsp;&nbsp;例：ヤマダ&nbsp;タロウ
			<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
			
			<!--チェックボックスで住所を変更あるかないか-->
			<input type="checkbox" id="change" name="del_add_change" value="notchange" onclick="changeRequiredAddressInfo();">届け先住所を変更する<br>
			
			〒郵便番号<input type="text" id="address_0" class="p-postal-code" size="8" maxlength="8" autocomplete="postal-code">&nbsp;&nbsp;例：1648787<br><br>
		
			都道府県　<input type="text" id="address_1" class="p-region" autocomplete="address-level1" readonly />&nbsp;&nbsp;例：東京都<br>
			市区町村　<input type="text" id="address_2" class="p-locality" autocomplete="address-level2" />&nbsp;&nbsp;中野区<br>
			番地　　　　<input type="text" id="address_3" class="p-street-address" autocomplete="address-line1" />&nbsp;&nbsp;東中野4-2-3<br>
			建物名　　 <input type="text" id="address_4" class="p-extended-address" autocomplete="address-line2" />&nbsp;&nbsp;専門学校 東京テクニカルカレッジ<br><br>
			
			電話番号<input type="text" name="phone_number" required><p class="req">※必須</p><nobr><br>
			半角数字のみ。ハイフン(-)は入れない。<p class="req">※必須</p><nobr>09012345678<br>
			
			
			<h3>配達時間指定</h3>
			配達希望日&nbsp;<p class="req">※必須</p><nobr>{
				3営業日後<input type="radio" name="delivery_request_day" value="3" required>
				4営業日後<input type="radio" name="delivery_request_day" value="4">
				5営業日後<input type="radio" name="delivery_request_day" value="5">
				6営業日後<input type="radio" name="delivery_request_day" value="6">
				7営業日後<input type="radio" name="delivery_request_day" value="7">
				<br>
			配達希望時間&nbsp;<p class="req">※必須</p><nobr>{
				指定なし<input type="radio" name="delivery_request_time" value="指定なし" required>
				午前<input type="radio" name="delivery_request_time" value="午前">
				12時～14時<input type="radio" name="delivery_request_time" value="12時～14時"><br>
				14時～16時<input type="radio" name="delivery_request_time" value="14時～16時">
				16時～18時<input type="radio" name="delivery_request_time" value="16時～18時">
				18時～20時<input type="radio" name="delivery_request_time" value="18時～20時">
				20時～21時<input type="radio" name="delivery_request_time" value="20時～21時">
				<br>
			
			<!-- クレジットか代引きのチェックボックス（クレジットの場合記述必須にする）-->

			<h3>お支払方法の選択&nbsp;<p class="req">※必須</p><nobr></h3>
			クレジットカード<input id="pay_card" type="radio" name="payment" value="クレジットカード" onclick="changeRequiredCardInfo();">
			
			カード番号<input class="card" id="card_0" type="text" name="card_number" disabled>
			セキュリティコード<input class="card" id="card_1" type="text" name="security_code" disabled="true">
			年<input class="card" id="card_2" type="text" name="year" disabled="true">
			月<input class="card" id="card_3" type="text" name="month" disabled="true">
			<br>
			半角数字のみ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			例：1234123412341234
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			年/月 例：20/10<br><br>

			商品代引き<input type="radio" name="payment" value="商品代引き" onclick="changeRequiredCardInfo();" required>手数料324円<br><br>
			
			<!--注文合計:セッションスコープから取得-->
			<table border="1" align="center">
				<tr><td>注文合計</td><td id="order_total">11000円</td></tr>
				<tr><td>手数料</td><td id="comission">0円</td></tr>
				<tr><td>支払い合計</td><td id="payment_total">11000円</td></tr>
				<tr><td colspan="2" align="center"><input type="submit" value="確認画面に移行"></td></tr>
			</table>
		</form>
	</body>
</html>