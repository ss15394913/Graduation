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
	/*�S�Ă̏��i�̏����擾���郁�\�b�h*/
	public List getPurchaseRanking() throws IntegrationException{
		
		ArrayList<PurchaseRankingBean> rankingList=new ArrayList<PurchaseRankingBean>();
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
			String sql = "SELECT product_name, product_price,"+
						"purchase_count_sum FROM purchase_ranking_view";
			
			/*SQL�������s���AResultSet�I�u�W�F�N�g�𐶐�*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECT�̌��ʂ�Bean�ɓ����*/
				PurchaseRankingBean ranking = new PurchaseRankingBean();
				
				ranking.setProductName(result.getString(1));
				ranking.setProductPrice(Integer.parseInt(result.getString(2)));
				ranking.setPurchaseCountSum(Integer.parseInt(result.getString(3)));
				
				
				/*List��Bean������*/
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
			
		//Product�\�S����Ԃ��B
		return rankingList;
		
	}
}