/**
 *@className EditCartCommand
 *@author 塩澤
 *@date 2017/01/31
 *@description
 */
package command;

import java.util.Iterator;
import java.util.List;

import bean.MemberBean;
import dao.AbstractDaoFactory;
import dao.MemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;
/*
登録済みユーザーが退会するCommand
*/
public class LeaveCommand extends AbstractCommand{

	/*メンバーステータスで退会は2*/
	private final int leaveStatus = 2;

	public LeaveCommand(){}

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext reqc = getRequestContext();
		try{

			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberDao = factory.getMemberDao();

			//Beanをインスタンス化
			MemberBean member = new MemberBean();

			//sessionからidを取り出す
			String loginid = (String)reqc.getSessionAttribute("login");
			int id = Integer.parseInt(loginid);


			//MemberBeanを全部取ってくる
			List members = memberDao.getMembers();

			Iterator itr = members.iterator();
			int getId = -1;
			while(itr.hasNext()){
				member = (MemberBean)itr.next();

				/*
				取ってきたmemberから現在ログインしている
				ユーザーのidを見つける
				*/
				getId = member.getMemberId();
				if(id == getId){
					//見つけたユーザーの登録状況を退会に変更
					member.setMemberStatusId(leaveStatus);
					//breakで終わる
					break;
				}
			}

			memberDao.editMember(member);

			/* ログアウト処理追加@千鶴 */
			reqc.removeSessionAttribute("login");
			reqc.removeSessionAttribute("target");
			reqc.removeSessionAttribute("cart");

		}catch(IntegrationException e){
			e.printStackTrace();
		}

		responseContext.setTarget("leavecomp");

		return responseContext;
	}
}