import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductStockInserter{
	public static void main(String[] args){
		Connection cn = null;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement ps = null;
		String path = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "shop_admin";
		String pw = "admin";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(path, id, pw);
			cn.setAutoCommit(false);
			st = cn.createStatement();
			String sql = "SELECT product_id FROM PRODUCT";
			rs = st.executeQuery(sql);
			ArrayList<Integer> _product_id = new ArrayList<Integer>();
				while(rs.next()){
					int product_id = rs.getInt(1);
					_product_id.add(product_id);
				}
			rs.close();
			
			sql = "INSERT INTO PRODUCT_STOCK VALUES (?,20)";
			ps = cn.prepareStatement(sql);
			
				for(int i = 0;i<_product_id.size();i++){
					int temp_product_id = (Integer) _product_id.get(i);
					ps.setInt(1,temp_product_id);
					
					int executeCount = ps.executeUpdate();
				}
			cn.commit();
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			try{
				ps.close();
				cn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}