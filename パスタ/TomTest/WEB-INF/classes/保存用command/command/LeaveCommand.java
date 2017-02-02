package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.WebRequestContext;
import logic.ResponseContext;

import dao.OraMemberDao;

import bean.MemberBean;

import javax.servlet.http.HttpSession;


/**
 *@className EditCartCommand
 *@author ���V
 *@date 2017/01/31
 *@description 
 */
/*
�o�^�ς݃��[�U�[���މ��Command
*/
public class LeaveCommand extends AbstractCommand{
	
	/*�����o�[�X�e�[�^�X�őމ��2*/
	final int leaveStatus = 2;
	
	public LeaveCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = new WebRequestContext();
		
		
		HttpSession session = (HttpSession)req.getSession();
		
		OraMemberDao oraMemberDao = new OraMemberDao();
		
		MemberBean memberBean = new MemberBean();
		
		
		//session����id�����o��
		id = (int)session.getAttribute("memberid");
		
		/*MemberBean��id�Ɠo�^��Ԃ�މ�ɕύX����leaveStatus��n��*/
		try{
			memberBean.setMemberId(id);
			memberBean.setMemberStatusId(leaveStatus);
			
			oraMemberDao.editMember(memberBean);
		}catch(IntegrationException e){
			e.printStackTrace();
		}
		
		
		responseContext.setTarget("leave");
		
		return responseContext;
	}
}