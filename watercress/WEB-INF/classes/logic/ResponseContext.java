package logic;

/**
 *@className ResponseContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description レスポンスに関するクラスのラッパークラス
 */
public interface ResponseContext {

	/**
	 *@see ResponseContext#getResult
	 *@return コマンドの実行結果
	 */
	public Object getResult();

	/**
	 *@see ResponseContext#getTarget
	 *@return 転送先のURL情報
	 */
	public String getTarget();

	/**
	 *@see ResponseContext#setResult
	 *@param bean コマンドの実行結果を返すためのbean
	 */
	public void setResult(Object bean);

	/**
	 *@see ResponseContext#setTarget
	 *@param transferinfo 転送先のjspファイルの拡張子を除いたファイル名
	 */
	public void setTarget(String transferInfo);

	/**
	 *@see ResponseContext#setResponse
	 *@param object レスポンスの際に必要な情報
	 */
	public void setResponse(Object object);

	/**
	 *@see ResponseContext#getResponse
	 *@return レスポンス情報
	 */
	public Object getResponse();
}