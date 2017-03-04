/*
  author 池田大和
*/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ProductStockBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

/*注文明細の情報を取得するために利用するデータアクセスオブジェクト*/
public class OraProductStockDao implements ProductStockDao {
	/*全ての注文明細の情報を取得するメソッド*/
	public List getProductStocks() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<ProductStockBean> productStocks
		= new ArrayList<ProductStockBean>();

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
			String sql = "select product_id, product_stock_count "
			+ "from product_stock";

			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);

			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				ProductStockBean productStock = new ProductStockBean();
				/*BeanにSQLの結果を格納する*/
				productStock.setProductId(result.getString(1));
				productStock.setProductStockCount(result.getInt(2));
				/*リストにBeanを格納する*/
				productStocks.add(productStock);
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
		return productStocks;
	}
	/*引数のBean内の変数productIdと一致する商品の在庫数を、
	  引数のBean内の変数productStockCountと同じ数に変更するメソッド*/
	/*商品の在庫数を変更するメソッド*/
	public void setProductStock(ProductStockBean productStock)
	throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;

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

			/*SQL文を持つ変数の宣言*/
			String sql = "update product_stock set product_stock_count = ? "
			+ "where product_id = ?";

			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);

			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setInt(1, productStock.getProductStockCount());
			preparedStatement.setString(2, productStock.getProductId());

			/*SQLを実行する*/
			preparedStatement.executeUpdate();

			/*PreparedStatement、Connectionをクローズする*/
			preparedStatement.close();
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
				if(preparedStatement != null){
					preparedStatement.close();
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
}