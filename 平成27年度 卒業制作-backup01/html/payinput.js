/**
@author 窪田
*/

/** @method 住所を変更する項目のイベント。郵便番号から建物名までの入力必須、入力領域の変更を行う
 デフォルト：変更しない。入力できない
 true --> @return 入力できるようになる、入力必須になる
 false --> @return 入力領域の値をクリアし入力領域をロック、入力必須を解除
*/
function changeRequiredAddressInfo(){
	var element = document.getElementById("change");
	//チェックボックスの状態を取得
	
	if(element.checked){
		//true --> 
		for(var i = 0;i<=4;i++){
			document.getElementById("address_"+i).required="true";
			document.getElementById("address_"+i).disabled="";
		}
	}else{
		for(var i = 0;i<=4;i++){
			document.getElementById("address_"+i).value="";
			document.getElementById("address_"+i).required="";
			document.getElementById("address_"+i).disabled="true";
		}
	}
}

/** @method 支払い方法の項目を状態を変更するイベント。
      クレジット支払い・商品代引きのラジオボタン選択時に発生。
      クレジットカード番号から有効期限までの入力必須、入力領域の変更を行う。
 デフォルト：入力できない
 true --> @return 入力できるようになる、入力必須になる
 		  手数料０円になる→支払い合計は、注文合計と同一金額になる
 false --> @return 入力領域の値をクリアし入力領域をロック、入力必須を解除
		   手数料が324円（現在のデフォルト）になり対応した書き換えを行う
*/

function changeRequiredCardInfo(){
	var element = document.getElementById("pay_card");
	var payment_total;
	if(element.checked){
		console.log('true');
		for(var i = 0;i<=3;i++){
			document.getElementById("card_"+i).required="true";
			//入力必須化にする
			document.getElementById("card_"+i).disabled="";
			//入力領域ロックを解除
		}
		document.getElementById("comission").innerHTML="0円";
			//手数料を０円にする
			payment_total = document.getElementById("order_total").innerHTML;
			//合計金額を支払い合計にする
			document.getElementById("payment_total").innerHTML=payment_total;
			//書き換え
	}else{	
		comission = "324";
		for(var i = 0;i<=3;i++){
			document.getElementById("card_"+i).required="";
			document.getElementById("card_"+i).value="";
			document.getElementById("card_"+i).disabled="true";
		}
		
		order_total = document.getElementById("order_total").innerHTML;
			Iorder_total = order_total.slice(0,-1);
			//「11000円」を「11000」にする
			payment_total = parseInt(Iorder_total)+parseInt(comission);
			//注文合計と手数料を数値型に変換し合計金額を算出
			payment_total+="円";
			//合計金額に"円"を付ける
			document.getElementById("payment_total").innerHTML=payment_total;
			//書き換え
			document.getElementById("comission").innerHTML=comission+"円";
	}
}