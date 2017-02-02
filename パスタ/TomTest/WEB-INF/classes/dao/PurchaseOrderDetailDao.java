/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.PurchaseOrderDetailBean;
import ex.IntegrationException;

/*注文明細の情報を取得するために利用するデータアクセスオブジェクト*/
public interface PurchaseOrderDetailDao {
	/*全ての注文明細の情報を取得するメソッド*/
	public List getPurchaseOrderDetails() throws IntegrationException;
	/*注文明細を登録するメソッド*/
	public void setPurchaseOrderDetail(
		PurchaseOrderDetailBean purchaseOrderDetail)
	throws IntegrationException;
}