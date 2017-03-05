/*
@author 窪田
*/
function changeRequiredAddressInfo(){
	var element = document.getElementById("change");
	//チェックボックスの状態を取得
	
	if(element.checked){
		//true --> 
		for(var i = 0;i<=4;i++){
			target = document.getElementById("address_"+i);
			target.value="";
			target.required="true";
		}
	}else{
		for(var i = 0;i<=4;i++){
			target = document.getElementById("address_"+i);
			target.value="";
		}
	}
}

function changeRequiredCardInfo(){
	var element = document.getElementById("pay_card");
	var payment_total;
	if(element.checked){
		for(var i = 0;i<=3;i++){
			document.getElementById("card_"+i).required="true";
			//入力必須化にする
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
			
			total_order = document.getElementById("hiddentotalprice");
			
			total_order.value=payment_total;
	}
}

