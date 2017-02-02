import ex.LogicException;
import bean.MemberBean;
/**
 *@className NonMenberPurchaseCommand
 *@author �E�c
 *@date 2017/01/26
 *@description 
 */
public class NonMenberPurchaseCommand extends AbstractCommand{
	/**�N���C�A���g����̃��N�G�X�g*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
	
		RequestContext reqc = getRequestContext();
		
		/*�����o�[����o�^*/
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
		//�f�[�^�����������Ă���
		
		MemberBean memberbean = new MemberBean();
		//member�\���Q��
		
		/*memberBean�ɏ���o�^*/
		memberbean.setMemberId( memberId );
		memberbean.setMemberName( memberName );
		memberbean.setMemberKana( memberKana );
		memberbean.setMemberZipCode( memberZipCode );
		memberbean.setMemberAddress( memberAddress );
		memberbean.setMemberPhoneNumber( memberPhoneNumber );
		memberbean.setMemberBirthday( memberBirthday );//�K�v�Ȃ��H
		memberbean.setMemberEmail( memberEmail );
		memberbean.setMemberPassword( memberPassword );//�K�v�Ȃ��H
		memberbean.setMemberStatusId( memberStatusId );
		
		OraMemberDao memberdao = new OraMemberDao();
		//member����o�^������dao�̃C���X�^���X�𐶐�
		
		memberdao.registMember( memberbean );
		
		ResponceContext resc = new WebResponceContext();
		resc.setTarget( "payinput" );
		//�x����������͂���y�[�W�Ɉړ��H
		return resc;
	}
}
/**

	

*/