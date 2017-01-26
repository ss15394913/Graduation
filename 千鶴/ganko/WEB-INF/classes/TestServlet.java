import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
		req.setCharacterEncoding("Windows-31J");
		
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		String target = new String(req.getRequestURL());
		HttpSession session = req.getSession();
		session.setAttribute("target", target);
		
		MemberBean user = new MemberBean();
		user.setMemberEmail(email);
		user.setMemberPassword(pass);
		
		System.out.println(user.getMemberEmail());
		System.out.println(user.getMemberPassword());
		
		req.setAttribute("user", user);
		
		LogIn.checkLogIn(user, req);
		
		RequestDispatcher dis = req.getRequestDispatcher((String)session.getAttribute("target"));
		
		dis.forward(req, res);
	}
}