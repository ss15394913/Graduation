package logic;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ex.LogicException;
import command.AbstractCommand;
/**
 *@className FrontServlet
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description HTTP�ʐM�p�̐��䃍�W�b�N���s�N���X
 */
public class WebApplicationController implements ApplicationController {
	
	/**
	 *@see WebApplicationController#getRequest
	 *@param request �N���C�A���g���瑗��ꂽ���N�G�X�g���
	 *@return ���N�G�X�g�������b�v�����ARequestContext�̃T�u�N���X
	 */
	public RequestContext getRequest(Object request) {
		RequestContext requestContext = new WebRequestContext();
		requestContext.setRequest(request);
		
		return requestContext;
	}
	
	/**
	 *@see WebApplicationController#handleRequest
	 *@param requestContext �N���C�A���g����̃��N�G�X�g
	 *@return �R�}���h�̎��s����
	 *@exception LogicException �r�W�l�X���W�b�N���C���Ŕ���������O�̃��b�p�[
	 */
	public ResponseContext handleRequest(RequestContext requestContext)
	throws LogicException {
		AbstractCommand command = CommandFactory.getCommand(requestContext);
		command.init(requestContext);
		
		ResponseContext responseContext
		= command.execute(new WebResponseContext());
		
		return responseContext;
	}
	
	/**
	 *@see WebApplicationController#handleResponse
	 *@param requestContext �N���C�A���g����̃��N�G�X�g���
	 *@param responseContext �R�}���h�n�N���X�̎��s����
	 *@exception ServletException
	 *@exception IOException
	 */
	public void handleResponse(RequestContext requestContext,
							   ResponseContext responseContext)
	throws ServletException, IOException {
		HttpServletRequest req
		= (HttpServletRequest) requestContext.getRequest();
		
		HttpServletResponse res
		= (HttpServletResponse) responseContext.getResponse();

		req.setAttribute("data", responseContext.getResult());
		
		RequestDispatcher requestDispatcher
		= req.getRequestDispatcher(responseContext.getTarget());
		
		requestDispatcher.forward (req, res);
	}
}