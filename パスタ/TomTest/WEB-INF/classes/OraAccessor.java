import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OraAccessor extends Accessor{
	public void write(String sql){
		System.out.println(sql+"ƒƒ“ID‚Ì’†g—Accessor");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url,"shop_admin","admin");
			conn.setAutoCommit(false);
			
			
			
			//SQL•¶‚ğ•Ï”‚ÉŠi”[‚·‚é
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			conn.commit();
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}






//-EOF-