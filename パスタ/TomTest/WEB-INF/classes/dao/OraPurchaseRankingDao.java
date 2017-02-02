package dao;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import bean.PurchaseRankingBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;


public class OraPurchaseRankingDao implements PurchaseRankingDao {
	/*全ての商品の情報を取得するメソッド*/
	public List getPurchaseRanking() throws IntegrationException{
		
		ArrayList<PurchaseRankingBean> rankingList=new ArrayList<PurchaseRankingBean>();
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
			String sql = "SELECT product_name, product_price,"+
						"purchase_count_sum FROM purchase_ranking_view";
			
			/*SQL文を実行し、ResultSetオブジェクトを生成*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECTの結果をBeanに入れる*/
				PurchaseRankingBean ranking = new PurchaseRankingBean();
				
				ranking.setProductName(result.getString(1));
				ranking.setProductPrice(Integer.parseInt(result.getString(2)));
				ranking.setPurchaseCountSum(Integer.parseInt(result.getString(3)));
				
				
				/*ListにBeanを入れる*/
				rankingList.add(ranking);
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
		return rankingList;
		
	}
}