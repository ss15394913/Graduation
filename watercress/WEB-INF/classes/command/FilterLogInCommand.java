/*
  @author 池田千鶴
  @date 2017/02/09
*/

package command;

import java.util.List;

import bean.MemberBean;
import dao.AbstractDaoFactory;
import dao.MemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/* フィルター作動時用のログインチェックコマンド */
/* 普通のログインチェックコマンドとは、
	別コマンドを呼び出して移動先を決定する部分が異なる */
public class FilterLogInCommand extends AbstractCommand {
	/* 会員表を取得し、メールアドレスとパスワードが一致する会員を検索する */
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
//		System.out.println("--FilterLogInCommand--");

		try{
			RequestContext reqc = getRequestContext();
			boolean flag = true;

			/* 会員表のリストを取得 */
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberdao = factory.getMemberDao();
			List memberlist = memberdao.getMembers();

			/* 一行ずつ検索(見づらいのでチェックは別メソッドに分離) */
			for(int i = 0; i < memberlist.size(); i++){
				MemberBean member = (MemberBean)memberlist.get(i);
				/* 入力されたメールアドレスと一致するメールアドレスがあった場合 */
				if(member.getMemberEmail().equals(reqc.getParameter("email")[0])){
					flag = false;
					checkPassword(member, reqc);
				}
			}

			/* 入力されたメールアドレスに一致するメールアドレスが
				データベース内に存在しなかった場合 */
			if(flag){
				System.out.println("メールアドレスが違います");		//ここを書き換えてjspに表示したい(余裕があれば)
				reqc.setSessionAttribute("login", "");
				/*ログイン失敗時に表示するメッセージ*/
				reqc.setSessionAttribute("message1", new String("ログインに失敗しました。以下の内容が原因の可能性があります。"));
				reqc.setSessionAttribute("message2", new String("・入力されたメールアドレスに間違いがある。"));
			}


			/* セッションからログイン情報を取得 */
			String login = (String)reqc.getSessionAttribute("login");
//			System.out.println("login=" + login);

			/* 未ログイン・ログインに失敗した場合、
				ログイン画面へ飛ばす */
			if(login == null || "".equals(login)) {
				responseContext.setTarget((String)reqc.getSessionAttribute("target"));
			/* ログイン成功の場合、成功画面→購入画面へ飛ばす */
			}else {
				responseContext.setTarget("filterlogincomp");
				/*成功の場合エラーメッセージを削除*/
				reqc.removeSessionAttribute("message1");
				reqc.removeSessionAttribute("message2");
			}
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}

		return responseContext;
	}
	/* パスワードが正しいかチェック */
	private static void checkPassword
		(MemberBean member, RequestContext reqc) {
		/* 入力されたパスワードと、
			メールアドレスに応じたパスワードが同じ場合 */
		if(member.getMemberPassword().equals(reqc.getParameter("pass")[0])) {
			/* 通常会員の場合(ログイン成功)、セッションにmember_idを登録 */
			if(member.getMemberStatusId() == 1) {
//				System.out.println("ログイン成功");
				reqc.setSessionAttribute("login", String.valueOf(member.getMemberId()));
			/* 未入会・退会済の場合 */
			}else {
				System.out.println("退会済、または未入会のユーザです");	//ここを書き換えてjspに表示したい(余裕があれば)
				reqc.setSessionAttribute("login", "");
				/*ログイン失敗時に表示するメッセージ*/
				reqc.setSessionAttribute("message1", new String("ログインに失敗しました。以下の内容が原因の可能性があります。"));
				reqc.setSessionAttribute("message2", new String("・入力されたアカウントは退会済みか、本登録が済んでいない。"));
			}
		/* パスワードが違う場合(ログイン失敗)、
			セッションにログインが失敗したことを登録*/
		}else{
			System.out.println("パスワードが違います");				//ここを書き換えてjspに表示したい(余裕があれば)
			reqc.setSessionAttribute("login", "");
			/*ログイン失敗時に表示するメッセージ*/
			reqc.setSessionAttribute("message1", new String("ログインに失敗しました。以下の内容が原因の可能性があります。"));
			reqc.setSessionAttribute("message2", new String("・入力されたパスワードに間違いがある。"));
		}
	}
}