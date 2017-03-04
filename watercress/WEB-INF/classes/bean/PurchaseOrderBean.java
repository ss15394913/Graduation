/*
  @ author ‰F’Ã–ìŒõ
  ’r“c‘å˜a purchaseOrderPaymentMethod‚ð’Ç‰Á‚µ‚Ü‚µ‚½
*/


package bean;

import java.io.Serializable;

public class PurchaseOrderBean implements Serializable{
	private int purchaseOrderId;
	private String purchaseOrderDate;
	private String purchaseOrderDeliveryStatus;
	private int memberId;
	private String purchaseOrderPaymentMethod;

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
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getPurchaseOrderPaymentMethod() {
		return purchaseOrderPaymentMethod;
	}
	public void setPurchaseOrderPaymentMethod(String purchaseOrderPaymentMethod) {
		this.purchaseOrderPaymentMethod = purchaseOrderPaymentMethod;
	}

}