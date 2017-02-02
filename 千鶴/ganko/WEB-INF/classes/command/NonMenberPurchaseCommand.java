import ex.LogicException;
import bean.MemberBean;
/**
 *@className NonMenberPurchaseCommand
 *@author 窪田
 *@date 2017/01/26
 *@description 
 */
public class NonMenberPurchaseCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
	
		RequestContext reqc = getRequestContext();
		
		/*メンバー情報を登録*/
		int memberId = Integer.parseInt( reqc.getParameter( "memberId" )[0]);
		String memberName = reqc.getParameter( "memberName" )[0];
		String memberKana = reqc.getParameter( "memberKana" )[0];
		String memberZipCode = reqc.getParameter( "memberZipCode" )[0];
		String memberAddress = reqc.getParameter( "memberAddress" )[0];
		String memberPhoneNumber = reqc.getParameter( "memberPhoneNumber" )[0];
		String memberBirthday = reqc.getParameter( "memberBirthday" )[0];
		String memberEmail = reqc.getParameter( "memberEmail" )[0];
		String memberPassword = reqc.getParameter( "memberPassword" )[0];
		int memberStatusId = Integer.parseInt(reqc.getParameter( "memberStatusId" )[0]);
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
		memberbean.setMemberBirthday( memberBirthday );//必要ない？
		memberbean.setMemberEmail( memberEmail );
		memberbean.setMemberPassword( memberPassword );//必要ない？
		memberbean.setMemberStatusId( memberStatusId );
		
		OraMemberDao memberdao = new OraMemberDao();
		//member情報を登録させるdaoのインスタンスを生成
		
		memberdao.registMember( memberbean );
		
		ResponceContext resc = new WebResponceContext();
		resc.setTarget( "payinput" );
		//支払い情報を入力するページに移動？
		return resc;
	}
}
/**

	

*/