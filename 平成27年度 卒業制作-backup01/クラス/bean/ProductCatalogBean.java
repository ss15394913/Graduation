/*
  @ author ’r“c‘å˜a
*/

package bean;

import java.io.Serializable;

public class ProductCatalogBean implements Serializable{
	
	
	private String productName;
	private int productPrice;
    private int categoryId;
    private int subCategoryId;
    private String productReleaseDate;
    private int productStockCount;
    private String exampleProductId;
    private String productImagePath;
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
	public String getProductReleaseDate() {
		return productReleaseDate;
	}
	public void setProductReleaseDate(String productReleaseDate) {
		this.productReleaseDate = productReleaseDate;
	}
	public int getProductStockCount() {
		return productStockCount;
	}
	public void setProductStockCount(int productStockCount) {
		this.productStockCount = productStockCount;
	}
	public String getExampleProductId() {
		return exampleProductId;
	}
	public void setExampleProductId(String exampleProductId) {
		this.exampleProductId = exampleProductId;
	}
	public String getProductImagePath() {
		return productImagePath;
	}
	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}
	public int getPurchaseCountSum() {
		return purchaseCountSum;
	}
	public void setPurchaseCountSum(int purchaseCountSum) {
		this.purchaseCountSum = purchaseCountSum;
	}

}