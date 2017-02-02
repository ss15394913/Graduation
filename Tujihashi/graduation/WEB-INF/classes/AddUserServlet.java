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
	//ArrayListを使用
	private ArrayList<MemberBean> users = new ArrayList<MemberBean>();
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		//POST要求によって送信された文字列をクライアントでエンコードした時の文字コードを指定する
		//これを指定しないと文字化けする可能性がある。
		req.setCharacterEncoding("Windows-31J");
		
		//POST要求によって送信されたパラメータを取得する
		String firstName = req.getParameter("lastName");
		String lastName = req.getParameter("firstName");
		String memberKana = req.getParameter("memberKana");
		String memberZipCode = req.getParameter("memberZipCode");
		//入力欄が分かれているアドレスをまとめる
		//String memberAddress = req.getParameter("Address");
		String  prefectures= req.getParameter("prefectures");
		String  municipality= req.getParameter("municipality");
		String  address= req.getParameter("address");
		String  buildingName= req.getParameter("buildingName");
		
		String memberPhoneNumber = req.getParameter("memberPhoneNumber");
		String memberBirthday = req.getParameter("memberBirthday");
		String memberEmail = req.getParameter("memberEmail");
		String memberPassword = req.getParameter("memberPassword");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");//例 2017-01-11
		//String date=sdf.format();
        // Date型変換
        Date formatDate = null;
		try{
		formatDate = sdf.parse(memberBirthday);
		}catch(Exception e){
			e.getMessage();
		}
		
		//int memberStatusId = Integer.parseInt(req.getParameter("memberStatusId"));
		
		String memberName=(firstName +" "+ lastName);
		String memberAddress =(prefectures + municipality + address + buildingName);
		
		
		//MemberBeanをインスタンス化し、データをセットする
		MemberBean user = new MemberBean();
		System.out.println("7");
		//会員IDのsetter
		//user.setMemberId(memberId);
		//氏名のsetter
		user.setMemberName(memberName);
		//カナのsetter
		user.setMemberKana(memberKana);
		//郵便番号のsetter
		user.setMemberZipCode(memberZipCode);
		//住所のsetter
		user.setMemberAddress(memberAddress);
		user.setMemberPhoneNumber(memberPhoneNumber);
		//生年月日のsetter
		user.setMemberBirthday(memberBirthday);
		//電話番号のsetter
		user.setMemberEmail(memberEmail);
		//パスワードのsetter
		user.setMemberPassword(memberPassword);
		System.out.println("8");
		//user.setMemberStatusId(memberStatusId);
	
	
		//DBに接続するクラスをインスタンス化する
		Accessor accessor = new Accessor();
		//DBに接続
		accessor.connect();
		System.out.println("5");
		
		//insertする----------------------------------------------------------------------
		String sql = "INSERT INTO member VALUES(member_id_seq.NEXTVAL,'"+memberName+"','"+memberKana+"','"+memberZipCode+"','"+memberAddress+"','"+memberPhoneNumber+"','"+formatDate+"','"+memberEmail+"','"+memberPassword+"',1)";
		/*try{
			
		}catch(SQLException e){
			System.out.println("えぐぜ：SQLException");
		}*/
		//DBから切断
		
		System.out.println("6");
		accessor.write(sql);
		System.out.println("noooooooooooo");
		accessor.commit();
		System.out.println("yaaaaaaa");
		accessor.close();
		System.out.println("9");
		//リストに追加する
		users.add(user);
		//HttpServletRequestの実装クラスのインスタンスにusersという名前でデータを登録する
		req.setAttribute("users",users);
		System.out.println("0");
		//RequestDispatcherインターフェイスを実装するクラスのインスタンスを取得する
		//引数は転送先のURL 
		RequestDispatcher dispatcher = req.getRequestDispatcher("userslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}

