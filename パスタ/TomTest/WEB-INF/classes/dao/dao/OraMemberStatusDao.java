//MemberStatus�\�̃f�[�^�擾
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
	/*�S�Ẵ����o�[�X�e�[�^�X�̏����擾���郁�\�b�h*/
	public List getMemberStatuses() throws IntegrationException{
		
		ArrayList<MemberStatusBean> memberStatusList=new ArrayList<MemberStatusBean>();
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
			String sql = "SELECT member_status_id,member_status_name "+
							"FROM member_status";
			
			/*SQL�������s���AResultSet�I�u�W�F�N�g�𐶐�*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECT�̌��ʂ�Bean�ɓ����*/
				MemberStatusBean status = new MemberStatusBean();
				
				status.setMemberStatusId(Integer.parseInt(result.getString(1)));
				status.setMemberStatusName(result.getString(2));
				
				/*List��Bean������*/
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
			
		//MemberStatus�\�S����Ԃ��B
		return memberStatusList;
		
	}
}