import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowFavTestServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
		req.setCharacterEncoding("Windows-31J");
		
		String member_id = req.getParameter("memberid");
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("showfav.jsp");
		
		dispatcher.forward(req, res);
	}
}