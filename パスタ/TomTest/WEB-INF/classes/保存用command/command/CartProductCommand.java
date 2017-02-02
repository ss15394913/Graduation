package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.WebRequestContext;
import logic.ResponseContext;

import javax.servlet.http.HttpSession;

/**
 *@className CartProductCommand
 *@author 塩澤
 *@date 2017/01/31
 *@description 
 */
public class CartProductCommand extends AbstractCommand{
	
	public CartProductCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		
		RequestContext req = new WebRequestContext();
		
		HttpSession session = (HttpSession)req.getSession();
		
		/*入力されたパラメータを受け取る*/
		String[] name = req.getParameter("name");
		
		/*セッションスコープに違うインスタンスを保存するための変数*/
		int maxNum; 
		
		/*初回のリクエスト時にmaxNumの値がNullか判定する*/
		/*Nullでない場合はmaxNumにその値を入れる*/
		if(session.getAttribute("maxNum") != null){
			maxNum = (int)session.getAttribute("maxNum");
		}else{
			maxNum = 0;
		}
		
		/*セッションスコープに入力されたパラメータが入ったインスタンスを保存*/
		session.setAttribute("result" + maxNum, name);
			/*セッションスコープに+1したmaxNumを保存*/
		session.setAttribute("maxNum", maxNum + 1);
		
		responseContext.setTarget("cart");
		System.out.println("最後の");
		return responseContext;
	}
}