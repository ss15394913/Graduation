/*
@author 池田千鶴
@date 2017/02/28
*/

package command;

import java.util.HashMap;
import java.util.List;

import bean.MemberBean;
import dao.AbstractDaoFactory;
import dao.MemberDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.ResponseContext;

/* 会員情報変更の為、現在登録してある情報を取得するコマンド */
public class ShowUserConfigCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		HashMap<String, Object> memberData = new HashMap();

		try{
			/* 会員表のリストを取得 */
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			MemberDao memberdao = factory.getMemberDao();
			List memberlist = memberdao.getMembers();

			/* セッションからmember_idを取得 */
			String mi = (String)getRequestContext().getSessionAttribute("login");
			int memberid = Integer.parseInt(mi);

			/* セッションに登録されたmember_idと一致したデータを取得 */
			MemberBean member  = new MemberBean();
			for(int i = 0; i < memberlist.size(); i++){
				member = (MemberBean)memberlist.get(i);
				if(member.getMemberId() == memberid) {
					break;
				}
			}

			/* 表示用にデータを編集し、Mapに登録 */
			String[] name = member.getMemberName().split("\\s"); //半角スペース
			memberData.put("fName", name[0]);
			memberData.put("lName", name[1]);

			String[] kana = member.getMemberKana().split("\\s");
			memberData.put("fKana", kana[0]);
			memberData.put("lKana", kana[1]);

			String[] add = member.getMemberAddress().split("\\s");
			memberData.put("add1", add[0]);
			memberData.put("add2", add[1]);
			memberData.put("add3", add[2]);
			memberData.put("add4", add[3]);

			String birth = member.getMemberBirthday().replaceAll("/","-");
			memberData.put("birth", birth);

			memberData.put("post", member.getMemberZipCode());
			memberData.put("phone", member.getMemberPhoneNumber());
			memberData.put("email", member.getMemberEmail());

		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}

		/* 表示用データのセット */
		responseContext.setResult(memberData);

		responseContext.setTarget("userconfig");

		return responseContext;
	}
}