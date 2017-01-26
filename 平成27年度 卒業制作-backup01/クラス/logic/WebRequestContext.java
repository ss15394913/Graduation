package logic;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *@className WebRequestContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description HTTP�ʐM�̃��N�G�X�g�������b�v����N���X
 */
public class WebRequestContext implements RequestContext {
	/**�T�[�u���b�g�p�X���A�R�}���h�����p�̕�����ɕϊ����邽�߂̒萔*/
	private static final int REMOVE_SLASH = 1;
	/**���N�G�X�g�Ɋ܂܂��e�p�����[�^*/
	private Map parameters;
	/**HTTPServlet�ł̃��N�G�X�g���*/
	private HttpServletRequest request;
	
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
		
		parameters = this.request.getParameterMap();
	}
}