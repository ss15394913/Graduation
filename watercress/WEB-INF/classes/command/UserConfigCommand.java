package command;

import bean.MemberBean;
import dao.OraMemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className UserConfigCommand
 *@author Kohichi Tujihashi, Chiduru Ikeda
 *@date 2017/01/26-03/01
 *@description
 */
public class UserConfigCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		RequestContext reqc = getRequestContext();

		/*メンバー情報を登録*/
		int memberId = Integer.parseInt( (String)reqc.getSessionAttribute("login"));

		String memberName = reqc.getParameter( "firstname" )[0] + " " + reqc.getParameter( "lastname" )[0];
		System.out.println(memberName);

		String memberKana = reqc.getParameter( "kanafirstname" )[0] + " " + reqc.getParameter( "kanalastname" )[0];

		String memberAddress =reqc.getParameter( "region" )[0] + " " + reqc.getParameter( "locality" )[0] + " "
				+ reqc.getParameter( "street" )[0] + " " + reqc.getParameter( "extended" )[0];

		String memberZipCode = reqc.getParameter( "code" )[0];
		String memberPhoneNumber = reqc.getParameter( "phone_number" )[0];
		String memberBirthday = reqc.getParameter( "birthday" )[0];
		String memberEmail = reqc.getParameter( "email" )[0];
		String memberPassword = reqc.getParameter( "password" )[0];
		int memberStatusId = 1;
		//データを引っ張ってくる

		MemberBean memberbean = new MemberBean();
		//member表を参照

		/*memberBeanに情報を登録*/
		memberbean.setMemberId( memberId );
		memberbean.setMemberName( memberName );
		memberbean.setMemberKana( memberKana );
		memberbean.setMemberZipCode( memberZipCode );
		memberbean.setMemberAddress( memberAddress );
		memberbean.setMemberPhoneNumber( memberPhoneNumber );
		memberbean.setMemberBirthday( memberBirthday );
		memberbean.setMemberEmail( memberEmail );
		memberbean.setMemberPassword( memberPassword );
		memberbean.setMemberStatusId( memberStatusId );

		OraMemberDao memberdao = new OraMemberDao();
		//member情報を登録させるdaoのインスタンスを生成
		try{
			memberdao.editMember(memberbean);
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}


		responseContext.setTarget("userconfigcomp");
		//変更確認ページに移動
		responseContext.setResult(memberbean);
		//AppricationControllerのsetAttributeに
		//登録するためにsetResultメソッドを使ってbeanを登録
		return responseContext;
	}
}
