/*
  @author 池田千鶴
  @date 2017/02/13
*/

package command;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

public class ShowLogInCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		RequestContext reqc = getRequestContext();
		reqc.removeSessionAttribute("message1");
		reqc.removeSessionAttribute("message2");
		reqc.removeSessionAttribute("message3");

		responseContext.setTarget("login");
		return responseContext;
	}
}