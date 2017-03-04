
function CheckEmail(input){
	var mail = emailInput.value; //メールフォームの値を取得
	var mailConfirm = input.value; //メール確認用フォームの値を取得(引数input)

	// 一致確認
	if(mail != mailConfirm){
		input.setCustomValidity('メールアドレスが一致しません'); // エラーメッセージのセット
	}else{
		input.setCustomValidity(''); // エラーメッセージのクリア
	}
}

/*function CheckPass(input){
	var pass = passInput.value; //パスワードフォームの値を取得
	var passConfirm = input.value; //パスワード確認用フォームの値を取得(引数input)
	input.setCustmValidity('');//最初にエラーメッセージを初期化
	// 一致確認
	if(pass != passConfirm){
	input.setCustomValidity('パスワードが一致しません'); // エラーメッセージのセット
	}else{
		if(pass.length<8){
			input.setCustomValidity('パスワードに必要な文字数が足りません'); // エラーメッセージのセット
		}else if(pass.length>32){
			input.setCustomValidity('パスワードが許容できる文字数を超えています');
		}else{
			input.setCustmValidity('');
		}
	}
}*/

function CheckPass(){
	var checkbox = document.getElementById( "passCheckBox" );
	
	if(checkbox!=true){
		
		pass = registform.passInput.value;
		passConfirm = registform.passConfirm.value;
		
		if(pass != passConfirm){
			document.getElementById("passMessage").innerHTML="パスワードが一致しません。";
			checkbox.checked = false;
			
		}else{
			if(pass.length<8 || passConfirm.length<8){
				document.getElementById("passMessage").innerHTML=
				"パスワードに必要な文字数が足りていません。";
				checkbox.checked = false;
				
			}else if(pass.length>32 || passConfirm.length>32){
				document.getElementById("passMessage").innerHTML=
				"パスワードが許容できる文字数を超えています。";
				checkbox.checked = false;
				
			}else{
				document.getElementById("passMessage").innerHTML="パスワードチェックが完了しました。<br><input type=\"button\" value=\"変更する\" onclick=\"deletePass()\">";
				document.getElementById( "passInput" ).readOnly="true";
				document.getElementById( "passConfirm" ).readOnly="true";
				var password = document.getElementById( "passInput" ).innerHTML;
				document.getElementById( "hiddenPassword" ).value = password;
				checkbox.disabled="true";
			}
		}
	}

}

function deletePass(){
	document.getElementById( "passInput" ).disabled="";
	document.getElementById( "passConfirm" ).disabled="";
	document.getElementById( "passInput" ).value="";
	document.getElementById( "passConfirm" ).value="";
	var checkbox = document.getElementById( "passCheckBox" );
	checkbox.checked = false;
	document.getElementById("passMessage").innerHTML="パスワードをもう一度入力してください。";
	checkbox.disabled="";
	
	var agreebutton = document.getElementById("agreeButton");
	agreebutton.checked = false;
	var submitbutton = document.getElementById("submitButton");
	submitbutton.style.display="none";
	
}
function arrivalButton(){
	var submitbutton = document.getElementById("submitButton");
	submitbutton.style.display="none";
	var checkbox = document.getElementById( "passCheckBox" );
	var submitbutton = document.getElementById("submitButton");
	if(checkbox=true){
		submitbutton.style.display="block";
	}else{
		alert('全ての必須項目を入力してからチェックしてください。');
		checkbox.checked=false;
	}
}