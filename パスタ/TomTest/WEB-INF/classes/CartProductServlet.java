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
�J�[�g�̒��ɏ��i��ǉ�����Servlet�A���i���̓Z�b�V��������
*/
/*���V�Ɖ͖�*/
public class CartProductServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		
		CartProductCommand cpc = new CartProductCommand();
		cpc.execute();
		
		System.out.println("�����[��");
		
		RequestDispatcher rd = req.getRequestDispatcher("/cart");
		
		rd.forward(req,res);
		
	}
}