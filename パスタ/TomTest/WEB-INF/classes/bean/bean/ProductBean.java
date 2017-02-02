/*
  @ author ‰F’Ã–ìŒõ
*/

package bean;

import java.io.Serializable;

public class ProductBean implements Serializable{
	private String productId;
	private String productName;
	private int productPrice;
	private String productDescription;
	private int categoryId;
	private int subCategoryId;
	private String productSize;
	private String productColor;
	private String productReleaseDate;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductReleaseDate() {
		return productReleaseDate;
	}
	public void setProductReleaseDate(String productReleaseDate) {
		this.productReleaseDate = productReleaseDate;
	}
	
}