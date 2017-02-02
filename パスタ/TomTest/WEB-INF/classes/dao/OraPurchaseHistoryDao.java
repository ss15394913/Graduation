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

import bean.PurchaseHistoryBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*�w�������̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraPurchaseHistoryDao implements PurchaseHistoryDao {
	/*�S�Ă̍w�������̏����擾���郁�\�b�h*/
	public List getPurchaseHistories() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<PurchaseHistoryBean> purchaseHistories
		= new ArrayList<PurchaseHistoryBean>();
		
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
			String sql
			= "select member_id, purchase_order_id, purchase_order_date, "
			+ "purchase_order_delivery_status, purchase_order_detail_id, "
			+ "product_id, purchase_count "
			+ "from purchase_order join purchase_order_detail "
			+ "using(purchase_order_id) "
			+ "order by purchase_order_date desc";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				PurchaseHistoryBean purchaseHistory
				= new PurchaseHistoryBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				purchaseHistory.setMemberId(result.getInt(1));
				purchaseHistory.setPurchaseOrderId(result.getInt(2));
				purchaseHistory.setPurchaseOrderDate(result.getString(3));
				purchaseHistory.setPurchaseOrderDeliveryStatus(
					result.getString(4));
				purchaseHistory.setPurchaseOrderDetailId(result.getInt(5));
				purchaseHistory.setProductId(result.getString(6));
				purchaseHistory.setPurchaseCount(result.getInt(3));
				/*���X�g��Bean���i�[����*/
				purchaseHistories.add(purchaseHistory);
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
		return purchaseHistories;
	}
	
}