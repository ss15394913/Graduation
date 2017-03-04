package logic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex.LogicException;
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
		req.setCharacterEncoding("UTF-8");
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