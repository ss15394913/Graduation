/*
  @author 窪田遥月
   @date 2017/02/07
*/

package command;

import ex.LogicException;
import logic.ResponseContext;

public class ShowCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		responseContext.setTarget("cart");

		return responseContext;
	}
}