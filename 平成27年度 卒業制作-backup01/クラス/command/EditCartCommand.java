package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.ResponseContext;

import javax.servlet.http.HttpSession;


/**
 *@className EditCartCommand
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 */
/*
カートに登録された商品を削除するCommand
*/
public class EditCartCommand extends AbstractCommand{

	public EditCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = getRequestContext();
		
		
		HttpSession session = (HttpSession)req.getSession();
		
		String listNumberString = req.getParameter("listNumber")[0];
		int listNumberInt = -1;
		
		/*
		カート内の商品を削除する際に、削除する商品を選ぶとnullが返る
		対応するために一旦null判定のStringを挟む
		*/
		String checkString = listNumberString;
		int checkInt=0;
		System.out.println("ここまで");
		/*
		中身がnullの場合0ではなく-1で上書きする
		*/
		if(checkString == null){
			checkInt = -1;
		}
		
		/*
		上で設定したnull場合の-1がきたら、カート内に商品がまだ存在しないので
		削除する文を実行させない。
		*/
		if(0 <= checkInt){
			listNumberInt = Integer.parseInt(listNumberString);
		}else{
			System.out.println("削除する商品を選択してね！");
		}
		
		System.out.println(listNumberInt+"てすと@servlet内");
		
		
		String removeResultNumber = "result" + listNumberString;
		System.out.println(removeResultNumber+":::てすと");
		
		session.removeAttribute(removeResultNumber);
		
		responseContext.setTarget("cart");
		/**
		 *@see ResponseContext#init
		 *@param req クライアントからのリクエスト
		 */
		return responseContext;
	}
}

