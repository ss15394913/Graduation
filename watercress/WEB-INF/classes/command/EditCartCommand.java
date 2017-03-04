/*
  @author 塩澤麻人
   @date 2017/02/13
*/
/*
	memo
	ProductInfomationのbeanとdaoを使う
	カート内に表示する商品の情報を取ってくる
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

public class EditCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		try{
			RequestContext req = getRequestContext();
			
			List cart = new ArrayList();
			/*商品名と商品個数を入れるcartを作成*/
			if(req.getSessionAttribute("cart") == null){
				req.setSessionAttribute("cart",cart);
			}else{
				cart = (ArrayList)req.getSessionAttribute("cart");
			}
			
			/*一時的にProductIdを入れておくString*/
			String tempProductId = null;

			/*商品詳細ページで選択された商品の、商品IDがカートに追加される*/
			String searchProductId = req.getParameter( "productid" )[0];

			/*商品詳細ページで選択された商品の注文個数が入る*/
			String itemCount = req.getParameter( "itemcount" )[0];
			
			
			
			//セッションのcartに登録されたidをsearchIdに入れ、データベースからとってきたgetIdと比べるための変数
			String getId = null;
			String searchId = null;
			String loopS = "-1";
			
			
			//cartの中からproductidのみをlistへ入れる
			List<String> productImagePath = new ArrayList<String>();
			List<String> productId = new ArrayList<String>();
			
			Map<String,String> productInformation = new HashMap<String,String>();
			//Map<String,Object> returnProducts = new HashMap<String,Object>();
			
			/*
			下のfor文でcart内のkey値に登録したprodctidのみ取り出して
			listに追加していく
			*/
			
			
			
			//cartの中にある商品の数だけループ
			cart = (ArrayList)req.getSessionAttribute( "cart" );
			for(int i = 0;i < cart.size();i++){
				/*
				中身は実質productInformationと同じMap
				produtInformationを使うとおかしくなるので
				localのMapを使う
				*/
				Map<String,String> localM = new HashMap<String,String>();
				/*
				cart内に入っているMapを取ってくる
				*/
				localM = (HashMap)cart.get(i);
				loopS = localM.get("productId");
				//cart.remove(i);
				/*for文で回されているloopSの中に、商品詳細ページから追加された商品のproductIdで、すでに存在しているカート内に同じproductIdを持っている商品が無いか探す。
				すでにproductIdが登録されていた場合は注文数のみの変更になる*/
				if(loopS.equals(searchProductId)){
					
					
					
					/*商品の注文個数だけ変更（上書き）*/
					localM.put("count",itemCount);
					req.setSessionAttribute("str",new String("注文数を"+itemCount+"個に変更しました。"));

					/*そのすでに存在しているproductIdを持っているproductInformationに、商品注文数のみ変更したlocalMで上書き*/
					productInformation = localM;
					
					/*下のところでcart.addしてたのが間違い*/
					cart.set(i, productInformation);
					req.setSessionAttribute( "cart" , cart );
					
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		responseContext.setTarget("carteditcomp");
			
		return responseContext;
	}
}