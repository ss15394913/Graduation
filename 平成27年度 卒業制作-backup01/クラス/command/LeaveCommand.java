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
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 */
/*
登録済みユーザーが退会するCommand
*/
public class LeaveCommand extends AbstractCommand{
	
	/*メンバーステータスで退会は2*/
	private final int leaveStatus = 2;
	
	public LeaveCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = new WebRequestContext();
		try{
			
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberDao = factory.getMemberDao();
			
			
			
			//sessionからidを取り出す
			int id = (int)req.getSessionAttribute("memberid");
			
			
			
			//Beanをインスタンス化
			MemberBean member = new MemberBean();
			
			//MemberBeanを全部取ってくる
			List members = memberDao.getMembers();
			
			Iterator i = members.iterator();
			int getId = -1;
			while(i.hasNext()){
				member = (MemberBean)i.next();
				
				/*
				とりあえず取ってきたmemberから現在ログインしている
				ユーザーのidを見つける
				*/
				getId = member.getMemberId();
				if(id == getId){
					//見つけたらbreakで終わる
					break;
				}
			}
			//見つけたユーザーの登録状況を退会に変更
			member.setMemberStatusId(leaveStatus);
			
			memberDao.editMember(member);
		}catch(IntegrationException e){
			e.printStackTrace();
		}
		
		
		responseContext.setTarget("leave");
		
		return responseContext;
	}
}