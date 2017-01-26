//Product表のデータ取得
package dao;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import bean.ProductBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

public class OraProductDao implements ProductDao {
	/*全ての商品の情報を取得するメソッド*/
	public List getProducts() throws IntegrationException{
		
		ArrayList<ProductBean> productList=new ArrayList<ProductBean>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try{
			/*データベースへの接続*/
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*オートコミット機能をOFFにする*/
			connection.setAutoCommit(false);
			
			/*SQL文をDBに送るためのStatementオブジェクトを生成*/
			statement = connection.createStatement();
			
			/*SQL文を記述*/
			String sql = "SELECT product_id, product_name, product_price,"+
							"product_description, category_id, sub_category_id"+
							"product_size, product_color, product_release_date "+
							"FROM product";
			
			/*SQL文を実行し、ResultSetオブジェクトを生成*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECTの結果をBeanに入れる*/
				ProductBean product = new ProductBean();
				
				product.setProductId(result.getString(1));
				product.setProductName(result.getString(2));
				product.setProductPrice(Integer.parseInt(result.getString(3)));
				product.setProductDescription(result.getString(4));
				product.setCategoryId(Integer.parseInt(result.getString(5)));
				product.setSubCategoryId(Integer.parseInt(result.getString(6)));
				product.setProductSize(result.getString(7));
				product.setProductColor(result.getString(8));
				product.setProductReleaseDate(result.getString(9));
				
				/*ListにBeanを入れる*/
				productList.add(product);
			}
			
			
		}catch(SQLException e){
			throw new IllegalSQLException(e.getMessage(), e);
		}finally{
			try{
				if(result != null){
					result.close();
				}
				if(statement != null){
					statement.close();
				}
			}catch(SQLException e){
				throw new IllegalSQLException(e.getMessage(), e);
			}finally{
				try{
					if(connection != null){
						connection.close();
					}
				}catch(SQLException e){
					throw new IllegalSQLException(e.getMessage(), e);
				}
			}
		}
			
		//Product表全件を返す。
		return productList;
		
	}
}