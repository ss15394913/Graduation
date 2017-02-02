package command;

import logic.RequestContext;
import logic.ResponseContext;
import ex.LogicException;

/**
 *@className AbstractCommand
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description 
 */
public abstract class AbstractCommand{
	/**�N���C�A���g����̃��N�G�X�g*/
	private RequestContext requestContext;
	
	/**
	 *@see ResponseContext#init
	 *@param requestContext �N���C�A���g����̃��N�G�X�g
	 */
	public void init(RequestContext requestContext){
		this.requestContext = requestContext;
	}
	
	/**
	 *@see ResponseContext#getRequestContext
	 *@return �N���C�A���g����̃��N�G�X�g
	 */
	public RequestContext getRequestContext(){
		return requestContext;
	}
	
	/**
	 *@see ResponseContext#execute
	 *@param responseContext ���s���ʂ����b�v���邽�߂�
							 ResponseContext�̃T�u�N���X�̃C���X�^���X
	 *@return ���s���ʂ����b�v����ResponseContext�̃T�u�N���X�̃C���X�^���X
	 *@exception LogicException �r�W�l�X���W�b�N���C���Ŕ���������O�̃��b�p�[
	 */
	public abstract ResponseContext execute(ResponseContext responseContext)throws LogicException;
}