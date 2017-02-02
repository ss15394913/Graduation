/*
  @author 池田大和
*/
package dao;

import java.util.List;
import bean.ProductBean;
import ex.IntegrationException;

/*商品の情報を取得するために利用するデータアクセスオブジェクト*/
public interface ProductDao {
	/*全ての商品の情報を取得するメソッド*/
	public List getProducts() throws IntegrationException;
}