/*
  @author 塩澤
   @date 2017/02/13
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


import bean.ProductImageBean;
import bean.ProductInformationBean;


import dao.AbstractDaoFactory;
import dao.ProductInformationDao;
import dao.ProductImageDao;
import dao.OraProductInformationDao;
import dao.OraProductImageDao;


import ex.LogicException;
import logic.ResponseContext;

public class DeleteCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		try{
			RequestContext req = getRequestContext();
			
			List cart = new ArrayList();
			/*cartを宣言*/
			
			if(req.getSessionAttribute("cart") == null){
				req.setSessionAttribute("cart",cart);
			}else{
				cart = (ArrayList)req.getSessionAttribute("cart");
			}
			
			/*一時的にproduct_idをいれる*/
			String tempProductId = null;

			/*商品のproduct_idをリクエストから取得*/
			String searchProductId = req.getParameter( "productid" )[0];
			
			String getId = null;
			String searchId = null;
			String loopS = "-1";
			
			List<String> productImagePath = new ArrayList<String>();
			List<String> productId = new ArrayList<String>();
			
			Map<String,String> productInformation = new HashMap<String,String>();
			/*商品を表すmapの宣言*/
			
			//cartのなかから、該当するproduct_idを持つ商品をカートから削除
			cart = (ArrayList)req.getSessionAttribute( "cart" );
			for(int i = 0;i < cart.size();i++){
				
				Map<String,String> localM = new HashMap<String,String>();
				
				localM = (HashMap)cart.get(i);
				loopS = localM.get("productId");
				
				if(loopS.equals(searchProductId)){
					req.setSessionAttribute("str",new String("商品を削除しました"));

					productInformation = localM;
					
					cart.remove(i);
					req.setSessionAttribute( "cart" , cart );
					
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		responseContext.setTarget("cartdeletecomp");
			
		return responseContext;
	}
}