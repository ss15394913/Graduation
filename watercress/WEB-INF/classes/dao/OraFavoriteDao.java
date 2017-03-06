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

import bean.FavoriteBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

/*お気に入りの情報を取得するために利用するデータアクセスオブジェクト*/
public class OraFavoriteDao implements FavoriteDao {
	/*全てのお気に入りの情報を取得するメソッド*/
	public List getFavorites() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<FavoriteBean> favorites = new ArrayList<FavoriteBean>();

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
			String sql = "select member_id, product_id from favorite";

			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);

			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				FavoriteBean favorite = new FavoriteBean();
				/*BeanにSQLの結果を格納する*/
				favorite.setMemberId(result.getInt(1));
				favorite.setProductId(result.getString(2));
				/*リストにBeanを格納する*/
				favorites.add(favorite);
			}
			/*コミットを行う*/
			connection.commit();
			/*ResultSet、Statement、Connectionをクローズする*/
			result.close();
			statement.close();
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
		return favorites;
	}

	/*引数のBeanの内容の通りに、お気に入りを登録するメソッド*/
	public void addFavorite(FavoriteBean favorite) throws IntegrationException {
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
			String sql = "insert into favorite values(?, ?)";

			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);

			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setInt(1, favorite.getMemberId());
			preparedStatement.setString(2, favorite.getProductId());

			/*SQLを実行する*/
			preparedStatement.executeUpdate();

			/*コミットを行う*/
			connection.commit();
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

	/*引数のBeanの内容に一致するお気に入りを削除するメソッド*/
	public void removeFavorite(FavoriteBean favorite) throws IntegrationException {
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
			String sql = "delete from favorite "
			+ "where member_id = ? and product_id = ?";

			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);

			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setInt(1, favorite.getMemberId());
			preparedStatement.setString(2, favorite.getProductId());

			/*SQLを実行する*/
			preparedStatement.executeUpdate();

			/*コミットを行う*/
			connection.commit();
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