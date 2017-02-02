import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FavTestServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
		req.setCharacterEncoding("Windows-31J");
		
		String member_id = req.getParameter("memberid");
		String product_id = req.getParameter("productid");
		
		FavoriteBean favorite = new FavoriteBean();
		favorite.setMember_id(Integer.parseInt(member_id));
		favorite.setProduct_id(product_id);
		
		System.out.println(favorite.getMember_id());
		System.out.println(favorite.getProduct_id());
		
		AddFavorite.add(favorite);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("sucfav.jsp");
		
		dispatcher.forward(req, res);
	}
}