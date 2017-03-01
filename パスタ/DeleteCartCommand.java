package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.ResponseContext;

import java.util.Map;
import java.util.HashMap;

/**
 *@className DeleteCartCommand
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 */
/*
カートに登録された商品を削除するCommand
*/
public class DeleteCartCommand extends AbstractCommand{

	public DeleteCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = getRequestContext();
		
		/*
		削除したい商品が選択された
		aLotOf・・・たくさんの
		*/
		String[] aLotOfProductId = req.getParameter("productid");
		String productId;
		Map<String,String> cart = (Map<String,String>)req.getSessionAttribute("cart");
		int checkNumber = 0;
		
		
		for ( int i =0;i < aLotOfProductId.length ;i++ ) {
			productId =  aLotOfProductId[i];
			/*
			カート内の商品を削除する際に、削除する商品が選ばれていないとnullが返る
			対応するために一旦null判定のStringを挟む
			中身がnullの場合0ではなく-1で上書きする
			*/
			if(productId == null){
				checkNumber = -1;
			}
			/*
			上で設定したnull場合の-1がきたら、カート内に商品がまだ存在しないので
			削除する文を実行させない。
			*/
			if(0 <= checkNumber){
				if(cart.containsKey(productId) == true){
					cart.remove(productId);
					req.setSessionAttribute("cart",cart);
				}
			}else{
				System.out.println("削除する商品を選択してね！");
			}
		}
		responseContext.setTarget("cartdelete");
		
		return responseContext;
	}
}

