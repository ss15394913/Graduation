/*
  @author 塩澤麻人
   @date 2017/02/13
*/
/*
	memo
	ProductInfomationのbeanとdaoを使う
	カート内に表示する商品の情報を取ってくる
*/

package command;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;
import logic.ResponseContext;

public class ShowCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		RequestContext req = getRequestContext();
		HashMap<String,String> cartInfo = new HashMap<String,String>();
		if(req.getSessionAttribute( "cart" ) != null){
			System.out.println("cartありますif");
			cartInfo.put("cartInfo",new String("cartpresence"));
		}else{
			System.out.println("cartなかったよif");
			cartInfo.put("cartInfo",new String("noncartpresence"));
		}
		
		List cart = (ArrayList)req.getSessionAttribute( "cart" );
		Map<String,String> productInformation = new HashMap<String,String>();
		
		Map<String, Integer> countProductsInfo = new HashMap<String, Integer>()
		
		System.out.println("カートのサイズは"+cart.size()+"です");
		
		int totalprice = 0;
		//商品の金額、注文数をかけたものの合計金額を表す
		
		int productprice = 0;
		//1商品の単価を表す
		
		int totalItemCount = 0;
		
		int ordercount = 1;
		//1商品の注文数を表す
		for(int i = 0;i<cart.size();i++){
			productInformation = (HashMap<String,String>)cart.get(i);
			
			productprice = Integer.parseInt((String)productInformation.get("productPrice"));
			
			ordercount = Integer.parseInt((String)productInformation.get("count"));
			totalItemCount += ordercount;
			totalprice += productprice * ordercount;
			
			countProductsInfo.put("totalItemCount",totalItemCount)
			countProductsInfo.put("totalprice",totalprice)
			
			System.out.println(i+"回目の合計金額は"+totalprice);
		}
		
		setResult("countProductsInfo",countProductsInfo);
		
		responseContext.setTarget("cart");
		
		return responseContext;
	}
}