package command;

import ex.LogicException;
import ex.IntegrationException;

import logic.RequestContext;
import logic.WebRequestContext;
import logic.ResponseContext;




import java.util.Map;
import java.util.HashMap;


/**
 *@className AddProductsToCartCommand
 *@author ���V
 *@date 2017/01/31
 *@description 
 *@���i��map�œo�^����
 */
public class AddProductsToCartCommand extends AbstractCommand{
	
	public AddProductsToCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		
		RequestContext req = new WebRequestContext();
		Map<String,String> cart;
		/*���i���Ə��i��������cart���쐬*/
		if(req.getSessionAttribute("cart") == null){
			cart = new HashMap<String,String>();
		}else{
			cart = (Map<String,String>)req.getSessionAttribute("cart");
		}
		
		/*����\���ꂽ�p�����[�^���󂯎��*/
		String productId = req.getParameter("productid")[0];
		String itemCount =req.getParameter("itemcount")[0];
		
		/*
		���i�Ə��i�̌���cart�ɓo�^
		cart.put("key","value");
		�܂������������i��ǉ������ꍇ�Ƃ肠������O��
		����Ɋ���
		*/
		if(cart.containsKey(productId) == true){
			cart.put(productId,itemCount);
		}else{
			System.out.println("�ǉ����鏤�i���d�����Ă܂���O���΂�");
		}
		
		/*map�̕ϐ�cart��cart���Ė��O��cart.jsp�ɔ�΂�*/
		req.setSessionAttribute("cart", cart);
		//�J�[�g�ɏ��i���ƌ���o�^���܂����y�[�W�֔�Ԃ��ǁA�܂�����
		responseContext.setTarget("showAddProductComp");
		
		return responseContext;
	}
}