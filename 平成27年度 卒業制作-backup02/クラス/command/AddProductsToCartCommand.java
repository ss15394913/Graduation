package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.WebRequestContext;
import logic.ResponseContext;




import java.util.Map;
import java.util.HashMap;


/**
 *@className AddProductsToCartCommand
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 *@商品をmapで登録する
 */
public class AddProductsToCartCommand extends AbstractCommand{
	
	public AddProductsToCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		
		RequestContext req = new WebRequestContext();
		Map<String,String> cart;
		/*商品名と商品個数を入れるcartを作成*/
		if(req.getSessionAttribute("cart") == null){
			cart = new HashMap<String,String>();
		}else{
			cart = (Map<String,String>)req.getSessionAttribute("cart");
		}
		
		/*入力\されたパラメータを受け取る*/
		String productId = req.getParameter("productid")[0];
		String itemCount =req.getParameter("itemcount")[0];
		
		/*
		商品と商品の個数をcartに登録
		cart.put("key","value");
		まったく同じ商品を追加した場合とりあえず例外へ
		今後に期待
		*/
		if(cart.containsKey(productId) == true){
			cart.put(productId,itemCount);
		}else{
			System.out.println("追加する商品が重複してます例外を飛ばす");
		}
		
		/*mapの変数cartをcartって名前でcart.jspに飛ばす*/
		req.setSessionAttribute("cart", cart);
		//カートに商品名と個数を登録しましたページへ飛ぶけど、まだ未定
		responseContext.setTarget("showAddProductComp");
		
		return responseContext;
	}
}