package logic;

import ex.LogicException;
import javax.servlet.ServletException;
import java.io.IOException;
/**
 *@className ApplicationControllerFactory
 *@author Fumihiro Miyazaki
 *@date 2017/01/26
 *@description ���䃍�W�b�N�����s����N���X�̃C���^�[�t�F�[�X
 */
public interface ApplicationController {
	/**
	 *@see ApplicationController#getRequest
	 *@param request �N���C�A���g���瑗��ꂽ���N�G�X�g���
	 *@return ���N�G�X�g�������b�v�����ARequestContext�̃T�u�N���X
	 */
	RequestContext getRequest(Object request);

	/**
	 *@see ApplicationController#handleRequest
	 *@param requestContext �N���C�A���g����̃��N�G�X�g
	 *@return �R�}���h�̎��s����
	 *@exception LogicException �r�W�l�X���W�b�N���C���Ŕ���������O�̃��b�p�[
	 */
	ResponseContext handleRequest (RequestContext requestContext)
	throws LogicException;
	
	/**
	 *@see ApplicationController#handleResponse
	 *@param requestContext �N���C�A���g����̃��N�G�X�g���
	 *@param responseContext �R�}���h�n�N���X�̎��s����
	 *@exception ServletException
	 *@exception IOException
	 */
	void handleResponse(RequestContext requestContext,
						ResponseContext responseContext)
	throws ServletException, IOException;
}