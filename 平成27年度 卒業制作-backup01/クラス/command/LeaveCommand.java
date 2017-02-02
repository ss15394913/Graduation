package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.WebRequestContext;
import logic.ResponseContext;

import dao.AbstractDaoFactory;
import dao.MemberDao;
import dao.OraMemberDao;

import bean.MemberBean;

import java.util.Iterator;
import java.util.List;

//import javax.servlet.http.HttpSession;


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
	private final int leaveStatus = 2;
	
	public LeaveCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = new WebRequestContext();
		try{
			
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberDao = factory.getMemberDao();
			
			
			
			//session����id�����o��
			int id = (int)req.getSessionAttribute("memberid");
			
			
			
			//Bean���C���X�^���X��
			MemberBean member = new MemberBean();
			
			//MemberBean��S������Ă���
			List members = memberDao.getMembers();
			
			Iterator i = members.iterator();
			int getId = -1;
			while(i.hasNext()){
				member = (MemberBean)i.next();
				
				/*
				�Ƃ肠��������Ă���member���猻�݃��O�C�����Ă���
				���[�U�[��id��������
				*/
				getId = member.getMemberId();
				if(id == getId){
					//��������break�ŏI���
					break;
				}
			}
			//���������[�U�[�̓o�^�󋵂�މ�ɕύX
			member.setMemberStatusId(leaveStatus);
			
			memberDao.editMember(member);
		}catch(IntegrationException e){
			e.printStackTrace();
		}
		
		
		responseContext.setTarget("leave");
		
		return responseContext;
	}
}