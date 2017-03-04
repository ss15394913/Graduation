//SubCategory表のデータ取得
package dao;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import bean.SubCategoryBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

public class OraSubCategoryDao implements SubCategoryDao {
	/*全てのタグの情報を取得するメソッド*/
	public List getSubCategories() throws IntegrationException{
		
		ArrayList<SubCategoryBean> subCategoryList=new ArrayList<SubCategoryBean>();
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
			String sql = "SELECT sub_category_id, sub_category_name, "+
						"category_id FROM Sub_Category";
			
			/*SQL文を実行し、ResultSetオブジェクトを生成*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECTの結果をBeanに入れる*/
				SubCategoryBean subCategory = new SubCategoryBean();
				
				subCategory.setSubCategoryId(
							Integer.parseInt(result.getString(1)));
				
				subCategory.setSubCategoryName(result.getString(2));
				subCategory.setCategoryId(result.getInt(3));
				
				/*ListにBeanを入れる*/
				subCategoryList.add(subCategory);
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
			
		//SubCategory表全件を返す。
		return subCategoryList;
		
	}
}