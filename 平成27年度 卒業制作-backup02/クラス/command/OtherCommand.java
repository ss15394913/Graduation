/*
  @author �r�c���
  @date 2017/02/02
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;

/* ������΂��}���̂ЂȌ`�R�}���h */
public class OtherCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		
		responseContext.setTarget("�ǂ���");
		
		return responseContext;
	}
}