package logic;

/**
 *@className RequestContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/25
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
}