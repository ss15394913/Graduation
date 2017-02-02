import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;


/*こいつはログインしているユーザーのIDをセッションから手に入れて
そのユーザーIDのステータスを退会済みに変える*/
/*塩澤*/
public class LeaveServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		
		
		req.setCharacterEncoding("Windows-31J");
		
		HttpSession session = req.getSession();
		
		OraAccessor OraAc = new OraAccessor();
		
		
		int id=1;
		//まだ未完成なのでsession（笑）の中のid
		session.setAttribute("member_id", id);
		
		//sessionからidを取り出す
		id = (int)session.getAttribute("member_id");
		//退会に変更するsql文
		String sql = 
		"update member set member_status_id = 2 where member_id = " + id;
		
		//OracleAccessorのwriteにsql文を渡す
		OraAc.write(sql);
		
		
		
		
		
		/*左から、ID、名前、フリガナ、郵便番号、住所、電話番号、
		誕生日、メールアドレス、パスワード、会員の登録状態
		INSERT INTO member
		VALUES(member_id_seq.NEXTVAL,'test name','test kana',
		'0001111','test_address','0001110000',SYSDATE,'test@test.test',
		'test_pass',9);
		*/
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/leave");
		
		rd.forward(req,res);
	}
}