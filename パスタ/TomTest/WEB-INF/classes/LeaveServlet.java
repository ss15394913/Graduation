import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;


/*�����̓��O�C�����Ă��郆�[�U�[��ID���Z�b�V���������ɓ����
���̃��[�U�[ID�̃X�e�[�^�X��މ�ς݂ɕς���*/
/*���V*/
public class LeaveServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		LeaveCommand leaveCommand = new LeaveCommand();
		
		leaveCommand.execute();
		
		RequestDispatcher rd = req.getRequestDispatcher("/leave");
		
		rd.forward(req,res);
	}
}