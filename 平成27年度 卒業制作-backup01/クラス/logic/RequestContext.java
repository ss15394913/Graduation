package logic;

/**
 *@className RequestContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/25
 *@description ���N�G�X�g�Ɋւ���N���X�̃��b�p�[�N���X
 */
public interface RequestContext {
	
	/**
	 *@see RequestContext#getCommandPath
	 *@return ���s����R�}���h�̃p�X����Ԃ�
	 */
	public String getCommandPath();
	
	/**
	 *@see RequestContext#getParameter
	 *@param key �N���C�A���g����̃��N�G�X�g�̃p�����[�^�ɑΉ������L�[�l
	 *@return �L�[�l�ɑΉ������p�����[�^
	 */
	public String[] getParameter(String key);
	
	/**
	 *@see RequestContext#getRequest
	 *@return �N���C�A���g����̃��N�G�X�g���
	 */
	public Object getRequest();
	
	/**
	 *@see RequestContext#setRequest
	 *@param request �N���C�A���g����̃��N�G�X�g���
	 */
	public void setRequest(Object request);
}