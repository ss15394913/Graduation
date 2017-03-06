package logic;

/**
 *@className RequestContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description リクエストに関するクラスのラッパークラス
 */
public interface RequestContext {

	/**
	 *@see RequestContext#getCommandPath
	 *@return 実行するコマンドのパス情報を返す
	 */
	public String getCommandPath();

	/**
	 *@see RequestContext#getParameter
	 *@param key クライアントからのリクエストのパラメータに対応したキー値
	 *@return キー値に対応したパラメータ
	 */
	public String[] getParameter(String key);

	/**
	 *@see RequestContext#getRequest
	 *@return クライアントからのリクエスト情報
	 */
	public Object getRequest();

	/**
	 *@see RequestContext#setRequest
	 *@param request クライアントからのリクエスト情報
	 */
	public void setRequest(Object request);

	/**
	 *@see WebRequestContext#setRequestAttribute
	 *@param key リクエストスコープに登録したい値に対応したキー値
	 *@param value リクエストスコープに登録したい値
	 */
	public void setRequestAttribute(String key, Object value);

	/**
	 *@see WebRequestContext#getRequestAttribute
	 *@return リクエストスコープに登録されている、キー値に対応した値
	 */
	public Object getRequestAttribute(String key);


	/**
	 *@see WebRequestContext#setSessionAttribute
	 *@param key セッションスコープに登録したい値に対応したキー値
	 *@param value セッションスコープに登録したい値
	 */
	public void setSessionAttribute(String key, Object value);

	/**
	 *@see WebRequestContext#getSessionAttribute
	 *@return セッションスコープに登録されている、キー値に対応した値
	 */
	public Object getSessionAttribute(String key);

	/**
	 *@see WebRequestContext#removeSessionAttribute
	 *@param key セッションスコープに登録されている値に対応したキー値
	 */
	public void removeSessionAttribute(String key);
}