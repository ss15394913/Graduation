/*
  @ author ‰F’Ã–ìŒõ
*/

package bean;

import java.io.Serializable;

public class PurchaseOrderDetailBean implements Serializable{
	private int purchaseOrderDetailId;
	private int purchaseOrderId;
	private String productId;
	private int purchaseCount;
	
	public int getPurchaseOrderDetailId() {
		return purchaseOrderDetailId;
	}
	public void setPurchaseOrderDetailId(int purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
	}
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
}