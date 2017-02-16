/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.ProductImageBean;
import ex.IntegrationException;

/*商品画像の情報を取得するために利用するデータアクセスオブジェクト*/
public interface ProductImageDao {
	/*全ての商品画像の情報を取得するメソッド*/
	public List getProductImages() throws IntegrationException;
}