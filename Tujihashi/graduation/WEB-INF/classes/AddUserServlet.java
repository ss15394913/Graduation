import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.SQLException;

import dba.Accessor;
import bean.MemberBean;

public class AddUserServlet extends HttpServlet{
	//ArrayList���g�p
	private ArrayList<MemberBean> users = new ArrayList<MemberBean>();
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g�ŃG���R�[�h�������̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������B
		req.setCharacterEncoding("Windows-31J");
		
		//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
		String firstName = req.getParameter("lastName");
		String lastName = req.getParameter("firstName");
		String memberKana = req.getParameter("memberKana");
		String memberZipCode = req.getParameter("memberZipCode");
		//���͗���������Ă���A�h���X���܂Ƃ߂�
		//String memberAddress = req.getParameter("Address");
		String  prefectures= req.getParameter("prefectures");
		String  municipality= req.getParameter("municipality");
		String  address= req.getParameter("address");
		String  buildingName= req.getParameter("buildingName");
		
		String memberPhoneNumber = req.getParameter("memberPhoneNumber");
		String memberBirthday = req.getParameter("memberBirthday");
		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");//�� 2017-01-11
		//String date=sdf.format();
        // Date�^�ϊ�
        Date formatDate = null;
		try{
		formatDate = sdf.parse(memberBirthday);
		}catch(Exception e){
			e.getMessage();
		}
		
		//int memberStatusId = Integer.parseInt(req.getParameter("memberStatusId"));
		
		String memberName=(firstName +" "+ lastName);
		String memberAddress =(prefectures + municipality + address + buildingName);
		
		
		//MemberBean���C���X�^���X�����A�f�[�^���Z�b�g����
		MemberBean user = new MemberBean();
		System.out.println("7");
		//���ID��setter
		//user.setMemberId(memberId);
		//������setter
		user.setMemberName(memberName);
		//�J�i��setter
		user.setMemberKana(memberKana);
		//�X�֔ԍ���setter
		user.setMemberZipCode(memberZipCode);
		//�Z����setter
		user.setMemberAddress(memberAddress);
		user.setMemberPhoneNumber(memberPhoneNumber);
		//���N������setter
		user.setMemberBirthday(memberBirthday);
		//�d�b�ԍ���setter
		user.setMemberEmail(memberEmail);
		//�p�X���[�h��setter
		user.setMemberPassword(memberPassword);
		System.out.println("8");
		//user.setMemberStatusId(memberStatusId);
	
	
		//DB�ɐڑ�����N���X���C���X�^���X������
		Accessor accessor = new Accessor();
		//DB�ɐڑ�
		accessor.connect();
		System.out.println("5");
		
		//insert����----------------------------------------------------------------------
		String sql = "INSERT INTO member VALUES(member_id_seq.NEXTVAL,'"+memberName+"','"+memberKana+"','"+memberZipCode+"','"+memberAddress+"','"+memberPhoneNumber+"','"+formatDate+"','"+memberEmail+"','"+memberPassword+"',1)";
		/*try{
			
		}catch(SQLException e){
			System.out.println("�������FSQLException");
		}*/
		//DB����ؒf
		
		System.out.println("6");
		accessor.write(sql);
		System.out.println("noooooooooooo");
		accessor.commit();
		System.out.println("yaaaaaaa");
		accessor.close();
		System.out.println("9");
		//���X�g�ɒǉ�����
		users.add(user);
		//HttpServletRequest�̎����N���X�̃C���X�^���X��users�Ƃ������O�Ńf�[�^��o�^����
		req.setAttribute("users",users);
		System.out.println("0");
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾����
		//�����͓]�����URL 
		RequestDispatcher dispatcher = req.getRequestDispatcher("userslist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}

