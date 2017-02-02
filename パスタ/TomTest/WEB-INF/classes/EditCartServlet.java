import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import command.EditCartCommand;
import ex.LogicException;

/*
�J�[�g�̒��̏��i���폜�ł���Servlet�A���i���̓Z�b�V��������
EditCart
*/
/*���V*/
public class EditCartServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException, LogicException{
		
		req.setCharacterEncoding("Windows-31J");
		
		EditCartCommand ecsc = new EditCartCommand();
		
		ecsc.execute();
		System.out.println("�����[��");
		RequestDispatcher rd = req.getRequestDispatcher("/cart");
		
		rd.forward(req,res);
	}
}