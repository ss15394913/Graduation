/*
  @ author 池田大和
*/

package dao;

import bean.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

/*OraMemberDaoテスト用のクラスです*/
class MemberDaoTest {
	public static void main(String args[]) {
		/*この方法で取得した日付文字列で正しく日付を入力できることを確認する*/
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat fo=new SimpleDateFormat("yyyy/MM/dd");
		String date=fo.format(cal.getTime());
		/*新しいテスト会員の情報をBeanに入れる*/
		MemberBean mb = new MemberBean();
		
		mb.setMemberName("hoge huga");
		mb.setMemberKana("hoge huga");
		mb.setMemberZipCode("2701111");
		mb.setMemberAddress("addr");
		mb.setMemberPhoneNumber("0430001111");
		mb.setMemberBirthday(date);
		mb.setMemberEmail("email");
		mb.setMemberPassword("pass");
		mb.setMemberStatusId(9);
		
		/*registMemberのテスト、テスト会員を表に追加*/
		MemberDao md = new OraMemberDao();
		try{
			md.registMember(mb);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*getMembersのテスト*/
		List list = null;
		try{
			list = md.getMembers();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*ID1の会員の情報を得る*/
		MemberBean currentMember = null;
		Iterator it = list.iterator();
		while(it.hasNext()){
			currentMember = (MemberBean)it.next();
			if(currentMember.getMemberId() == 1)break;
		}
		
		/*ID1の会員の情報を変更する*/
		currentMember.setMemberAddress("edited");
		currentMember.setMemberEmail("edited");
		
		/*editMemberのテスト*/
		try{
			md.editMember(currentMember);
		}catch(Exception e){
			e.printStackTrace();
		}
		/*AddressとEmailが変更されたことを確認できた*/
	}
}