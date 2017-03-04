//SubCategory�\�̃f�[�^�擾
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
	/*�S�Ẵ^�O�̏����擾���郁�\�b�h*/
	public List getSubCategories() throws IntegrationException{
		
		ArrayList<SubCategoryBean> subCategoryList=new ArrayList<SubCategoryBean>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try{
			/*�f�[�^�x�[�X�ւ̐ڑ�*/
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*�I�[�g�R�~�b�g�@�\��OFF�ɂ���*/
			connection.setAutoCommit(false);
			
			/*SQL����DB�ɑ��邽�߂�Statement�I�u�W�F�N�g�𐶐�*/
			statement = connection.createStatement();
			
			/*SQL�����L�q*/
			String sql = "SELECT sub_category_id, sub_category_name, "+
						"category_id FROM Sub_Category";
			
			/*SQL�������s���AResultSet�I�u�W�F�N�g�𐶐�*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECT�̌��ʂ�Bean�ɓ����*/
				SubCategoryBean subCategory = new SubCategoryBean();
				
				subCategory.setSubCategoryId(
							Integer.parseInt(result.getString(1)));
				
				subCategory.setSubCategoryName(result.getString(2));
				subCategory.setCategoryId(result.getInt(3));
				
				/*List��Bean������*/
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
			
		//SubCategory�\�S����Ԃ��B
		return subCategoryList;
		
	}
}