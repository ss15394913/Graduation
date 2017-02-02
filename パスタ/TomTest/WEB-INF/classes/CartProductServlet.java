import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import command.CartProductCommand;
import ex.LogicException;

/*
カートの中に商品を追加するServlet、商品情報はセッション内へ
*/
/*塩澤と河野*/
public class CartProductServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		
		CartProductCommand cpc = new CartProductCommand();
		cpc.execute();
		
		System.out.println("あかーん");
		
		RequestDispatcher rd = req.getRequestDispatcher("/cart");
		
		rd.forward(req,res);
		
	}
}