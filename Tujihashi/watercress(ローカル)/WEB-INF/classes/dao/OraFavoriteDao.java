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

import bean.FavoriteBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*���C�ɓ���̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraFavoriteDao implements FavoriteDao {
	/*�S�Ă̂��C�ɓ���̏����擾���郁�\�b�h*/
	public List getFavorites() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<FavoriteBean> favorites = new ArrayList<FavoriteBean>();
		
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
			String sql = "select member_id, product_id from favorite";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				FavoriteBean favorite = new FavoriteBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				favorite.setMemberId(result.getInt(1));
				favorite.setProductId(result.getString(2));
				/*���X�g��Bean���i�[����*/
				favorites.add(favorite);
			}
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
			result.close();
			statement.close();
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
		return favorites;
	}
	
	/*������Bean�̓��e�̒ʂ�ɁA���C�ɓ����o�^���郁�\�b�h*/
	public void addFavorite(FavoriteBean favorite) throws IntegrationException {
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
			String sql = "insert into favorite values(?, ?)";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
			preparedStatement.setInt(1, favorite.getMemberId());
			preparedStatement.setString(2, favorite.getProductId());
			
			/*SQL�����s����*/
			preparedStatement.executeUpdate();
			
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
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
	
	/*������Bean�̓��e�Ɉ�v���邨�C�ɓ�����폜���郁�\�b�h*/
	public void removeFavorite(FavoriteBean favorite) throws IntegrationException {
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
			String sql = "delete from favorite "
			+ "where member_id = ? and product_id = ?";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
			preparedStatement.setInt(1, favorite.getMemberId());
			preparedStatement.setString(2, favorite.getProductId());
			
			/*SQL�����s����*/
			preparedStatement.executeUpdate();
			
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
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