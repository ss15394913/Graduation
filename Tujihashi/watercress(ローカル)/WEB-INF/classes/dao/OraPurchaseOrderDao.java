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

import bean.PurchaseOrderBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*注文の情報を取得するために利用するデータアクセスオブジェクト*/
public class OraPurchaseOrderDao implements PurchaseOrderDao {
	/*全ての注文の情報を取得するメソッド*/
	public List getPurchaseOrders() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<PurchaseOrderBean> purchaseOrders
		= new ArrayList<PurchaseOrderBean>();
		
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
			String sql = "select purchase_order_id, purchase_order_date, "
			+ "purchase_order_delivery_status, member_id, "
			+ "purchase_order_payment_method from purchase_order";
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				PurchaseOrderBean purchaseOrder = new PurchaseOrderBean();
				/*BeanにSQLの結果を格納する*/
				purchaseOrder.setPurchaseOrderId(result.getInt(1));
				purchaseOrder.setPurchaseOrderDate(result.getString(2));
				purchaseOrder.setPurchaseOrderDeliveryStatus(
					result.getString(3));
				purchaseOrder.setMemberId(result.getInt(4));
				purchaseOrder.setPurchaseOrderPaymentMethod(
					result.getString(5));
				/*リストにBeanを格納する*/
				purchaseOrders.add(purchaseOrder);
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
		return purchaseOrders;
	}
	
	/*注文明細を登録するには、その注文の注文IDを知る必要がある。
	  これを注文表の全件問合せから知るには手間がかかるので、
	  このメソッドの戻り値を順序から生成された注文IDにして、効率化を図った。*/
	/*注文の情報を登録するメソッド。戻り値は、順序から生成された注文ID。*/
	public int setPurchaseOrder(PurchaseOrderBean purchaseOrder)
	throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*戻り値となる、順序から生成された注文IDを格納する変数の宣言*/
		int currentId;
		
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
			String sql = "insert into purchase_order "
			+ "values(purchase_order_id_seq.NEXTVAL, SYSDATE, "
			+ "'発送中', ?, ?)";
			
			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setInt(1, purchaseOrder.getMemberId());
			preparedStatement.setString(
				2, purchaseOrder.getPurchaseOrderPaymentMethod());
			
			/*SQLを実行する*/
			preparedStatement.executeUpdate();
			
			/*PreparedStatementをクローズする*/
			preparedStatement.close();
			
			/*順序から生成された値を確認するため、続けて問合せを行う*/
			sql = "select purchase_order_id_seq.CURRVAL from dual";
			
			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = preparedStatement.executeQuery(sql);
			
			/*順序の現在の値が格納されている行を参照する*/
			result.next();
			
			/*順序の現在の値を取得し、変数に格納する*/
			currentId = result.getInt(1);
			
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
		/*順序から生成された注文IDを返す*/
		return currentId;
	}
}