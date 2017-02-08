/*
  @author 池田千鶴
  @date 2017/02/02
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;

/* ただ飛ばすマンのひな形コマンド */
public class OtherCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		
		responseContext.setTarget("どこか");
		
		return responseContext;
	}
}