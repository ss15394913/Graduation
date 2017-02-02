/*
  @ author ‰F’Ã–ìŒõ
*/

package bean;

import java.io.Serializable;

public class ProductStockBean implements Serializable{
	private String productId;
	private int productStockCount;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getProductStockCount() {
		return productStockCount;
	}
	public void setProductStockCount(int productStockCount) {
		this.productStockCount = productStockCount;
	}
	
}