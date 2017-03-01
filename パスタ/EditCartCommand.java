package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.ResponseContext;

import java.util.Map;
import java.util.HashMap;

/**
 *@className EditCartCommand
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 */
/*
カートに登録された商品の、注文する個数を変更するCommand
*/
public class EditCartCommand extends AbstractCommand{

	public EditCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = getRequestContext();
		
		/*
		削除する商品が選択された
		aLotOf・・・たくさんの
		*/
		String productId = req.getParameter("productid")[0];
		String itemCount = req.getParameter("itemcount")[0];
		Map<String,String> cart = new HashMap<String,String>();
		req.setSessionAttribute("cart", cart);
		cart = (Map<String,String>)req.getSessionAttribute("cart");
		if(productId != null || itemCount != null){
			if(cart.containsKey(productId) == true){
				cart.put(productId,itemCount);
			}
		}
		
		
		responseContext.setTarget("cartedit");
		
		return responseContext;
	}
}

