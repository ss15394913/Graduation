import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/*
�J�[�g�̒��̏��i���폜�ł���Servlet�A���i���̓Z�b�V��������
EditCart
*/
/*���V*/
public class EditCartServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		HttpSession session = req.getSession();
		/*���͂��ꂽ�p�����[�^���󂯎��*/
		String listNumberString = req.getParameter("listNumber");
		int listNumberInt = -1;
		
		/*
		�J�[�g���̏��i���폜����ۂɁA�폜���鏤�i��I�Ԃ�null���Ԃ�
		�Ή����邽�߂Ɉ�Unull�����String������
		*/
		String checkString = listNumberString;
		int checkInt=0;
		System.out.println("�����܂�");
		/*
		���g��null�̏ꍇ0�ł͂Ȃ�-1�ŏ㏑������
		*/
		if(checkString == null){
			checkInt = -1;
		}
		
		/*
		��Őݒ肵��null�ꍇ��-1��������A�J�[�g���ɏ��i���܂����݂��Ȃ��̂�
		�폜���镶�����s�����Ȃ��B
		*/
		if(0 <= checkInt){
			listNumberInt = Integer.parseInt(listNumberString);
		}else{
			System.out.println("�폜���鏤�i��I�����ĂˁI");
		}
		
		System.out.println(listNumberInt+"�Ă���@servlet��");
		
		
		String removeResultNumber = "result" + listNumberString;
		System.out.println(removeResultNumber+":::�Ă���");
		
		session.removeAttribute(removeResultNumber);
		
		RequestDispatcher rd = req.getRequestDispatcher("/kekka");
		
		rd.forward(req,res);
	}
}