//Product表のデータ取得
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ProductInformationBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

public class OraProductInformationDao implements ProductInformationDao {
	/*全ての商品の情報を取得するメソッド*/
	public List getProductInformations() throws IntegrationException{

		ArrayList<ProductInformationBean> infoList =
							new ArrayList<ProductInformationBean>();
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
			String sql = "select product_id, product_name, product_price, "+
							"product_description, category_id,"+
							"sub_category_id, product_size, product_color,"+
       						"product_release_date, product_stock_count "+
							"FROM product_information_view " +
							"ORDER BY product_release_date DESC";

			/*SQL文を実行し、ResultSetオブジェクトを生成*/
			result = statement.executeQuery(sql);

			while(result.next()){
				/*SELECTの結果をBeanに入れる*/
				ProductInformationBean info = new ProductInformationBean();

				info.setProductId(result.getString(1));
				info.setProductName(result.getString(2));
				info.setProductPrice(result.getInt(3));
				info.setProductDescription(result.getString(4));
				info.setCategoryId(result.getInt(5));
				info.setSubCategoryId(result.getInt(6));
				info.setProductSize(result.getString(7));
				info.setProductColor(result.getString(8));
				info.setProductReleaseDate(result.getString(9));
				info.setProductStockCount(result.getInt(10));

				/*ListにBeanを入れる*/
				infoList.add(info);
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
		return infoList;

	}
}