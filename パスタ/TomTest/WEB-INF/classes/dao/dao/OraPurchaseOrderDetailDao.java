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

import bean.PurchaseOrderDetailBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*注文明細の情報を取得するために利用するデータアクセスオブジェクト*/
public class OraPurchaseOrderDetailDao implements PurchaseOrderDetailDao {
	/*全ての注文明細の情報を取得するメソッド*/
	public List getPurchaseOrderDetails() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<PurchaseOrderDetailBean> purchaseOrderDetails
		= new ArrayList<PurchaseOrderDetailBean>();
		
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
			String sql = "select purchase_order_detail_id, purchase_order_id, "
			+ "product_id, purchase_count "
			+ "from purchase_order_detail";
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				PurchaseOrderDetailBean purchaseOrderDetail
				= new PurchaseOrderDetailBean();
				/*BeanにSQLの結果を格納する*/
				purchaseOrderDetail.setPurchaseOrderDetailId(result.getInt(1));
				purchaseOrderDetail.setPurchaseOrderId(result.getInt(2));
				purchaseOrderDetail.setProductId(result.getString(3));
				purchaseOrderDetail.setPurchaseCount(result.getInt(4));
				/*リストにBeanを格納する*/
				purchaseOrderDetails.add(purchaseOrderDetail);
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
		return purchaseOrderDetails;
	}
	/*注文明細を登録するメソッド*/
	public void setPurchaseOrderDetail(
		PurchaseOrderDetailBean purchaseOrderDetail)
	throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
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
			String sql = "insert into purchase_order_detail "
			+ "values(purchase_order_detail_id_seq.NEXTVAL, ?, ?, ?)";
			
			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setInt(
				1, purchaseOrderDetail.getPurchaseOrderId());
			preparedStatement.setString(
				2, purchaseOrderDetail.getProductId());
			preparedStatement.setInt(
				3, purchaseOrderDetail.getPurchaseCount());
			
			/*SQLを実行する*/
			preparedStatement.executeUpdate();
			
			/*ResultSet、PreparedStatement、Connectionをクローズする*/
			result.close();
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
				if(result != null){
					result.close();
				}
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(), e2);
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
}