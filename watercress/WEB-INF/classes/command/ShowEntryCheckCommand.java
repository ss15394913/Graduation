package command;

import java.util.HashMap;
import java.util.List;

import bean.MemberBean;
import dao.OraMemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className ShowEntryCheckCommand
 *@author Kohichi Tujihashi
 *@date 2017/03/03
 *@description
 */
/**/
public class ShowEntryCheckCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		RequestContext reqc = getRequestContext();

		/*jspでユーザーから入力された値を取得*/
		String memberName = reqc.getParameter( "firstName" )[0] + " " + reqc.getParameter( "lastName" )[0];
		String memberKana = reqc.getParameter( "kanaFirstName" )[0] + " " + reqc.getParameter( "kanaLastName" )[0];
		String memberAddress =reqc.getParameter( "prefectures" )[0] + " " + reqc.getParameter( "municipality" )[0] + " "
				+ reqc.getParameter( "address" )[0] + " " + reqc.getParameter( "buildingName" )[0];
		String memberZipCode = reqc.getParameter( "memberZipCode" )[0];
		String  prefectures= reqc.getParameter( "prefectures" )[0];
		String  municipality= reqc.getParameter( "municipality" )[0];
		String  address= reqc.getParameter( "address" )[0];
		String  buildingName= reqc.getParameter( "buildingName" )[0];
		String memberPhoneNumber = reqc.getParameter( "memberPhoneNumber" )[0];
		String memberBirthday = reqc.getParameter( "memberBirthday" )[0];
		String memberEmail = reqc.getParameter( "memberEmail" )[0];
		String memberPassword = reqc.getParameter( "memberPassword" )[0];
		int memberStatusId = 0;

//		System.out.println("月破ら直後"+memberEmail);

		/*表示用データを格納するHashMap*/
		HashMap<String, Object> memberData = new HashMap();

		/*MemberBeanを生成*/
		MemberBean memberbean  = new MemberBean();

		OraMemberDao memberdao = new OraMemberDao();
		//member情報を登録させるdaoのインスタンスを生成
		try{
			//memberdao.registMember(memberbean);
			//Member表の全データを取得
			List memberlist= memberdao.getMembers();

			//↑の中から、認証コードがrandomと同じかつステータスIDが未入会の会員データをBeanに取得
			MemberBean allMember = new MemberBean();

			for(int i=0;i<memberlist.size();i++){
				allMember=(MemberBean)memberlist.get(i);
				if(allMember.getMemberEmail().equals(memberEmail)){
					responseContext.setTarget( "userentry" );
					break;
				}
			}

			//BeanからIdを取得
			//int memberid =memberData.getMemberId();

			//Idをmemberbeanにsetして、セッションに登録
			//memberbean.setMemberId(memberid);
			//reqc.setSessionAttribute("tempuser", memberbean);
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}



				/*memberBeanに情報を登録*/
				memberbean.setMemberName( memberName );
				memberbean.setMemberKana( memberKana );
				memberbean.setMemberZipCode( memberZipCode );
				memberbean.setMemberAddress( memberAddress );
				memberbean.setMemberPhoneNumber( memberPhoneNumber );
				memberbean.setMemberBirthday( memberBirthday );
				memberbean.setMemberEmail( memberEmail );
				memberbean.setMemberPassword( memberPassword );
				memberbean.setMemberStatusId( 3 );

				/*メンバー情報を登録*/
				reqc.setSessionAttribute("tempuser", memberbean);

				/* 表示用にデータを編集し、Mapに登録 */
				String[] name = memberbean.getMemberName().split("\\s"); //半角スペース
				memberData.put("firstName", name[0]);
				memberData.put("lastName", name[1]);

				String[] kana = memberbean.getMemberKana().split("\\s");
				memberData.put("fKana", kana[0]);
				memberData.put("lKana", kana[1]);

				String[] add = memberbean.getMemberAddress().split("\\s");
				memberData.put("add1", add[0]);
				memberData.put("add2", add[1]);
				memberData.put("add3", add[2]);
				memberData.put("add4", add[3]);

				String birth = memberbean.getMemberBirthday().replaceAll("/","-");
				memberData.put("birth", birth);

				memberData.put("post", memberbean.getMemberZipCode());
				memberData.put("phone", memberbean.getMemberPhoneNumber());
				memberData.put("email", memberbean.getMemberEmail());

				/*AppricationControllerのsetAttributeに
				登録するためにsetResultメソッドを使ってsessionを登録*/
				responseContext.setResult(memberData);
				/*登録確認ページに移動*/
				responseContext.setTarget( "entrycheck" );

		return responseContext;
	}
}
/**



*/
