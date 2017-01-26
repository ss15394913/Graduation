package logic;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ex.LogicException;
import command.AbstractCommand;
/**
 *@className FrontServlet
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description HTTP通信用の制御ロジック実行クラス
 */
public class WebApplicationController implements ApplicationController {
	
	/**
	 *@see WebApplicationController#getRequest
	 *@param request クライアントから送られたリクエスト情報
	 *@return リクエスト情報をラップした、RequestContextのサブクラス
	 */
	public RequestContext getRequest(Object request) {
		RequestContext requestContext = new WebRequestContext();
		requestContext.setRequest(request);
		
		return requestContext;
	}
	
	/**
	 *@see WebApplicationController#handleRequest
	 *@param requestContext クライアントからのリクエスト
	 *@return コマンドの実行結果
	 *@exception LogicException ビジネスロジックレイヤで発生した例外のラッパー
	 */
	public ResponseContext handleRequest(RequestContext requestContext)
	throws LogicException {
		AbstractCommand command = CommandFactory.getCommand(requestContext);
		command.init(requestContext);
		
		ResponseContext responseContext
		= command.execute(new WebResponseContext());
		
		return responseContext;
	}
	
	/**
	 *@see WebApplicationController#handleResponse
	 *@param requestContext クライアントからのリクエスト情報
	 *@param responseContext コマンド系クラスの実行結果
	 *@exception ServletException
	 *@exception IOException
	 */
	public void handleResponse(RequestContext requestContext,
							   ResponseContext responseContext)
	throws ServletException, IOException {
		HttpServletRequest req
		= (HttpServletRequest) requestContext.getRequest();
		
		HttpServletResponse res
		= (HttpServletResponse) responseContext.getResponse();

		req.setAttribute("data", responseContext.getResult());
		
		RequestDispatcher requestDispatcher
		= req.getRequestDispatcher(responseContext.getTarget());
		
		requestDispatcher.forward (req, res);
	}
}