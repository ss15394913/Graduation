/*
  author 池田大和
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ProductImageBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*商品画像の情報を取得するために利用するデータアクセスオブジェクト*/
public class OraProductImageDao implements ProductImageDao {
	/*全ての商品画像の情報を取得するメソッド*/
	public List getProductImages() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<ProductImageBean> productImages
		= new ArrayList<ProductImageBean>();
		
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
			String sql
			= "select product_image_id, product_image_path, product_id " 
			+ "from product_image";
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				ProductImageBean productImage = new ProductImageBean();
				/*BeanにSQLの結果を格納する*/
				productImage.setProductImageId(result.getInt(1));
				productImage.setProductImagePath(result.getString(2));
				productImage.setProductId(result.getString(3));
				/*リストにBeanを格納する*/
				productImages.add(productImage);
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
		return productImages;
	}
}