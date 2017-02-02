package logic;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@className FrontServlet
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description すべてのリクエストを受け取るサーブレット
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
		
		ApplicationController ac
		= ApplicationControllerFactory.getController("Web");
		
		RequestContext requestContext = ac.getRequest(req);
		
		try {
			ResponseContext responseContext = ac.handleRequest(requestContext);
		}catch (LogicException e) {
			throw new ServletException(e.getMessage(), e);
		}
		
		responseContext.setResponse(res);
		
		applicationController.handleResponse(requestContext, responseContext);
	}
}