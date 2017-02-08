/*
  @ author ‰F’Ã–ìŒõ
*/

package bean;

import java.io.Serializable;

public class PurchaseRankingBean implements Serializable{
	private String productName;
	private int productPrice;
	private int purchaseCountSum;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getPurchaseCountSum() {
		return purchaseCountSum;
	}
	public void setPurchaseCountSum(int purchaseCountSum) {
		this.purchaseCountSum = purchaseCountSum;
	}


}