import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddFavorite {
	public static void add(FavoriteBean favorite) {
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shop_admin", "admin");
			
			cn.setAutoCommit(false);
			
			String sql = "INSERT INTO favorite VALUES("+favorite.getMember_id()+",'"+favorite.getProduct_id()+"')";
			
			st = cn.prepareStatement(sql);
			
			st.executeUpdate();
			
			cn.commit();
			
			System.out.println("completed.");
		} catch(SQLException e){
			System.out.println(e.getMessage());
		} catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}