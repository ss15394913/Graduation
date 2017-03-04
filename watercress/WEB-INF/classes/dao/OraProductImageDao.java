/*
  author �r�c��a
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ProductImageBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*���i�摜�̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraProductImageDao implements ProductImageDao {
	/*�S�Ă̏��i�摜�̏����擾���郁�\�b�h*/
	public List getProductImages() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<ProductImageBean> productImages
		= new ArrayList<ProductImageBean>();
		
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
			String sql
			= "select product_image_id, product_image_path, product_id " 
			+ "from product_image";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				ProductImageBean productImage = new ProductImageBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				productImage.setProductImageId(result.getInt(1));
				productImage.setProductImagePath(result.getString(2));
				productImage.setProductId(result.getString(3));
				/*���X�g��Bean���i�[����*/
				productImages.add(productImage);
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
		return productImages;
	}
}