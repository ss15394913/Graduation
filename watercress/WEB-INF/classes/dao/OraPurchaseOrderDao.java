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

import bean.PurchaseOrderBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*�����̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraPurchaseOrderDao implements PurchaseOrderDao {
	/*�S�Ă̒����̏����擾���郁�\�b�h*/
	public List getPurchaseOrders() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<PurchaseOrderBean> purchaseOrders
		= new ArrayList<PurchaseOrderBean>();
		
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
			String sql = "select purchase_order_id, purchase_order_date, "
			+ "purchase_order_delivery_status, member_id, "
			+ "purchase_order_payment_method from purchase_order";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				PurchaseOrderBean purchaseOrder = new PurchaseOrderBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				purchaseOrder.setPurchaseOrderId(result.getInt(1));
				purchaseOrder.setPurchaseOrderDate(result.getString(2));
				purchaseOrder.setPurchaseOrderDeliveryStatus(
					result.getString(3));
				purchaseOrder.setMemberId(result.getInt(4));
				purchaseOrder.setPurchaseOrderPaymentMethod(
					result.getString(5));
				/*���X�g��Bean���i�[����*/
				purchaseOrders.add(purchaseOrder);
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
		return purchaseOrders;
	}
	
	/*�������ׂ�o�^����ɂ́A���̒����̒���ID��m��K�v������B
	  ����𒍕��\�̑S���⍇������m��ɂ͎�Ԃ�������̂ŁA
	  ���̃��\�b�h�̖߂�l���������琶�����ꂽ����ID�ɂ��āA��������}�����B*/
	/*�����̏���o�^���郁�\�b�h�B�߂�l�́A�������琶�����ꂽ����ID�B*/
	public int setPurchaseOrder(PurchaseOrderBean purchaseOrder)
	throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*�߂�l�ƂȂ�A�������琶�����ꂽ����ID���i�[����ϐ��̐錾*/
		int currentId;
		
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
			String sql = "insert into purchase_order "
			+ "values(purchase_order_id_seq.NEXTVAL, SYSDATE, "
			+ "'������', ?, ?)";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
			preparedStatement.setInt(1, purchaseOrder.getMemberId());
			preparedStatement.setString(
				2, purchaseOrder.getPurchaseOrderPaymentMethod());
			
			/*SQL�����s����*/
			preparedStatement.executeUpdate();
			
			/*PreparedStatement���N���[�Y����*/
			preparedStatement.close();
			
			/*�������琶�����ꂽ�l���m�F���邽�߁A�����Ė⍇�����s��*/
			sql = "select purchase_order_id_seq.CURRVAL from dual";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = preparedStatement.executeQuery(sql);
			
			/*�����̌��݂̒l���i�[����Ă���s���Q�Ƃ���*/
			result.next();
			
			/*�����̌��݂̒l���擾���A�ϐ��Ɋi�[����*/
			currentId = result.getInt(1);
			
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
		/*�������琶�����ꂽ����ID��Ԃ�*/
		return currentId;
	}
}