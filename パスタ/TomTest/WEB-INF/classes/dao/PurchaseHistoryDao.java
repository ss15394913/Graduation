/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.PurchaseHistoryBean;
import ex.IntegrationException;

/*購入履歴を取得するために利用するデータアクセスオブジェクト*/
public interface PurchaseHistoryDao {
	/*購入履歴を取得するビューを使用して、購入履歴の情報を取得するメソッド*/
	public List getPurchaseHistories() throws IntegrationException;
}