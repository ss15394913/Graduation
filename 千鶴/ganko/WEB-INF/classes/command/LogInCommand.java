/*
  @author �r�c���
  @date 2017/02/01
*/

package command;

import bean.MemberBean;

import logic.ResponseContext;
import logic.RequestContext;
import logic.WebRequestContext;

import dao.AbstractDaoFactory;
import dao.MemberDao;
import dao.OraMemberDao;

import ex.LogicException;
import ex.IntegrationException;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

/* �ʏ�̃��O�C���`�F�b�N�R�}���h(top���烍�O�C����������) */
public class LogInCommand extends AbstractCommand {
	/* ����\���擾���A���[���A�h���X�ƃp�X���[�h����v���������������� */
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		System.out.println("--LogInCommand--");
		
		RequestContext reqc = getRequestContext();
		
		try{
			/* ����\�̃��X�g���擾 */
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberdao = factory.getMemberDao();
			List memberlist = memberdao.getMembers();
			
			/* ��s������(���Â炢�̂Ń`�F�b�N�͕ʃ��\�b�h�ɕ���) */
			for(int i = 0; i < memberlist.size(); i++){
				MemberBean member = (MemberBean)memberlist.get(i);
				checkPassword(member, reqc);
			}
			
			
			/* ��������t�B���^�[�@�\�ɋ߂����� */
			/* �Z�b�V�������烍�O�C�������擾 */
			String login = (String)reqc.getSessionAttribute("login");
			System.out.println("login=" + login);
			
			/* �����O�C���E���O�C���Ɏ��s�����ꍇ�A�ēx���O�C����ʂ֔�΂� */
			if(login == null || "".equals(login) || "NG".equals(login)) {
				responseContext.setTarget("login");
			/* ���O�C���ς̏ꍇ�A�g�b�v�y�[�W�֔�΂� */
			}else {
				responseContext.setTarget("top");
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		return responseContext;
	}
	
	/* �����񂪓o�^����Ă��邩�`�F�b�N */
	private static void checkPassword(MemberBean member, RequestContext reqc) {
		/* ���͂��ꂽ���[���A�h���X�ƈ�v���郁�[���A�h���X���������ꍇ */
		if(member.getMemberEmail().equals(reqc.getParameter("email"))){
			/* ���͂��ꂽ�p�X���[�h�ƁA
				���[���A�h���X�ɉ������p�X���[�h�������ꍇ(���O�C������)�A
				�Z�b�V������member_id��o�^*/
			if(member.getMemberPassword().equals(reqc.getParameter("pass"))) {
				reqc.setSessionAttribute("login", member.getMemberId());
			/* ���[���A�h���X�܂��̓p�X���[�h���Ⴄ�ꍇ(���O�C�����s)�A
				�Z�b�V�����Ƀ��O�C�������s�������Ƃ�o�^*/
			}else{
				System.out.println("�p�X���[�h���Ⴂ�܂�");
				reqc.setSessionAttribute("login", "NG");
			}
		}else{
			System.out.println("�����A�h���Ȃ��ł�");
			reqc.setSessionAttribute("login", "NG");
		}
	}
}