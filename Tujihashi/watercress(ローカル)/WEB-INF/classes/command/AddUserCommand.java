package command;

import bean.MemberBean;
import dao.OraMemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AbstractCommand
 *@author Kohichi Tujihashi
 *@date 2017/01/26
 *@description
 */
public class AddUserCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		RequestContext reqc = getRequestContext();

		/*メンバー情報を登録*/


		MemberBean memberbean = new MemberBean();

		//member表を参照

		/*memberBeanに情報を登録*/
		memberbean.getMemberId();
		memberbean.getMemberName();
		memberbean.getMemberKana();
		memberbean.getMemberZipCode();
		memberbean.getMemberAddress();
		memberbean.getMemberPhoneNumber();
		memberbean.getMemberBirthday();
		memberbean.getMemberEmail();
		memberbean.getMemberPassword();
		memberbean.getMemberStatusId();

		OraMemberDao memberdao = new OraMemberDao();
		//member情報を登録させるdaoのインスタンスを生成
		try{
			memberdao.registMember(memberbean);
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}


		responseContext.setTarget( "entrycomp" );
		//登録確認ページに移動
		responseContext.setResult(memberbean);
		//AppricationControllerのsetAttributeに
		//登録するためにsetResultメソッドを使ってbeanを登録
		return responseContext;
	}
}
/**



*/