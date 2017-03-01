package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.ProductImageBean;
import bean.ProductInformationBean;
import dao.AbstractDaoFactory;
import dao.ProductImageDao;
import dao.ProductInformationDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;


/**
 *@className AddCartCommand
 *@author 塩澤
 *@date 2017/03/01
 *@author kubota
 *@date 2017/02/19
 *@description
	cart(map)こいつは消える
 	 Products(商品List)
	  productInformation(商品のいろんな情報を登録したmap)
 */
public class AddCartCommand extends AbstractCommand{
	
	public AddCartCommand(){}
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		RequestContext req = getRequestContext();
		
		try{
			/*一時的にProductIdを入れておくString*/
			String tempProductId = null;
			
			/*商品詳細ページで選択された商品の、商品IDがカートに追加される*/
			String searchProductId = req.getParameter( "productid" )[0];
			System.out.println("searchProductIdは"+searchProductId);
			
			/*商品詳細ページで選択された商品の注文個数が入る*/
			String itemCount = req.getParameter( "itemcount" )[0];
			System.out.println("itemcountは"+itemCount);
			
			/*商品情報Map、中には商品の情報が入る*/
			Map<String,String> productInformation = new HashMap<String,String>();
			
			/*最終的にsessionへ送るMap、中にはArrayListが入る*/
			Map<String,Object> cart;
			
			/*商品情報Mapを複数入れるArrayList*/
			List products = new ArrayList();
			
			/*ループさせるときに使うString*/
			String loopS = "-1";
			String flag = "ng";
			
			/*セッションにcartがあるか判断*/
			if(req.getSessionAttribute( "cart" ) != null ){
				System.out.println("cartある");
				
				/*セッションにcartが存在しているので、とってくる*/
				cart = (HashMap<String,Object>)req.getSessionAttribute( "cart" );
				/*cartの中にあるproductsをとってくる*/
				products = (ArrayList)cart.get("products");
				
					for(int i = 0;i < products.size();i++){
						/*すでに存在しているprodutsをaに入れる*/
						Map<String,String> a = new HashMap<String,String>();
						a = (HashMap)products.get(i);
						System.out.println("すでに中身あるかなー？:"+a.get("productId"));
						/*aの中のproductIdをloopSに入れる*/
						if(a != null){
							loopS = a.get("productId");
						}else{
							System.out.println("nullなんだよなぁ");
						}
						
						System.out.println("これはloopS:"+loopS);
						System.out.println("これはsearchProductId:"+searchProductId);
						
						/*for文で回されているloopSの中に、商品詳細ページから追加を選択された商品のproductIdで、すでに存在しているカート内に同じproductIdを持っている商品が無いか探す。
						すでにproductIdが登録されていた場合は注文数のみの変更になる*/
						if(loopS.equals(searchProductId)){
							req.setSessionAttribute("str",new String("選択された商品はすでに追加されているので、注文数のみ変更しました。"));
							/*jspに表示する*/
							/*商品の注文個数だけ変更（上書き）*/
							productInformation.put("count",itemCount);
							
							products.add(productInformation);
							cart.put("products",products);
							
							/*カート内に商品がすでに存在するので、商品注文数を変更し、カート追加処理は行わないようにngにする*/
							flag = "ng";
							
							break;
						}
						flag = "ok";
					}
				}else{
					flag = "ok";
					System.out.println("cartない");
					
					/*セッションにcartが無い場合は新しくcartを作る*/
					cart = new HashMap<String,Object>();
					products = new ArrayList();
					
					/*新しく作ったcartをセッションへ登録*/
					req.setSessionAttribute( "cart" , cart );
				}
				
				/*カート内に商品を入れる*/
				if(flag.equals("ok")){
						req.setSessionAttribute("str",new String("商品を追加しました"));
					
					AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
					
					ProductInformationDao productDao = factory.getProductInformationDao();
					ProductImageDao productImageDao = factory.getProductImageDao();
					/*ProductInformationDaoとProductImageDaoを利用*/
					
					List allProducts = productDao.getProductInformations();
					List productImages = productImageDao.getProductImages();
					/*表のデータを取得*/
					
					Iterator itePInfo = allProducts.iterator();
					Iterator itePImage = productImages.iterator();
					/*iteratorを作成する*/
					while( itePInfo.hasNext() ){
						
						ProductInformationBean pinfob = (ProductInformationBean)itePInfo.next();
						/*一時変数に格納*/
						tempProductId = pinfob.getProductId();
						
						/*idが一致したらproductInformationに商品の情報を入れていく*/
						if(searchProductId.equals( tempProductId )){
							System.out.println(pinfob.getProductName());
							productInformation.put("productId",pinfob.getProductId());
							productInformation.put("productName",pinfob.getProductName());
							productInformation.put("productPrice",String.valueOf(pinfob.getProductPrice()));
							productInformation.put("productSize",pinfob.getProductSize());
							productInformation.put("productColor",pinfob.getProductColor());
							break;
						}
					}
				while( itePImage.hasNext() ){
					/*商品の画像をとってくるためにProductImageBeanを使用*/
					ProductImageBean pimageb = (ProductImageBean)itePImage.next();
					/*productidを格納*/
					String productId_image = pimageb.getProductId();
					
					/*上で取ってきたtempProductIdと同じproductIdの画像を探す*/
					if(productId_image.equals( tempProductId )){
						
						/*productIdが一致した画像の画像パスをproductInformationへ入れる*/
						productInformation.put( "productImagePath" ,pimageb.getProductImagePath());
						break;
					}
				}
				/*商品の注文個数をproductInformationへ入れる*/
				productInformation.put("count",itemCount);
				
				/*商品の情報が入ったproductInformationをproductsへ追加*/
				products.add(productInformation);
				
				/*Map型の商品情報が複数入っているproductsをcartへ入れる*/
				cart.put("products",products);
			}
			
			/*こっちで登録すれば上手く動いた*/
			req.setSessionAttribute( "cart" , cart );
			
		}catch(IntegrationException e){
			e.printStackTrace();
		}
		
		/*商品をカートへ追加しましたページに飛ばす*/
		responseContext.setTarget("addcart");
		
		return responseContext;
	}
}