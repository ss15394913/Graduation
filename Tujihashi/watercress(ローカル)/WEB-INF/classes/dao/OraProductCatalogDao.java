/*
  author 池田大和
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ProductCatalogBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*商品一覧画面用の一覧を取得するために利用するデータアクセスオブジェクト*/
public class OraProductCatalogDao implements ProductCatalogDao {
	/*全ての商品一覧画面用の一覧の情報を取得するメソッド*/
	public List getProductCatalogs(int[] sortingRules)
	throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<ProductCatalogBean> productCatalogs
		= new ArrayList<ProductCatalogBean>();
		
		/*データベースへの接続*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*オートコミットを無効にする*/
			connection.setAutoCommit(false);
			
			/*ステートメントを生成する*/
			statement = connection.createStatement();
			
			/*SQL文を持つ変数の宣言*/
			String sql = "select product_name, product_price, "
			+ "category_id, sub_category_id, "
			+ "product_release_date, product_stock_count, "
			+ "example_product_id, product_image_path, "
			+ "purchase_count_sum "
			+ "from product_catalog_view ";
			
			boolean usedOrderby = false;
			
			/*引数の配列の内容に応じて、並び替え条件を追加する*/
			for(int i = 0; i < sortingRules.length; i++){
				/*値段の昇順での並び替えを行う*/
				if(sortingRules[i] == SORT_BY_PRICE_ASC){
					/*orderby句がまだ追加されていないなら、order byを追加する*/
					/*orderby句が既に追加されていたなら、,を追加する*/
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_price ";
				}
				/*値段の降順での並び替えを行う*/
				if(sortingRules[i] == SORT_BY_PRICE_DESC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_price desc ";
				}
				/*購入数の昇順での並び替えを行う*/
				if(sortingRules[i] == SORT_BY_PURCHASE_COUNT_ASC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "purchase_count_sum ";
				}
				/*購入数の降順での並び替えを行う*/
				if(sortingRules[i] == SORT_BY_PURCHASE_COUNT_DESC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "purchase_count_sum desc ";
				}
				/*名前の昇順での並び替えを行う*/
				if(sortingRules[i] == SORT_BY_NAME_ASC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_name ";
				}
				/*名前の降順での並び替えを行う*/
				if(sortingRules[i] == SORT_BY_NAME_DESC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_name desc ";
				}
			}
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				ProductCatalogBean productCatalog = new ProductCatalogBean();
				/*BeanにSQLの結果を格納する*/
				productCatalog.setProductName(result.getString(1));
				productCatalog.setProductPrice(result.getInt(2));
				productCatalog.setCategoryId(result.getInt(3));
				productCatalog.setSubCategoryId(result.getInt(4));
				productCatalog.setProductReleaseDate(result.getString(5));
				productCatalog.setProductStockCount(result.getInt(6));
				productCatalog.setExampleProductId(result.getString(7));
				productCatalog.setProductImagePath(result.getString(8));
				productCatalog.setPurchaseCountSum(result.getInt(9));
				/*リストにBeanを格納する*/
				productCatalogs.add(productCatalog);
			}
			/*コミットを行う*/
			connection.commit();
			/*ResultSet、Statement、Connectionをクローズする*/
			result.close();
			statement.close();
			connection.close();
			/*例外が発生したら、finally句でクローズを行う*/
		}catch(SQLException e){
			try{
				/*ロールバックを行う*/
				connection.rollback();
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(),e2);
			}
			throw new IllegalSQLException(e.getMessage(),e);
		}finally{
			try{
				if(result != null){
					result.close();
				}
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(), e2);
			}finally{
				try{
					if(statement != null){
						statement.close();
					}
				}catch(SQLException e3){
					throw new IllegalSQLException(e3.getMessage(), e3);
				}finally{
					try{
						if(connection != null){
							connection.close();
						}
					}catch(SQLException e4){
						throw new IllegalSQLException(e4.getMessage(), e4);
					}
				}
			}
		}
		/*問い合わせの結果を格納するBeanを格納するリストを返す*/
		return productCatalogs;
	}
	
	/*上記メソッドのオーバーロード。上記のメソッドを呼び出す*/
	public List getProductCatalogs(int sortingRule)
	throws IntegrationException {
		/*引数のint型変数の値を、int配列型変数に入れる*/
		int sortingRules[];
		sortingRules = new int[1];
		sortingRules[0] = sortingRule;
		/*上記のメソッドを呼び出し、その戻り値を返す*/
		return getProductCatalogs(sortingRules);
	}
	
	/*上記メソッドのオーバーロード。上記のメソッドを呼び出す*/
	public List getProductCatalogs()
	throws IntegrationException {
		/*空のint配列型変数を作る*/
		int sortingRules[];
		sortingRules = new int[0];
		/*上記のメソッドを呼び出し、その戻り値を返す*/
		return getProductCatalogs(sortingRules);
	}
}