<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<html>
<head><title>ユーザー登録</title>
	<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
	<script src="inputDestruction.js" charset="UTF-8"></script>
</head>
<body>
	<h1>ユーザー登録<h1>
	<form class="h-adr" method='post' action='adduser'>
	<span class="p-country-name" style="display:none;">Japan</span>
	名字<input type='text' name='lastName'><br>
	名<input type='text' name='firstName'><br>
	フリガナ<input type='text' name='memberKana'><br>
	誕生日<input type="date" name="memberBirthday" required autocomplete="bday"><br>
	
	〒<input type="text" name="memberZipCode" class="p-postal-code" size="8" maxlength="8" autocomplete="postal-code"><br><br>
		
		都道府県　<input type="text" name="prefectures" class="p-region" autocomplete="address-level1" readonly /><br>
		市区町村　<input type="text" name="municipality" class="p-locality" autocomplete="address-level2" readonly /><br>
		番地　　　　<input type="text" name="address" class="p-street-address" autocomplete="address-line1" /><br>
		建物名　　 <input type="text" name="buildingName" class="p-extended-address" autocomplete="address-line2" /><br>
	電話番号<input type="tel" name="memberPhoneNumber" required autocomplete="bday"><br>
	メールアドレス<input type="email" name="memberEmail" required autocomplete="bday"><br>
	メールアドレスの確認<input type="email" name="confirmationMail" required autocomplete="bday"><br>
	
	パスワード<input type='password' name='memberPassword'><br>
	パスワードの確認<input type='password' name=''><br>
	
	<input type='submit' value='確認'>
	</form>
	
</body>
</html>