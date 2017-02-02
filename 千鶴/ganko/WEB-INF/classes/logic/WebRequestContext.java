package logic;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *@className WebRequestContext
 *@author Fumihiro Miyazaki
 *@date 2017/02/01
 *@description HTTP通信のリクエスト情報をラップするクラス
 */
public class WebRequestContext implements RequestContext {
	/**サーブレットパスを、コマンド生成用の文字列に変換するための定数*/
	private static final int REMOVE_SLASH = 1;
	/**リクエストに含まれる各パラメータ*/
	private Map parameters;
	/**HTTPServletでのリクエスト情報*/
	private HttpServletRequest request;
	/**HTTPServletでのセッション情報*/
	private HttpSession session;
	
	/**
	 *@see WebRequestContext#WebRequestContext
	 *@return 自身を表すインスタンス
	 */	
	public WebRequestContext() {}
	
	/**
	 *@see WebRequestContext#getCommandPath
	 *@return 実行するコマンドのパス情報を返す
	 */
	public String getCommandPath() {
		String servletPath = request.getServletPath();
		
		String commandPath = servletPath.substring(REMOVE_SLASH);
		
		return commandPath;
	}
	
	/**
	 *@see WebRequestContext#getParameter
	 *@param key クライアントからのリクエストのパラメータに対応したキー値
	 *@return キー値に対応したパラメータ
	 */
	public String[] getParameter(String key) {
		return (String[]) parameters.get(key);
	}
	
	/**
	 *@see WebRequestContext#getRequest
	 *@return クライアントからのリクエスト情報
	 */
	public Object getRequest() {
		return request;
	}
	
	/**
	 *@see WebRequestContext#setRequest
	 *@param request クライアントからのリクエスト情報
	 */
	public void setRequest(Object request) {
		this.request = (HttpServletRequest)request;
		
		session = this.request.getSession();
		
		parameters = this.request.getParameterMap();
	}
	
	/**
	 *@see WebRequestContext#setSessionAttribute
	 *@param key セッションスコープに登録したい値に、対応したキー値
	 *@param value セッションスコープに登録したい値
	 */
	public void setSessionAttribute(String key, Object value) {
		session.setAttribute(key, value);
	}

	/**
	 *@see WebRequestContext#getSessionAttribute
	 *@return セッションに登録されている、キー値に対応した値
	 */
	public Object getSessionAttribute(String key) {
		return session.getAttribute(key);
	}
}