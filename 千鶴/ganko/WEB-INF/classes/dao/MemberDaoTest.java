/*
  @ author �r�c��a
*/

package dao;

import bean.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

/*OraMemberDao�e�X�g�p�̃N���X�ł�*/
class MemberDaoTest {
	public static void main(String args[]) {
		/*���̕��@�Ŏ擾�������t������Ő��������t����͂ł��邱�Ƃ��m�F����*/
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat fo=new SimpleDateFormat("yyyy/MM/dd");
		String date=fo.format(cal.getTime());
		/*�V�����e�X�g����̏���Bean�ɓ����*/
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
		
		/*registMember�̃e�X�g�A�e�X�g�����\�ɒǉ�*/
		MemberDao md = new OraMemberDao();
		try{
			md.registMember(mb);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*getMembers�̃e�X�g*/
		List list = null;
		try{
			list = md.getMembers();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*ID1�̉���̏��𓾂�*/
		MemberBean currentMember = null;
		Iterator it = list.iterator();
		while(it.hasNext()){
			currentMember = (MemberBean)it.next();
			if(currentMember.getMemberId() == 1)break;
		}
		
		/*ID1�̉���̏���ύX����*/
		currentMember.setMemberAddress("edited");
		currentMember.setMemberEmail("edited");
		
		/*editMember�̃e�X�g*/
		try{
			md.editMember(currentMember);
		}catch(Exception e){
			e.printStackTrace();
		}
		/*Address��Email���ύX���ꂽ���Ƃ��m�F�ł���*/
	}
}