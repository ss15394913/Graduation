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
		
		HttpSession session = req.getSession();
		
		OraAccessor OraAc = new OraAccessor();
		
		
		int id=1;
		//�܂��������Ȃ̂�session�i�΁j�̒���id
		session.setAttribute("member_id", id);
		
		//session����id�����o��
		id = (int)session.getAttribute("member_id");
		//�މ�ɕύX����sql��
		String sql = 
		"update member set member_status_id = 2 where member_id = " + id;
		
		//OracleAccessor��write��sql����n��
		OraAc.write(sql);
		
		
		
		
		
		/*������AID�A���O�A�t���K�i�A�X�֔ԍ��A�Z���A�d�b�ԍ��A
		�a�����A���[���A�h���X�A�p�X���[�h�A����̓o�^���
		INSERT INTO member
		VALUES(member_id_seq.NEXTVAL,'test name','test kana',
		'0001111','test_address','0001110000',SYSDATE,'test@test.test',
		'test_pass',9);
		*/
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/leave");
		
		rd.forward(req,res);
	}
}