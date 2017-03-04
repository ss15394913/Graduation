/*
  @author 宇津野光
  @date 2017/02/15

  @author 池田大和
  @date 2017/03/03
  @description ログインしていない状態で、注文情報入力画面を表示するコマンドのクラス。
  合計金額などの必要な情報を取得するための処理を追加。
*/

package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

public class ShowNonMemberOrderCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		RequestContext requestContext = getRequestContext();

		/*cartを取得*/
		ArrayList cart = (ArrayList)requestContext.getSessionAttribute("cart");

		/*jspに渡すためのmap*/
		Map<String,String> memberInformation = new HashMap<String,String>();

		/*注文の合計金額を取得する*/
		int orderprice = getOrdertotal(cart);

		memberInformation.put("orderprice",String.valueOf(orderprice));

		responseContext.setResult(memberInformation);

		responseContext.setTarget("nonmemberorder");

		return responseContext;
	}

	/*注文の合計金額を取得するメソッド*/
	private int getOrdertotal(ArrayList cart){

		HashMap productInformation;
		//1種類の商品を表す

		int totalprice = 0;
		//商品の金額、注文数をかけたものの合計金額を表す

		int productprice = 0;
		//1商品の単価を表す

		int ordercount = 1;
		//1商品の注文数を表す

		for(int i = 0;i<cart.size();i++){
			productInformation = (HashMap<String,String>)cart.get(i);

			productprice = Integer.parseInt((String)productInformation.get("productPrice"));

			ordercount = Integer.parseInt((String)productInformation.get("count"));

			totalprice += productprice * ordercount;

			System.out.println(i+"回目の合計金額は"+totalprice);
		}

		return totalprice;
	}
}