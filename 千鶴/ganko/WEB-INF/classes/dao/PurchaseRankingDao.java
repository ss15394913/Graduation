/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.PurchaseRankingBean;
import ex.IntegrationException;

/*購入数で並び替えた商品一覧を取得するために利用するデータアクセスオブジェクト*/
public interface PurchaseRankingDao{
	/*購入数で並び替えた商品一覧を取得するビューを使用して、
	  商品の情報を取得するメソッド*/
	public List getPurchaseRanking() throws IntegrationException;
}