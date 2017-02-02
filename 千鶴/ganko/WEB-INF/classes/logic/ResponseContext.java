package logic;

/**
 *@className ResponseContext
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description ���X�|���X�Ɋւ���N���X�̃��b�p�[�N���X
 */
public interface ResponseContext {
	
	/**
	 *@see ResponseContext#getResult
	 *@return �R�}���h�̎��s����
	 */
	public Object getResult();
	
	/**
	 *@see ResponseContext#getTarget
	 *@return �]�����URL���
	 */
	public String getTarget();
	
	/**
	 *@see ResponseContext#setResult
	 *@param bean �R�}���h�̎��s���ʂ�Ԃ����߂�bean
	 */
	public void setResult(Object bean);
	
	/**
	 *@see ResponseContext#setTarget
	 *@param transferinfo �]�����jsp�t�@�C���̊g���q���������t�@�C����
	 */
	public void setTarget(String transferInfo);
	
	/**
	 *@see ResponseContext#setResponse
	 *@param object ���X�|���X�̍ۂɕK�v�ȏ��
	 */
	public void setResponse(Object object);
	
	/**
	 *@see ResponseContext#getResponse
	 *@return ���X�|���X���
	 */
	public Object getResponse();
}