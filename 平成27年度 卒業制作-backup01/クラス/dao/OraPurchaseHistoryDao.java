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

import bean.PurchaseHistoryBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*購入履歴の情報を取得するために利用するデータアクセスオブジェクト*/
public class OraPurchaseHistoryDao implements PurchaseHistoryDao {
	/*全ての購入履歴の情報を取得するメソッド*/
	public List getPurchaseHistories() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<PurchaseHistoryBean> purchaseHistories
		= new ArrayList<PurchaseHistoryBean>();
		
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
			= "select member_id, purchase_order_id, purchase_order_date, "
			+ "purchase_order_delivery_status, purchase_order_detail_id, "
			+ "product_id, purchase_count "
			+ "from purchase_order join purchase_order_detail "
			+ "using(purchase_order_id) "
			+ "order by purchase_order_date desc";
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				PurchaseHistoryBean purchaseHistory
				= new PurchaseHistoryBean();
				/*BeanにSQLの結果を格納する*/
				purchaseHistory.setMemberId(result.getInt(1));
				purchaseHistory.setPurchaseOrderId(result.getInt(2));
				purchaseHistory.setPurchaseOrderDate(result.getString(3));
				purchaseHistory.setPurchaseOrderDeliveryStatus(
					result.getString(4));
				purchaseHistory.setPurchaseOrderDetailId(result.getInt(5));
				purchaseHistory.setProductId(result.getString(6));
				purchaseHistory.setPurchaseCount(result.getInt(3));
				/*リストにBeanを格納する*/
				purchaseHistories.add(purchaseHistory);
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
		return purchaseHistories;
	}
	
}