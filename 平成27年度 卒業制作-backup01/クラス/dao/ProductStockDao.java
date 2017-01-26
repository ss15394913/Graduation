/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.ProductStockBean;
import ex.IntegrationException;

/*商品の在庫数を取得するために利用するデータアクセスオブジェクト*/
public interface ProductStockDao {
	/*全ての商品の在庫数を取得するメソッド*/
	public List getProductStocks() throws IntegrationException;
	/*引数のBean内の変数productIdと一致する商品の在庫数を、
	  引数のBean内の変数productStockCountと同じ数に変更するメソッド*/
	/*商品の在庫数を変更するメソッド*/
	public void setProductStock(ProductStockBean productStockBean) 
	throws IntegrationException;
}