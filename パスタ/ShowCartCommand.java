/*
  @author ���V���l
   @date 2017/02/13
*/
/*
	memo
	ProductInfomation��bean��dao���g��
	�J�[�g���ɕ\�����鏤�i�̏�������Ă���
*/

package command;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import ex.LogicException;
import logic.ResponseContext;

public class ShowCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		RequestContext req = getRequestContext();
		HashMap<String,String> cartInfo = new HashMap<String,String>();
		if(req.getSessionAttribute( "cart" ) != null){
			System.out.println("cart����܂�if");
			cartInfo.put("cartInfo",new String("cartpresence"));
		}else{
			System.out.println("cart�Ȃ�������if");
			cartInfo.put("cartInfo",new String("noncartpresence"));
		}
		
		List cart = (ArrayList)req.getSessionAttribute( "cart" );
		Map<String,String> productInformation = new HashMap<String,String>();
		
		Map<String, Integer> countProductsInfo = new HashMap<String, Integer>()
		
		System.out.println("�J�[�g�̃T�C�Y��"+cart.size()+"�ł�");
		
		int totalprice = 0;
		//���i�̋��z�A�����������������̂̍��v���z��\��
		
		int productprice = 0;
		//1���i�̒P����\��
		
		int totalItemCount = 0;
		
		int ordercount = 1;
		//1���i�̒�������\��
		for(int i = 0;i<cart.size();i++){
			productInformation = (HashMap<String,String>)cart.get(i);
			
			productprice = Integer.parseInt((String)productInformation.get("productPrice"));
			
			ordercount = Integer.parseInt((String)productInformation.get("count"));
			totalItemCount += ordercount;
			totalprice += productprice * ordercount;
			
			countProductsInfo.put("totalItemCount",totalItemCount)
			countProductsInfo.put("totalprice",totalprice)
			
			System.out.println(i+"��ڂ̍��v���z��"+totalprice);
		}
		
		setResult("countProductsInfo",countProductsInfo);
		
		responseContext.setTarget("cart");
		
		return responseContext;
	}
}