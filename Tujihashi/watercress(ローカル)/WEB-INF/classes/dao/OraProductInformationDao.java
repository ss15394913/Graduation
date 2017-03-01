//Product�\�̃f�[�^�擾
package dao;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import bean.ProductInformationBean;
import ex.ConnectorException;
import ex.IllegalSQLException;
import ex.IntegrationException;

public class OraProductInformationDao implements ProductInformationDao {
	/*�S�Ă̏��i�̏����擾���郁�\�b�h*/
	public List getProductInformations() throws IntegrationException{
		
		ArrayList<ProductInformationBean> infoList =
							new ArrayList<ProductInformationBean>();
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
			String sql = "product_id, product_name, product_price, "+
							"product_description, category_id,"+
							"sub_category_id, product_size, product_color,"+
       						"product_release_date, product_stock_count "+
							"FROM product_information_view " + 
							"ORDER BY product_release_date DESC";
			
			/*SQL�������s���AResultSet�I�u�W�F�N�g�𐶐�*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*SELECT�̌��ʂ�Bean�ɓ����*/
				ProductInformationBean info = new ProductInformationBean();
				
				info.setProductId(result.getString(1));
				info.setProductName(result.getString(2));
				info.setProductPrice(Integer.parseInt(result.getString(3)));
				info.setProductDescription(result.getString(4));
				info.setCategoryId(Integer.parseInt(result.getString(5)));
				info.setSubCategoryId(Integer.parseInt(result.getString(6)));
				info.setProductSize(result.getString(7));
				info.setProductColor(result.getString(8));
				info.setProductReleaseDate(result.getString(9));
				info.setProductStockCount(Integer.parseInt(result.getString(10)));
				
				/*List��Bean������*/
				infoList.add(info);
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
		return infoList;
		
	}
}