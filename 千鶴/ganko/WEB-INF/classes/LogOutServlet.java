import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
		req.setCharacterEncoding("Windows-31J");
		
		LogOut.logOut(req);
		
		RequestDispatcher dis = req.getRequestDispatcher("top.jsp");
		
		dis.forward(req, res);
	}
}