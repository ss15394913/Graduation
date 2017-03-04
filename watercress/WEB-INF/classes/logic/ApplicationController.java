package logic;

import java.io.IOException;

import javax.servlet.ServletException;

import ex.LogicException;
/**
 *@className ApplicationControllerFactory
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description 制御ロジックを実行するクラスのインターフェース
 */
public interface ApplicationController {
	/**
	 *@see ApplicationController#getRequest
	 *@param request クライアントから送られたリクエスト情報
	 *@return リクエスト情報をラップした、RequestContextのサブクラス
	 */
	RequestContext getRequest(Object request);

	/**
	 *@see ApplicationController#handleRequest
	 *@param requestContext クライアントからのリクエスト
	 *@return コマンドの実行結果
	 *@exception LogicException ビジネスロジックレイヤで発生した例外のラッパー
	 */
	ResponseContext handleRequest (RequestContext requestContext)
	throws LogicException;

	/**
	 *@see ApplicationController#handleResponse
	 *@param requestContext クライアントからのリクエスト情報
	 *@param responseContext コマンド系クラスの実行結果
	 *@exception ServletException
	 *@exception IOException
	 */
	void handleResponse(RequestContext requestContext,
						ResponseContext responseContext)
	throws ServletException, IOException;
}