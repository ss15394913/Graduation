package logic;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *@className WebRequestContext
 *@author Fumihiro Miyazaki
 *@date 2017/02/01
 *@description HTTP�ʐM�̃��N�G�X�g�������b�v����N���X
 */
public class WebRequestContext implements RequestContext {
	/**�T�[�u���b�g�p�X���A�R�}���h�����p�̕�����ɕϊ����邽�߂̒萔*/
	private static final int REMOVE_SLASH = 1;
	/**���N�G�X�g�Ɋ܂܂��e�p�����[�^*/
	private Map parameters;
	/**HTTPServlet�ł̃��N�G�X�g���*/
	private HttpServletRequest request;
	/**HTTPServlet�ł̃Z�b�V�������*/
	private HttpSession session;
	
	/**
	 *@see WebRequestContext#WebRequestContext
	 *@return ���g��\���C���X�^���X
	 */	
	public WebRequestContext() {}
	
	/**
	 *@see WebRequestContext#getCommandPath
	 *@return ���s����R�}���h�̃p�X����Ԃ�
	 */
	public String getCommandPath() {
		String servletPath = request.getServletPath();
		
		String commandPath = servletPath.substring(REMOVE_SLASH);
		
		return commandPath;
	}
	
	/**
	 *@see WebRequestContext#getParameter
	 *@param key �N���C�A���g����̃��N�G�X�g�̃p�����[�^�ɑΉ������L�[�l
	 *@return �L�[�l�ɑΉ������p�����[�^
	 */
	public String[] getParameter(String key) {
		return (String[]) parameters.get(key);
	}
	
	/**
	 *@see WebRequestContext#getRequest
	 *@return �N���C�A���g����̃��N�G�X�g���
	 */
	public Object getRequest() {
		return request;
	}
	
	/**
	 *@see WebRequestContext#setRequest
	 *@param request �N���C�A���g����̃��N�G�X�g���
	 */
	public void setRequest(Object request) {
		this.request = (HttpServletRequest)request;
		
		session = this.request.getSession();
		
		parameters = this.request.getParameterMap();
	}
	
	/**
	 *@see WebRequestContext#setSessionAttribute
	 *@param key �Z�b�V�����X�R�[�v�ɓo�^�������l�ɁA�Ή������L�[�l
	 *@param value �Z�b�V�����X�R�[�v�ɓo�^�������l
	 */
	public void setSessionAttribute(String key, Object value) {
		session.setAttribute(key, value);
	}

	/**
	 *@see WebRequestContext#getSessionAttribute
	 *@return �Z�b�V�����ɓo�^����Ă���A�L�[�l�ɑΉ������l
	 */
	public Object getSessionAttribute(String key) {
		return session.getAttribute(key);
	}
}