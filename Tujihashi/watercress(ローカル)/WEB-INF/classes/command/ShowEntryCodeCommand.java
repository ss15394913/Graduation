package command;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AbstractCommand
 *@author Kohichi Tujihashi
 *@date 2017/01/26
 *@description
 */
public class ShowEntryCodeCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		RequestContext reqc = getRequestContext();



		responseContext.setTarget( "entrycode" );
		//登録確認ページに移動
		//AppricationControllerのsetAttributeに
		//登録するためにsetResultメソッドを使ってbeanを登録
		return responseContext;
	}
}
/**



*/
