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

import bean.ProductCatalogBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*���i�ꗗ��ʗp�̈ꗗ���擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraProductCatalogDao implements ProductCatalogDao {
	/*�S�Ă̏��i�ꗗ��ʗp�̈ꗗ�̏����擾���郁�\�b�h*/
	public List getProductCatalogs(int[] sortingRules)
	throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<ProductCatalogBean> productCatalogs
		= new ArrayList<ProductCatalogBean>();
		
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
			String sql = "select product_name, product_price, "
			+ "category_id, sub_category_id, "
			+ "product_release_date, product_stock_count, "
			+ "example_product_id, product_image_path, "
			+ "purchase_count_sum "
			+ "from product_catalog_view ";
			
			boolean usedOrderby = false;
			
			/*�����̔z��̓��e�ɉ����āA���ёւ�������ǉ�����*/
			for(int i = 0; i < sortingRules.length; i++){
				/*�l�i�̏����ł̕��ёւ����s��*/
				if(sortingRules[i] == SORT_BY_PRICE_ASC){
					/*orderby�傪�܂��ǉ�����Ă��Ȃ��Ȃ�Aorder by��ǉ�����*/
					/*orderby�傪���ɒǉ�����Ă����Ȃ�A,��ǉ�����*/
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_price ";
				}
				/*�l�i�̍~���ł̕��ёւ����s��*/
				if(sortingRules[i] == SORT_BY_PRICE_DESC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_price desc ";
				}
				/*�w�����̏����ł̕��ёւ����s��*/
				if(sortingRules[i] == SORT_BY_PURCHASE_COUNT_ASC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "purchase_count_sum ";
				}
				/*�w�����̍~���ł̕��ёւ����s��*/
				if(sortingRules[i] == SORT_BY_PURCHASE_COUNT_DESC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "purchase_count_sum desc ";
				}
				/*���O�̏����ł̕��ёւ����s��*/
				if(sortingRules[i] == SORT_BY_NAME_ASC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_name ";
				}
				/*���O�̍~���ł̕��ёւ����s��*/
				if(sortingRules[i] == SORT_BY_NAME_DESC){
					if(!usedOrderby){
						sql += "order by ";
						usedOrderby = true;
					}else{
						sql += ", ";
					}
					sql += "product_name desc ";
				}
			}
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				ProductCatalogBean productCatalog = new ProductCatalogBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
				productCatalog.setProductName(result.getString(1));
				productCatalog.setProductPrice(result.getInt(2));
				productCatalog.setCategoryId(result.getInt(3));
				productCatalog.setSubCategoryId(result.getInt(4));
				productCatalog.setProductReleaseDate(result.getString(5));
				productCatalog.setProductStockCount(result.getInt(6));
				productCatalog.setExampleProductId(result.getString(7));
				productCatalog.setProductImagePath(result.getString(8));
				productCatalog.setPurchaseCountSum(result.getInt(9));
				/*���X�g��Bean���i�[����*/
				productCatalogs.add(productCatalog);
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
		return productCatalogs;
	}
	
	/*��L���\�b�h�̃I�[�o�[���[�h�B��L�̃��\�b�h���Ăяo��*/
	public List getProductCatalogs(int sortingRule)
	throws IntegrationException {
		/*������int�^�ϐ��̒l���Aint�z��^�ϐ��ɓ����*/
		int sortingRules[];
		sortingRules = new int[1];
		sortingRules[0] = sortingRule;
		/*��L�̃��\�b�h���Ăяo���A���̖߂�l��Ԃ�*/
		return getProductCatalogs(sortingRules);
	}
	
	/*��L���\�b�h�̃I�[�o�[���[�h�B��L�̃��\�b�h���Ăяo��*/
	public List getProductCatalogs()
	throws IntegrationException {
		/*���int�z��^�ϐ������*/
		int sortingRules[];
		sortingRules = new int[0];
		/*��L�̃��\�b�h���Ăяo���A���̖߂�l��Ԃ�*/
		return getProductCatalogs(sortingRules);
	}
}