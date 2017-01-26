package logic;

import javax.servlet.http.HttpServletResponse;

/**
 *@className WebResponseContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description HTTP�ʐM�̍ۂ̃��X�|���X���̃��b�p�[�N���X
 */
public class WebResponseContext implements ResponseContext {
	/**�R�}���h�̎��s����*/
	private Object result;
	/**�]�����URL*/
	private String target;
	/**HTTPServlet�ł̃��X�|���X���*/
	private HttpServletResponse response;
	
	/**
	 *@see WebResponseContext#WebResponseContext
	 *@return ���g��\���C���X�^���X
	 */	
	public WebResponseContext() {}
	
	/**
	 *@see WebResponseContext#setTarget
	 *@param transferinfo �]�����jsp�t�@�C���̊g���q���������t�@�C����
	 */
	public void setTarget(String transferInfo) {
		target = "/WEB-INF/jsp/" + transferInfo + ".jsp";
	}
	
	/**
	 *@see WebResponseContext#getTarget
	 *@return �]�����URL���
	 */
	public String getTarget() {
		return target;
	}
	
	/**
	 *@see WebResponseContext#setResult
	 *@param bean �R�}���h�̎��s���ʂ�Ԃ����߂�bean
	 */
	public void setResult(Object bean) {
		result = bean;
	}
	
	/**
	 *@see WebResponseContext#getResult
	 *@return �R�}���h�̎��s����
	 */
	public Object getResult() {
		return result;
	}
	
	/**
	 *@see WebResponseContext#getResponse
	 *@return ���X�|���X���
	 */
	public Object getResponse() {
		return response;
	}
	
	/**
	 *@see WebResponseContext#setResponse
	 *@param object ���X�|���X�̍ۂɕK�v�ȏ��
	 */
	public void setResponse(Object response){
		this.response = (HttpServletResponse) response;
	}
}