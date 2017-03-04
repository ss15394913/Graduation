package command;

import bean.MemberBean;
import dao.OraMemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AddUserCommand
 *@author Kohichi Tujihashi
 *@date 2017/03/03
 *@description
 */
public class AddUserCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
			throws LogicException{

		RequestContext reqc = getRequestContext();

		MemberBean memberbean = new MemberBean();

		/*前ページでセットしたパラメータをセッションで取得*/
		try{
			memberbean =(MemberBean)reqc.getSessionAttribute("tempuser");
		/*受け取ったセッションを重複しないよう消す*/
			reqc.removeSessionAttribute("tempuser");

			/*DBに保存されている認証コード(answerCode)と認証時にユーザ入力したコード(memberEntryCode)を取得*/
			String  memberEntryCode= reqc.getParameter( "memberErentryCode" )[0].trim();
			String answerCode=memberbean.getMemberEntryCode().trim();

			/*DBの認証コードとユーザが入力したコードが一致した場合DBに本登録する*/
			if(memberEntryCode.equals(answerCode)){

				System.out.println("if文！");
				memberbean.setMemberStatusId(1);

				System.out.println(memberbean.getMemberId());

				OraMemberDao memberdao = new OraMemberDao();
				//member情報を登録させるdaoのインスタンスを生成
				memberdao.editMember(memberbean);

				/*ログイン処理*/
				reqc.setSessionAttribute("login", String.valueOf(memberbean.getMemberId()));

				/*登録確認ページに移動*/
				responseContext.setTarget( "entrycomp" );
			}else{
				/*DBの登録コードとユーザが入力したコードが合わない場合再度認証ページへ移動*/
				responseContext.setTarget( "entrycode" );
			}
		}catch(IntegrationException e){
			System.out.println(e.getMessage());
			throw new LogicException(e.getMessage(),e);
		}

		/*AppricationControllerのsetAttributeに
		登録するためにsetResultメソッドを使ってbeanを登録
		*/
		responseContext.setResult(memberbean);

		return responseContext;

	}
}
/**



 */