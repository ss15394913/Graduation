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
	cart(List)
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

			/*商品詳細ページで選択された商品の注文個数が入る*/
			String itemCount = req.getParameter( "itemcount" )[0];

			/*カートの有無を判断するflag*/
			String flag = "ok";

			/*productIdが入る*/
			String loopS = "-1";
			
			/*存在しないproductIdが入った場合*/
			String noProductId = "ないよ";

			/*商品情報Map、中には商品の情報が入る*/
			Map<String,String> productInformation = new HashMap<String,String>();
			/*商品情報Mapを複数入れるArrayList*/
			List cart = new ArrayList();

			/*セッションにcartがあるか判断*/
			if(req.getSessionAttribute( "cart" ) != null ){
				/*セッションにcartが存在しているので、とってくる*/
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
					
					/*for文で回されているloopSの中に、商品詳細ページから追加された商品のproductIdで、すでに存在しているカート内に同じproductIdを持っている商品が無いか探す。
					すでにproductIdが登録されていた場合は注文数のみの変更になる*/
					if(loopS.equals(searchProductId)){
						
						req.setSessionAttribute("str",new String("選択された商品はすでに追加されているので、注文数のみ変更しました。"));
						
						
						/*商品の注文個数だけ変更（上書き）*/
						localM.put("count",itemCount);
						
						/*そのすでに存在しているproductIdを持っているproductInformationに、商品注文数のみ変更したlocalMで上書き*/
						productInformation = localM;
						
						/*下のところでcart.addしてたのが間違い*/
						cart.set(i, productInformation);
						req.setSessionAttribute( "cart" , cart );
						/*カート内に商品がすでに存在するので、商品注文数を変更し、カート追加処理は行わないようにngにする*/
						flag = "ng";
						
						noProductId="ok";
						break;
					}
					noProductId="ng";
				}
			}
			/*カート内に商品を入れる*/
			if(flag.equals("ok")){
				req.setSessionAttribute("str",new String("商品を追加しました"));				AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
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
				cart.add(productInformation);
				/*こっちで登録すれば上手く動いた*/
				req.setSessionAttribute( "cart" , cart );
			}
		}catch(IntegrationException e){
			e.printStackTrace();
		}

		/*商品をカートへ追加しましたページに飛ばす*/
		responseContext.setTarget("cartaddcomp");

		return responseContext;
	}
}