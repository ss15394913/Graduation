package command;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AbstractCommand
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description
 */
public abstract class AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	/**
	 *@see ResponseContext#init
	 *@param requestContext クライアントからのリクエスト
	 */
	public void init(RequestContext requestContext){
		this.requestContext = requestContext;
	}

	/**
	 *@see ResponseContext#getRequestContext
	 *@return クライアントからのリクエスト
	 */
	public RequestContext getRequestContext(){
		return requestContext;
	}

	/**
	 *@see ResponseContext#execute
	 *@param responseContext 実行結果をラップするための
							 ResponseContextのサブクラスのインスタンス
	 *@return 実行結果をラップしたResponseContextのサブクラスのインスタンス
	 *@exception LogicException ビジネスロジックレイヤで発生した例外のラッパー
	 */
	public abstract ResponseContext execute(ResponseContext responseContext)throws LogicException;
}