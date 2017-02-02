//MemberStatus表のデータ取得
package dao;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import bean.MemberStatusBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

public class OraMemberStatusDao implements MemberStatusDao {
	/*全てのメンバーステータスの情報を取得するメソッド*/
	public List getMemberStatuses() throws IntegrationException{
		
		ArrayList<MemberStatusBean> memberStatusList=new ArrayList<MemberStatusBean>();
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
			String sql = "SELECT member_status_id,member_status_name "+
							"FROM member_status";
			
			/*SQL文を実行し、ResultSetオブジェクトを生成*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECTの結果をBeanに入れる*/
				MemberStatusBean status = new MemberStatusBean();
				
				status.setMemberStatusId(Integer.parseInt(result.getString(1)));
				status.setMemberStatusName(result.getString(2));
				
				/*ListにBeanを入れる*/
				memberStatusList.add(status);
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
			
		//MemberStatus表全件を返す。
		return memberStatusList;
		
	}
}