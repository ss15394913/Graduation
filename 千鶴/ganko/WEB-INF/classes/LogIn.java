import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class LogIn {
	public static void checkLogIn(MemberBean member, HttpServletRequest req) {
		System.out.println("--LogIn.checkLogIn--");
		Connection cn = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shop_admin", "admin");
			
			cn.setAutoCommit(false);
			
			String sql = "SELECT * FROM member WHERE member_email='"+member.getMemberEmail()+"'";
			
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			rs.next();
			String pass = rs.getString("member_password");
			
			HttpSession session = req.getSession();
			
			if(member.getMemberPassword().equals(pass)) {
				session.setAttribute("login", "OK");
			}else{
				session.setAttribute("login", "NG");
			}
			
			st.close();
			cn.close();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		} catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
},.l