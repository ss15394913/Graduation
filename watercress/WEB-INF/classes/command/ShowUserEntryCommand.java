package command;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;
/**
 *@className AbstractCommand
 *@author Kohichi Tujihashi
 *@date 2017/03/03
 *@description
 */
public class ShowUserEntryCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{




		RequestContext reqc = getRequestContext();



		responseContext.setTarget( "userentry" );
		//登録確認ページに移動

		return responseContext;
	}
}
/**



*/
