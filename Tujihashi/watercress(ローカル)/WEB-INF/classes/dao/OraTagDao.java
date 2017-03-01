//Tag�\�̃f�[�^�擾
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
	/*�S�Ẵ^�O�̏����擾���郁�\�b�h*/
	public List getTags() throws IntegrationException{
		
		ArrayList<TagBean> tagList=new ArrayList<TagBean>();
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
			String sql = "SELECT tag_id, tag_name, product_id FROM tag";
			
			/*SQL�������s���AResultSet�I�u�W�F�N�g�𐶐�*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECT�̌��ʂ�Bean�ɓ����*/
				TagBean tag = new TagBean();
				
				tag.setTagId(Integer.parseInt(result.getString(1)));
				tag.setTagName(result.getString(2));
				tag.setProductId(result.getString(3));
				
				/*List��Bean������*/
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
			
		//Tag�\�S����Ԃ��B
		return tagList;
		
	}
}