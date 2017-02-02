package logic;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;
/**
 *@className FrontServlet
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description ���ׂẴ��N�G�X�g���󂯎��T�[�u���b�g
 */
public class FrontServlet extends HttpServlet {
	
	/**
	 *@see ApplicationControllerFactory#getController
	 *@param req
	 *@param res
	 *@exception ServletException
	 *@exception IOException
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException {
		doPost(req, res);
	}
	
	
	/**
	 *@see ApplicationControllerFactory#getController
	 *@param req
	 *@param res
	 *@exception ServletException
	 *@exception IOException
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		try {		
			ApplicationController ac
			= ApplicationControllerFactory.getController("Web");
			
			RequestContext requestContext = ac.getRequest(req);
			
			ResponseContext responseContext = ac.handleRequest(requestContext);
			
			responseContext.setResponse(res);
			
			ac.handleResponse(requestContext, responseContext);
		}catch (LogicException e) {
			throw new ServletException(e.getMessage(), e);
		}
	}
}