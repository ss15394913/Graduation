/*
  author ’r“c‘å˜a
*/
package dao;
public class OraDaoFactory extends AbstractDaoFactory{
	public CategoryDao getCategoryDao(){
		return new OraCategoryDao();
	}
	public FavoriteDao getFavoriteDao(){
		return new OraFavoriteDao();
	}
	public MemberDao getMemberDao(){
		return new OraMemberDao();
	}
	public MemberStatusDao getMemberStatusDao(){
		return new OraMemberStatusDao();
	}
	public ProductCatalogDao getProductCatalogDao(){
		return new OraProductCatalogDao();
	}
	public ProductDao getProductDao(){
		return new OraProductDao();
	}
	public ProductImageDao getProductImageDao(){
		return new OraProductImageDao();
	}
	public ProductInformationDao getProductInformationDao(){
		return new OraProductInformationDao();
	}
	public ProductStockDao getProductStockDao(){
		return new OraProductStockDao();
	}
	public PurchaseHistoryDao getPurchaseHistoryDao(){
		return new OraPurchaseHistoryDao();
	}
	public PurchaseOrderDao getPurchaseOrderDao(){
		return new OraPurchaseOrderDao();
	}
	public PurchaseOrderDetailDao getPurchaseOrderDetailDao(){
		return new OraPurchaseOrderDetailDao();
	}
	public PurchaseRankingDao getPurchaseRankingDao(){
		return new OraPurchaseRankingDao();
	}
	public SubCategoryDao getSubCategoryDao(){
		return new OraSubCategoryDao();
	}
	public TagDao getTagDao(){
		return new OraTagDao();
	}
}