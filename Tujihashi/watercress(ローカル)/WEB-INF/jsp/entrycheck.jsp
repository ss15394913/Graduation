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
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<style>.ddmenu {display: none;}</style>
<![endif]-->
<script type="text/javascript" src="js/openclose.js"></script>
<script type="text/javascript" src="ddmenu_min.js"></script>
</head>

<body id="top" class="c1">

<div id="container">

<header>
<h1 id="logo"><a href="top.html"><img src="images/logo.png" width="370" height="60" alt="Sample Online Shop"></a></h1>
<div class="headermenu">
<ul>
<a href="userentry.html">����o�^</a>
<a href="login.html">���O�C��</a>
</ul>
<div id="cart"><a href="#">CART</a></div>
</header>

<nav id="menubar">
<ul>
<li class="arrow"><a>CATEGORY</a>
    <ul class="ddmenu">
    <li><a href="list.html">TOPS</a></li>
    <li><a href="list2.html">BOTTOMS</a></li>
    <li><a href="list3.html">UNDER</a></li>
    <li><a href="list4.html">SHOES</a></li>
    <li><a href="list5.html">ACCESSORIES</a></li>
	</ul>
</li>
<li class="arrow"><a href="productlist.html">SALE</a>
</li>
<li class="arrow"><a href="productlist.html">RANKING</a>
</li>
<li class="arrow"><a href="productlist.html">ALLITEM</a>
</li>
<li class="arrow"><a>HELP</a>
    <ul class="ddmenu">
    <li><a href="contact.html">���₢���킹</a></li>
    <li><a href="question.html">Q&A</a></li>
</li>
</ul>
</nav>

</div>
<!--/contents-->

</div>
<!--/container-->
<br>
<br>		
		<form id="registform" class="h-adr" action="${pageContext.request.contextPath}/front/entrytemp" method="post">
			���O<input type="text" value="${data.memberName}" name="firstName" disabled>&nbsp;&nbsp;��F�R�c ���Y<br><br>
			
			
			�i�}�G<label><input type="text" value="${data.memberKana}" name="kanalastname" pattern="^[�@-��]+$" disabled></label>
			&nbsp;&nbsp;��G���}�_ �^���E
			<br><br>
			���N����<input type="date" value="${data.memberBirthday}" name="memberBirthday" disabled>&nbsp;&nbsp;��:2000/01/01<br><br>
			<span class="p-country-name" style="display:none;">Japan</span>
		
			���X�֔ԍ�<input type="text" value="${data.memberZipCode}" name="memberZipCode" class="p-postal-code" size="7" maxlength="7" autocomplete="postal-code" disabled>&nbsp;��:1648787<br><br>
		
			<input type="text" value="${data.memberAddress}" name="prefectures" class="p-region" autocomplete="address-level1" readonly required disabled/>&nbsp;��F�����s<br>
			�s�撬��<input type="text" name="municipality" class="p-locality" autocomplete="address-level2" required disabled/>&nbsp;��F�����<br>
			�Ԓn<input type="text" name="address" class="p-street-address" autocomplete="address-line1" required disabled/>&nbsp;��F������4-2-3<br>
			������<input type="text" name="buildingName" class="p-extended-address" autocomplete="address-line2" required disabled/>&nbsp;��F���w�Z�����e�N�j�J���J���b�W<br><br>

			�d�b�ԍ�<input type="text" value="${data.memberPhoneNumber}" name="memberPhoneNumber" required disabled>��F0120444906<br><br>
			<div>
				<label for="emailInput">���[���A�h���X</label>&nbsp;&nbsp;��Fexample@example.com
			</div>
			
			<div>
				<input type="email" value="${data.memberEmail}" id="emailInput" autocomplete="email" maxlength="256" required disabled/>
			</div>
			
			
			
			<div>
				<label for="passInput">�p�X���[�h</label>&nbsp;&nbsp;��Fpassword
			</div>
			
			<div>
				<input type="password" name='memberPassword' id="passInput" pattern="^[0-9A-Za-z]+$" required disabled/>
				<input id="passCheckBox"type="checkbox" onclick="CheckPass();" required disabled>�p�X���[�h�̃`�F�b�N������
			</div>
			
			
				<FONT color="red">�ȏ�̓��e�œo�^���܂�</FONT><br>
			
			<input id="submitButton" type="submit" value="�m�F������" >
		</form>

<footer>

<div class="footermenu">
<ul>
<a href="companyinfo.html">��ЊT�v�@�@�@</a>
<a href="tos.html">�@�@�@���p�K��</a>
<a href="sitemap.html">�@�@�@�T�C�g�}�b�v</a>
<a href="privacypolicy.html">�@�@�@�l���ی���j</a>
<a href="deal.html">�@�@�@���菤����@</a>
<a href="contact.html">�@�@�@���₢���킹</a>
<a href="question.html">�@�@�@Q&A</a>
<br>
<br>
</ul>

<center><small>Copyright&copy; <a href="top.html">Sample Online Shop</a>�@All Rights Reserved.</small>
<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>



</footer>

<!--�X���C�h�V���[�X�N���v�g-->
<script type="text/javascript" src="js/slide_simple_pack.js"></script>

<!--�X�}�z�p�X�V���-->
<script type="text/javascript">
if (OCwindowWidth() < 480) {
	open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>