/*
  @author 池田千鶴
  @date 2017/02/02
*/

package command;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/* ログアウトコマンド */
public class LogOutCommand extends AbstractCommand {
	/* ログアウトボタンが押されたら、セッションに登録してある
		ログイン情報とログイン時に使用した移動先情報を削除 */
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		System.out.println("--LogOutCommand--");

		RequestContext reqc = getRequestContext();

		reqc.removeSessionAttribute("login");
		reqc.removeSessionAttribute("target");
		reqc.removeSessionAttribute("cart");

		/* 完了画面へ移動する */
		responseContext.setTarget("logoutcomp");

		return responseContext;
	}
}