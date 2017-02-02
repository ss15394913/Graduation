/*
  @author 池田千鶴
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

/* フィルター作動時用のログインチェックコマンド */
/* 普通のログインチェックコマンドとは、
	別コマンドを呼び出して移動先を決定する部分が異なる */
public class FilterLogInCommand extends AbstractCommand {
	/* 会員表を取得し、メールアドレスとパスワードが一致する会員を検索する */
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		System.out.println("--FilterLogInCommand--");
		
		try{
			/* 会員表のリストを取得 */
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberdao = factory.getMemberDao();
			List memberlist = memberdao.getMembers();
			
			RequestContext reqc = getRequestContext();
			
			/* 一行ずつ検索(見づらいのでチェックは別メソッドに分離) */
			for(int i = 0; i < memberlist.size(); i++){
				MemberBean member = (MemberBean)memberlist.get(i);
				checkPassword(member, reqc);
			}
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		//移動先用のコマンドを呼び出す処理がここに入る
		//responseContextもらう？
		
		return responseContext;
	}
	
	/* 会員情報が登録されているかチェック */
	private static void checkPassword(MemberBean member, RequestContext reqc) {
		/* 入力されたメールアドレスと一致するメールアドレスがあった場合 */
		if(member.getMemberEmail().equals(reqc.getParameter("email"))){
			/* 入力されたパスワードと、
				メールアドレスに応じたパスワードが同じ場合(ログイン成功)、
				セッションにmember_idを登録*/
			if(member.getMemberPassword().equals(reqc.getParameter("pass"))) {
				reqc.setSessionAttribute("login", member.getMemberId());
			/* メールアドレスまたはパスワードが違う場合(ログイン失敗)、
				セッションにログインが失敗したことを登録*/
			}else{
				System.out.println("パスワードが違います");
				reqc.setSessionAttribute("login", "NG");
			}
		}else{
			System.out.println("メルアドがないです");
			reqc.setSessionAttribute("login", "NG");
		}
	}
}