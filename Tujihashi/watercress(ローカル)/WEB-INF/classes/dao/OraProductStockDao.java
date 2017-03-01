/*
  author �r�c��a
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

import bean.ProductStockBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*�������ׂ̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraProductStockDao implements ProductStockDao {
	/*�S�Ă̒������ׂ̏����擾���郁�\�b�h*/
	public List getProductStocks() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<ProductStockBean> productStocks
		= new ArrayList<ProductStockBean>();
		
		/*�f�[�^�x�[�X�ւ̐ڑ�*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*�I�[�g�R�~�b�g�𖳌��ɂ���*/
			connection.setAutoCommit(false);
			
			/*�X�e�[�g�����g�𐶐�����*/
			statement = connection.createStatement();
			
			/*SQL�������ϐ��̐錾*/
			String sql = "select product_id, product_stock_count "
			+ "from product_stock";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				ProductStockBean productStock = new ProductStockBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				productStock.setProductId(result.getString(1));
				productStock.setProductStockCount(result.getInt(2));
				/*���X�g��Bean���i�[����*/
				productStocks.add(productStock);
			}
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
			result.close();
			statement.close();
			connection.close();
			/*��O������������Afinally��ŃN���[�Y���s��*/
		}catch(SQLException e){
			try{
				/*���[���o�b�N���s��*/
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
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g��Ԃ�*/
		return productStocks;
	}
	/*������Bean���̕ϐ�productId�ƈ�v���鏤�i�̍݌ɐ����A
	  ������Bean���̕ϐ�productStockCount�Ɠ������ɕύX���郁�\�b�h*/
	/*���i�̍݌ɐ���ύX���郁�\�b�h*/
	public void setProductStock(ProductStockBean productStock)
	throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*�f�[�^�x�[�X�ւ̐ڑ�*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*�I�[�g�R�~�b�g�𖳌��ɂ���*/
			connection.setAutoCommit(false);
			
			/*SQL�������ϐ��̐錾*/
			String sql = "update product_stock set product_stock_count = ? "
			+ "where product_id = ?";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
			preparedStatement.setInt(1, productStock.getProductStockCount());
			preparedStatement.setString(2, productStock.getProductId());
			
			/*SQL�����s����*/
			preparedStatement.executeUpdate();
			
			/*ResultSet�APreparedStatement�AConnection���N���[�Y����*/
			result.close();
			preparedStatement.close();
			connection.close();
			
			/*��O������������Afinally��ŃN���[�Y���s��*/
		}catch(SQLException e){
			try{
				/*���[���o�b�N���s��*/
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
	}
}