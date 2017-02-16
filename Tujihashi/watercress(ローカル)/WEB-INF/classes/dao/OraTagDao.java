//Tag表のデータ取得
package dao;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import bean.TagBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

public class OraTagDao implements TagDao {
	/*全てのタグの情報を取得するメソッド*/
	public List getTags() throws IntegrationException{
		
		ArrayList<TagBean> tagList=new ArrayList<TagBean>();
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
			String sql = "SELECT tag_id, tag_name, product_id FROM tag";
			
			/*SQL文を実行し、ResultSetオブジェクトを生成*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECTの結果をBeanに入れる*/
				TagBean tag = new TagBean();
				
				tag.setTagId(Integer.parseInt(result.getString(1)));
				tag.setTagName(result.getString(2));
				tag.setProductId(result.getString(3));
				
				/*ListにBeanを入れる*/
				tagList.add(tag);
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
			
		//Tag表全件を返す。
		return tagList;
		
	}
}