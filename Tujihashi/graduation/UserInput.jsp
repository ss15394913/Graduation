<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>
<html>
<head><title>���[�U�[�o�^</title>
	<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
	<script src="inputDestruction.js" charset="UTF-8"></script>
</head>
<body>
	<h1>���[�U�[�o�^<h1>
	<form class="h-adr" method='post' action='adduser'>
	<span class="p-country-name" style="display:none;">Japan</span>
	����<input type='text' name='lastName'><br>
	��<input type='text' name='firstName'><br>
	�t���K�i<input type='text' name='memberKana'><br>
	�a����<input type="date" name="memberBirthday" required autocomplete="bday"><br>
	
	��<input type="text" name="memberZipCode" class="p-postal-code" size="8" maxlength="8" autocomplete="postal-code"><br><br>
		
		�s���{���@<input type="text" name="prefectures" class="p-region" autocomplete="address-level1" readonly /><br>
		�s�撬���@<input type="text" name="municipality" class="p-locality" autocomplete="address-level2" readonly /><br>
		�Ԓn�@�@�@�@<input type="text" name="address" class="p-street-address" autocomplete="address-line1" /><br>
		�������@�@ <input type="text" name="buildingName" class="p-extended-address" autocomplete="address-line2" /><br>
	�d�b�ԍ�<input type="tel" name="memberPhoneNumber" required autocomplete="bday"><br>
	���[���A�h���X<input type="email" name="memberEmail" required autocomplete="bday"><br>
	���[���A�h���X�̊m�F<input type="email" name="confirmationMail" required autocomplete="bday"><br>
	
	�p�X���[�h<input type='password' name='memberPassword'><br>
	�p�X���[�h�̊m�F<input type='password' name=''><br>
	
	<input type='submit' value='�m�F'>
	</form>
	
</body>
</html>