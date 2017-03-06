/*
  @author 窪田遥月
   @date 2017/02/07
*/

package command;

import ex.LogicException;
import ex.IntegrationException;
import logic.RequestContext;
import logic.ResponseContext;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class ShowCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
	
		RequestContext reqestContext = getRequestContext();
		
		HashMap<String,String> cardInfo = new HashMap<String,String>();
		
		cardInfo.put("cardInfo",new String("cartpresence"));
		
		responseContext.setTarget("cart");
		
		return responseContext;
	}
}