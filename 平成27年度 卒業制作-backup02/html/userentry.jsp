<%@ page language="java" contentType="text/html; charset=windows-31J"
	pageEncoding="windows-31J"%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>This is userentry</title>
		
		<script src="inputDestruction.js" charset="UTF-8"></script>
		<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
		<script src="userentry.js" charset="UTF-8"></script>
		
		<style>
			#submitButton{
				display:none;
			}
		</style>
		
	</head>
	<body >
		<a href="usercheck.html" >登録情報確認ページ</a>
		
		<form id="registform" class="h-adr" action="" method="post">
			性<input type="text" name="firstname" required>
			&nbsp;&nbsp;&nbsp;
			名<input type="text" name="lastname" required>&nbsp;&nbsp;例：山田 太郎<br><br>
			
			セイ<label><input type="text" value="" name="kanafirstname" pattern="^[ァ-ン]+$" required></label>
			&nbsp;&nbsp;&nbsp;
			メイ<label><input type="text" value="" name="kanalastname" pattern="^[ァ-ン]+$" required></label>
			&nbsp;&nbsp;例；ヤマダ タロウ
			<br><br>
			生年月日<input type="date" name="birthday" required>&nbsp;&nbsp;例:2000/01/01<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
		
			〒郵便番号<input type="text" class="p-postal-code" size="7" maxlength="7" autocomplete="postal-code" required>&nbsp;例:1648787<br><br>
		
			都道府県<input type="text" class="p-region" autocomplete="address-level1" readonly required/>&nbsp;例：東京都<br>
			市区町村<input type="text" class="p-locality" autocomplete="address-level2" required/>&nbsp;例：中野区<br>
			番地<input type="text" class="p-street-address" autocomplete="address-line1" required/>&nbsp;例：東中野4-2-3<br>
			建物名<input type="text" class="p-extended-address" autocomplete="address-line2" required/>&nbsp;例：専門学校東京テクニカルカレッジ<br><br>

			電話番号<input type="text" name="phone_number" required>例：0120444906<br><br>
			<div>
				<label for="emailInput">メールアドレス</label>&nbsp;&nbsp;例：example@example.com
			</div>
			
			<div>
				<input type="email" id="emailInput" autocomplete="email" maxlength="256" required />
			</div>
			
			<div>
				<label for="emailConfirm">メールアドレス確認</label>
			</div>
			
			<div>
				<input type="email" id="emailConfirm" autocomplete="email" required onblur="CheckEmail(this)" />
			</div>
			
			<div>
				<label for="passInput">パスワード</label>&nbsp;&nbsp;例：password
			</div>
			
			<div>
				<input type="password" id="passInput" pattern="^[0-9A-Za-z]+$" required />
				<input id="passCheckBox"type="checkbox" onclick="CheckPass();" required>パスワードのチェックをする
			</div>
			
			<div>
				<label for="passConfirm">パスワード確認</label>
			</div>
			
			<div>
				<input type="password" id="passConfirm" required pattern="^[0-9A-Za-z]+$" />
				<p id="passMessage"></p>
			</div>
				利用規約・個人情報保護方針に同意する<input type="checkbox" id="agreeButton" name="consent" required onclick="arrivalButton()"/>
			
			<input id="submitButton" type="submit" value="確認をする" >
		</form>
	</body>
</html>