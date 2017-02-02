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
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 */
/*
登録済みユーザーが退会するCommand
*/
public class LeaveCommand extends AbstractCommand{
	
	/*メンバーステータスで退会は2*/
	final int leaveStatus = 2;
	
	public LeaveCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = new WebRequestContext();
		
		
		HttpSession session = (HttpSession)req.getSession();
		
		OraMemberDao oraMemberDao = new OraMemberDao();
		
		MemberBean memberBean = new MemberBean();
		
		
		//sessionからidを取り出す
		id = (int)session.getAttribute("memberid");
		
		/*MemberBeanにidと登録状態を退会に変更するleaveStatusを渡す*/
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