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

import bean.PurchaseOrderDetailBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*�������ׂ̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraPurchaseOrderDetailDao implements PurchaseOrderDetailDao {
	/*�S�Ă̒������ׂ̏����擾���郁�\�b�h*/
	public List getPurchaseOrderDetails() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<PurchaseOrderDetailBean> purchaseOrderDetails
		= new ArrayList<PurchaseOrderDetailBean>();
		
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
			String sql = "select purchase_order_detail_id, purchase_order_id, "
			+ "product_id, purchase_count "
			+ "from purchase_order_detail";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				PurchaseOrderDetailBean purchaseOrderDetail
				= new PurchaseOrderDetailBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				purchaseOrderDetail.setPurchaseOrderDetailId(result.getInt(1));
				purchaseOrderDetail.setPurchaseOrderId(result.getInt(2));
				purchaseOrderDetail.setProductId(result.getString(3));
				purchaseOrderDetail.setPurchaseCount(result.getInt(4));
				/*���X�g��Bean���i�[����*/
				purchaseOrderDetails.add(purchaseOrderDetail);
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
		return purchaseOrderDetails;
	}
	/*�������ׂ�o�^���郁�\�b�h*/
	public void setPurchaseOrderDetail(
		PurchaseOrderDetailBean purchaseOrderDetail)
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
			String sql = "insert into purchase_order_detail "
			+ "values(purchase_order_detail_id_seq.NEXTVAL, ?, ?, ?)";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
			preparedStatement.setInt(
				1, purchaseOrderDetail.getPurchaseOrderId());
			preparedStatement.setString(
				2, purchaseOrderDetail.getProductId());
			preparedStatement.setInt(
				3, purchaseOrderDetail.getPurchaseCount());
			
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