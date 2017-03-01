<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>Watercress_TOP</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="�����ɃT�C�g���������܂�">
<meta name="keywords" content="�L�[���[�h�P,�L�[���[�h�Q,�L�[���[�h�R,�L�[���[�h�S,�L�[���[�h�T">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<style>.ddmenu {display: none;}</style>
<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/openclose.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ddmenu_min.js"></script>
<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>

</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="${pageContext.request.contextPath}/front/top"><img src="${pageContext.request.contextPath}/images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="${pageContext.request.contextPath}/front/userentry">����o�^</a>
<a href="${pageContext.request.contextPath}/front/login">���O�C��</a>
</ul>
<div id="cart"><a href="#">CART</a></div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="${pageContext.request.contextPath}/list">TOPS</a></li>
    <li><a href="${pageContext.request.contextPath}/list2">BOTTOMS</a></li>
    <li><a href="${pageContext.request.contextPath}/list3">UNDER</a></li>
    <li><a href="${pageContext.request.contextPath}/list4">SHOES</a></li>
    <li><a href="${pageContext.request.contextPath}/list5">ACCESSORIES</a></li>
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
    <li><a hre
<!--/container-->
<br>
<br>
	<p>�o�^���</p>
		<form id="registform" class="h-adr" action="${pageContext.request.contextPath}/front/entrycheck" method="post">
			���O<input type="text" name="memberName" required>��F�R�c ���Y<br><br>
			
			
			�i�}�G<label><input type="text" value="" name="memberKana" pattern="^[�@-��]+$" required></label>
			��G���}�_ �^���E
			<br><br>
			���N����<input type="date" name="memberBirthday" required>&nbsp;&nbsp;��:2000/01/01<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
		

		    ��<input type="text" name="memberZipCode" class="p-postal-code" size="7" maxlength="7">
		    <br>

		    �s���{��<input type="text" name="memberAddress" class="p-region" readonly /><br>
		    �s��<input type="text" name="memberAddress" class="p-locality" readonly /><br>
		    ����<input type="text" name="memberAddress" class="p-street-address" /><br>
		    �r����<input type="text" name="memberAddress" class="p-extended-address" />
			<br><br>

			�d�b�ԍ�<input type="text" name="memberPhoneNumber" required>��F0120444906<br><br>
			<div>
				<label for="emailInput">���[���A�h���X</label>&nbsp;&nbsp;��Fexample@example.com
			</div>
			
			<div>
				<input type="email" name="memberEmail" id="emailInput" autocomplete="email" maxlength="256" required />
			</div>
			
			<div>
				<label for="emailConfirm">���[���A�h���X�m�F</label>
			</div>
			
			<div>
				<input type="email" id="emailConfirm" autocomplete="email" required onblur="CheckEmail(this)" />
			</div>
			
			<div>
				<label for="passInput">�p�X���[�h</label>&nbsp;&nbsp;��Fpassword
			</div>
			
			<div>
				<input type="password" name='memberPassword' id="passInput" pattern="^[0-9A-Za-z]+$" required />
				<input id="passCheckBox"type="checkbox" onclick="CheckPass();" required>�p�X���[�h�̃`�F�b�N������
			</div>
			
			
<!--/contents-->

</div><"Confirm">�p�X���[�h�m�F</label>
			</div>
			
			<div>
				<input type="password" id="passConfirm" required pattern="^[0-9A-Za-z]+$" />
				<p id="passMessage"></p>
			</div>
				���p�K��E�l���ی���j�ɓ��ӂ���<input type="checkbox" id="agreeButton" name="consent" required onclick="arrivalButton()"/>
			
			<input id="submitButton" type="submit" value="�m�F������" >
		</form>

<footer>

<div class="footermenu">
<ul>
<a href="${pageContext.request.contextPath}/front/companyinfo">��ЊT�v�@�@�@</a>
<a href="${pageContext.request.contextPath}/front/tos">�@�@�@���p�K��</a>
<a href="${pageContext.request.contextPath}/front/sitemap">�@�@�@�T�C�g�}�b�v</a>
<a href="${pageContext.request.contextPath}/front/privacypolicy">�@�@�@�l���ی���j</a>
<a href="${pageContext.request.contextPath}/front/deal">�@�@�@���菤����@</a>
<a href="${pageContext.request.contextPath}/front/contact">�@�@�@���₢���킹</a>
<a href="${pageContext.request.contextPath}/front/question">�@�@�@Q&A</a>
<br>
<br>
</ul>

<center><small>Copyright&copy; <a href="${pageContext.request.contextPath}/front/top">Sample Online Shop</a>�@All Rights Reserved.</small>
<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>



</footer>

<!--�X���C�h�V���[�X�N���v�g-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/slide_simple_pack.js"></script>

<!--�X�}�z�p�X�V���-->
<script type="text/javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>
