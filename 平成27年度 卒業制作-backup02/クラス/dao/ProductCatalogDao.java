/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.ProductStockBean;
import ex.IntegrationException;

/*商品一覧画面用の一覧を取得するために利用するデータアクセスオブジェクト*/
public interface ProductCatalogDao {
	/*商品の並び順を指定するための定数*/
	public static final int SORT_BY_PRICE_ASC = 1;
	public static final int SORT_BY_PRICE_DESC = 2;
	public static final int SORT_BY_PURCHASE_COUNT_ASC = 3;
	public static final int SORT_BY_PURCHASE_COUNT_DESC = 4;
	public static final int SORT_BY_NAME_ASC = 5;
	public static final int SORT_BY_NAME_DESC = 6;
	/*全ての商品の情報を取得するメソッド。引数によって並び替えを制御する*/
	public List getProductCatalogs(int[] sortingRules) 
	throws IntegrationException;
	/*上記メソッドのオーバーロード。上記のメソッドを呼び出す*/
	public List getProductCatalogs(int sortingRule)
	throws IntegrationException;
	/*上記メソッドのオーバーロード。上記のメソッドを呼び出す*/
	public List getProductCatalogs()
	throws IntegrationException;
}