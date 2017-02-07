/*
  @author 窪田遥月
  @date 2017/02/07
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;

/* ただ飛ばすマンのひな形コマンド */
public class ShowSiteMapCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		
		responseContext.setTarget("sitemap");
		
		return responseContext;
	}
}