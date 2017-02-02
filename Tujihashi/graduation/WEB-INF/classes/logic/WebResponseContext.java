package logic;

import javax.servlet.http.HttpServletResponse;

/**
 *@className WebResponseContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description HTTP通信の際のレスポンス情報のラッパークラス
 */
public class WebResponseContext implements ResponseContext {
	/**コマンドの実行結果*/
	private Object result;
	/**転送先のURL*/
	private String target;
	/**HTTPServletでのレスポンス情報*/
	private HttpServletResponse response;
	
	/**
	 *@see WebResponseContext#WebResponseContext
	 *@return 自身を表すインスタンス
	 */	
	public WebResponseContext() {}
	
	/**
	 *@see WebResponseContext#setTarget
	 *@param transferinfo 転送先のjspファイルの拡張子を除いたファイル名
	 */
	public void setTarget(String transferInfo) {
		target = "/WEB-INF/jsp/" + transferInfo + ".jsp";
	}
	
	/**
	 *@see WebResponseContext#getTarget
	 *@return 転送先のURL情報
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 *@see WebResponseContext#setResult
	 *@param bean コマンドの実行結果を返すためのbean
	 */
	public void setResult(Object bean) {
		result = bean;
	}
	
	/**
	 *@see WebResponseContext#getResult
	 *@return コマンドの実行結果
	 */
	public Object getResult() {
		return result;
	}
	
	/**
	 *@see WebResponseContext#getResponse
	 *@return レスポンス情報
	 */
	public Object getResponse() {
		return response;
	}
	
	/**
	 *@see WebResponseContext#setResponse
	 *@param object レスポンスの際に必要な情報
	 */
	public void setResponse(Object response){
		this.response = (HttpServletResponse) response;
	}
}