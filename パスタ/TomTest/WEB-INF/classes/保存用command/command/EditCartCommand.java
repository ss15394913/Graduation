package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.ResponseContext;

import javax.servlet.http.HttpSession;


/**
 *@className EditCartCommand
 *@author ���V
 *@date 2017/01/31
 *@description 
 */
/*
�J�[�g�ɓo�^���ꂽ���i���폜����Command
*/
public class EditCartCommand extends AbstractCommand{

	public EditCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = getRequestContext();
		
		
		HttpSession session = (HttpSession)req.getSession();
		
		String listNumberString = req.getParameter("listNumber")[0];
		int listNumberInt = -1;
		
		/*
		�J�[�g���̏��i���폜����ۂɁA�폜���鏤�i��I�Ԃ�null���Ԃ�
		�Ή����邽�߂Ɉ�Unull�����String������
		*/
		String checkString = listNumberString;
		int checkInt=0;
		System.out.println("�����܂�");
		/*
		���g��null�̏ꍇ0�ł͂Ȃ�-1�ŏ㏑������
		*/
		if(checkString == null){
			checkInt = -1;
		}
		
		/*
		��Őݒ肵��null�ꍇ��-1��������A�J�[�g���ɏ��i���܂����݂��Ȃ��̂�
		�폜���镶�����s�����Ȃ��B
		*/
		if(0 <= checkInt){
			listNumberInt = Integer.parseInt(listNumberString);
		}else{
			System.out.println("�폜���鏤�i��I�����ĂˁI");
		}
		
		System.out.println(listNumberInt+"�Ă���@servlet��");
		
		
		String removeResultNumber = "result" + listNumberString;
		System.out.println(removeResultNumber+":::�Ă���");
		
		session.removeAttribute(removeResultNumber);
		
		responseContext.setTarget("cart");
		/**
		 *@see ResponseContext#init
		 *@param req �N���C�A���g����̃��N�G�X�g
		 */
		return responseContext;
	}
}

