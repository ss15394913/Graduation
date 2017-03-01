package command;

import bean.MemberBean;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AbstractCommand
 *@author Kohichi Tujihashi
 *@date 2017/01/26
 *@description
 */
public class ShowEntryCheckCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		RequestContext reqc = getRequestContext();


		/*メンバー情報を登録*/
		//int memberId = Integer.parseInt( reqc.getParameter( "memberId" )[0]);

		String memberName=reqc.getParameter("memberName")[0];
		String memberKana = reqc.getParameter( "memberKana" )[0];
		String memberZipCode = reqc.getParameter( "memberZipCode" )[0];


		String memberAddress = reqc.getParameter( "memberAddress" )[0];
		String memberPhoneNumber = reqc.getParameter( "memberPhoneNumber" )[0];
		String memberBirthday = reqc.getParameter( "memberBirthday" )[0];
		String memberEmail = reqc.getParameter( "memberEmail" )[0];
		String memberPassword = reqc.getParameter( "memberPassword" )[0];
		//int memberStatusId = Integer.parseInt(reqc.getParameter( "memberStatusId" )[0]);
		//データを引っ張ってくる
		MemberBean memberbean = new MemberBean();
		//member表を参照

		/*memberBeanに情報を登録*/
		//memberbean.setMemberId( memberId );
		memberbean.setMemberName( memberName );
		memberbean.setMemberKana( memberKana );
		memberbean.setMemberZipCode( memberZipCode );
		memberbean.setMemberAddress( memberAddress );
		memberbean.setMemberPhoneNumber( memberPhoneNumber );
		memberbean.setMemberBirthday( memberBirthday );
		memberbean.setMemberEmail( memberEmail );
		memberbean.setMemberPassword( memberPassword );
		//memberbean.setMemberStatusId( memberStatusId );

		responseContext.setTarget( "entrycheck" );
		//登録確認ページに移動
		responseContext.setResult(memberbean);
		//AppricationControllerのsetAttributeに
		//登録するためにsetResultメソッドを使ってbeanを登録
		return responseContext;
	}
}
/**



*/
