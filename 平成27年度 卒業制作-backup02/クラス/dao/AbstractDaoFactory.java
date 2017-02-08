/*
  @ author ’r“c‘å˜a
*/
package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import ex.IntegrationException;

public abstract class AbstractDaoFactory{
	public static AbstractDaoFactory getFactory() 
	throws IntegrationException{
		AbstractDaoFactory factory = null;
		Properties prop = new Properties();
		try{prop.load(new FileInputStream("c:/kari/database.properties"));
			String name = prop.getProperty("dao");
			Class c = Class.forName(name);
			factory = (AbstractDaoFactory)c.newInstance();
		}catch(FileNotFoundException e){
			throw new IntegrationException(e.getMessage(),e);
		}catch(IOException e){
			throw new IntegrationException(e.getMessage(),e);
		}catch(ClassNotFoundException e){
			throw new IntegrationException(e.getMessage(),e);
		}catch(InstantiationException e){
			throw new IntegrationException(e.getMessage(),e);
		}catch(IllegalAccessException e){
			throw new IntegrationException(e.getMessage(),e);
		}
		
		return factory;
	}
	
	public abstract CategoryDao getCategoryDao();
	public abstract FavoriteDao getFavoriteDao();
	public abstract MemberDao getMemberDao();
	public abstract MemberStatusDao getMemberStatusDao();
	public abstract ProductCatalogDao getProductCatalogDao();
	public abstract ProductDao getProductDao();
	public abstract ProductImageDao getProductImageDao();
	public abstract ProductInformationDao getProductInformationDao();
	public abstract ProductStockDao getProductStockDao();
	public abstract PurchaseHistoryDao getPurchaseHistoryDao();
	public abstract PurchaseOrderDao getPurchaseOrderDao();
	public abstract PurchaseOrderDetailDao getPurchaseOrderDetailDao();
	public abstract PurchaseRankingDao getPurchaseRankingDao();
	public abstract SubCategoryDao getSubCategoryDao();
	public abstract TagDao getTagDao();
}