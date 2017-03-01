package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.ResponseContext;

import java.util.Map;
import java.util.HashMap;

/**
 *@className DeleteCartCommand
 *@author ���V
 *@date 2017/01/31
 *@description 
 */
/*
�J�[�g�ɓo�^���ꂽ���i���폜����Command
*/
public class DeleteCartCommand extends AbstractCommand{

	public DeleteCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = getRequestContext();
		
		/*
		�폜���������i���I�����ꂽ
		aLotOf�E�E�E���������
		*/
		String[] aLotOfProductId = req.getParameter("productid");
		String productId;
		Map<String,String> cart = (Map<String,String>)req.getSessionAttribute("cart");
		int checkNumber = 0;
		
		
		for ( int i =0;i < aLotOfProductId.length ;i++ ) {
			productId =  aLotOfProductId[i];
			/*
			�J�[�g���̏��i���폜����ۂɁA�폜���鏤�i���I�΂�Ă��Ȃ���null���Ԃ�
			�Ή����邽�߂Ɉ�Unull�����String������
			���g��null�̏ꍇ0�ł͂Ȃ�-1�ŏ㏑������
			*/
			if(productId == null){
				checkNumber = -1;
			}
			/*
			��Őݒ肵��null�ꍇ��-1��������A�J�[�g���ɏ��i���܂����݂��Ȃ��̂�
			�폜���镶�����s�����Ȃ��B
			*/
			if(0 <= checkNumber){
				if(cart.containsKey(productId) == true){
					cart.remove(productId);
					req.setSessionAttribute("cart",cart);
				}
			}else{
				System.out.println("�폜���鏤�i��I�����ĂˁI");
			}
		}
		responseContext.setTarget("cartdelete");
		
		return responseContext;
	}
}

