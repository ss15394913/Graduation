/*
  @author 池田大和
*/
package dao;

import java.util.List;
import bean.ProductInformationBean;
import ex.IntegrationException;

/*商品の情報(在庫数含む)を取得するために利用するデータアクセスオブジェクト*/
public interface ProductInformationDao {
	/*発売日で並び替えた、全ての商品の情報(在庫数含む)を取得するメソッド*/
	public List getProductInformations() throws IntegrationException;
}