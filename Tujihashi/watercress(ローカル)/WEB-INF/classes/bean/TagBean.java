/*
  @ author ‰F’Ã–ìŒõ
*/

package bean;

import java.io.Serializable;

public class TagBean implements Serializable{

	private int tagId;
	private String tagName;
	private String productId;

	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
