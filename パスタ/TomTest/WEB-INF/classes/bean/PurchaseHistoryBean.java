/*
  @ author ‰F’Ã–ìŒõ
*/

package bean;

import java.io.Serializable;

public class PurchaseHistoryBean implements Serializable{
	private int memberId;
	private int purchaseOrderId;
	private String purchaseOrderDate;
    private String purchaseOrderDeliveryStatus;
    private int purchaseOrderDetailId;
    private String productId;
    private int purchaseCount;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}
	public void setPurchaseOrderDate(String purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}
	public String getPurchaseOrderDeliveryStatus() {
		return purchaseOrderDeliveryStatus;
	}
	public void setPurchaseOrderDeliveryStatus(String purchaseOrderDeliveryStatus) {
		this.purchaseOrderDeliveryStatus = purchaseOrderDeliveryStatus;
	}
	public int getPurchaseOrderDetailId() {
		return purchaseOrderDetailId;
	}
	public void setPurchaseOrderDetailId(int purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
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