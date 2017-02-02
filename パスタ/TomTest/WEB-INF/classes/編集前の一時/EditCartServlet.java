import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/*
カートの中の商品を削除できるServlet、商品情報はセッション内に
EditCart
*/
/*塩澤*/
public class EditCartServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		HttpSession session = req.getSession();
		/*入力されたパラメータを受け取る*/
		String listNumberString = req.getParameter("listNumber");
		int listNumberInt = -1;
		
		/*
		カート内の商品を削除する際に、削除する商品を選ぶとnullが返る
		対応するために一旦null判定のStringを挟む
		*/
		String checkString = listNumberString;
		int checkInt=0;
		System.out.println("ここまで");
		/*
		中身がnullの場合0ではなく-1で上書きする
		*/
		if(checkString == null){
			checkInt = -1;
		}
		
		/*
		上で設定したnull場合の-1がきたら、カート内に商品がまだ存在しないので
		削除する文を実行させない。
		*/
		if(0 <= checkInt){
			listNumberInt = Integer.parseInt(listNumberString);
		}else{
			System.out.println("削除する商品を選択してね！");
		}
		
		System.out.println(listNumberInt+"てすと@servlet内");
		
		
		String removeResultNumber = "result" + listNumberString;
		System.out.println(removeResultNumber+":::てすと");
		
		session.removeAttribute(removeResultNumber);
		
		RequestDispatcher rd = req.getRequestDispatcher("/kekka");
		
		rd.forward(req,res);
	}
}