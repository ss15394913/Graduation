/*
  @author ŒE“c—yŒŽ
  @date 2017/02/07
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;

public class ShowTopCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		
		responseContext.setTarget("top");
		
		return responseContext;
	}
}