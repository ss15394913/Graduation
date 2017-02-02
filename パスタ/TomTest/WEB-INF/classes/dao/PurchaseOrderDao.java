/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.PurchaseOrderBean;
import ex.IntegrationException;
 
/*注文の情報を取得するために利用するデータアクセスオブジェクト*/
public interface PurchaseOrderDao  {
	/*全ての注文の情報を取得するメソッド*/
	public List getPurchaseOrders() throws IntegrationException;
	/*注文の情報を登録するメソッド。戻り値は、順序から生成された注文ID*/
	public int setPurchaseOrder(PurchaseOrderBean purchaseOrder)
	throws IntegrationException;
}