package command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.ProductBean;
import bean.ProductImageBean;
import bean.PurchaseHistoryBean;
import dao.AbstractDaoFactory;
import dao.ProductDao;
import dao.ProductImageDao;
import dao.PurchaseHistoryDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className ShowOrderHistoryCommand
 *@author 河野
 *@date 2017/02/08
 *@description 購入履歴を表示
 */

public class ShowOrderHistoryCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext responseContext)
			throws LogicException{
		/*RequestContextのインスタンスを取得*/
		RequestContext requestContext = getRequestContext();

		/*getParameterでページ番号を取得*/
		Integer pageNum = 1;
		String[] pageParam = requestContext.getParameter("pageNum");
		if(pageParam != null){
			pageNum = Integer.parseInt(pageParam[0]);
		}
		/*memberIdを受け取る*/
		int memberId = Integer.parseInt(requestContext.getSessionAttribute("login").toString()) ;

		/*ページカウント用の変数*/
		int i=0;

		/*Product表のリストを全件取得のためのリスト*/
		List<ProductBean> allProducts = new ArrayList<ProductBean>();

		/*購入リストを全件取得のためのリスト*/
		List<PurchaseHistoryBean> allPurchaseProducts
		= new ArrayList<PurchaseHistoryBean>();

		/*ProductImageリストを全件取得のためのリスト*/
		List<ProductImageBean> allProductsImage
		= new ArrayList<ProductImageBean>();

		ProductImageBean productsImageBean =null;

		ProductBean productBean = null;

		/*List１回目*/
		List purchaseHistories1 = new ArrayList();

		/*List２回目*/
		List purchaseHistories2 = new ArrayList();

		/*最終的に返すListの入ったList*/
		List purchaseProductsInfo = new ArrayList();

		/*キーに日付、値にその日に購入した商品のリストを持つMap*/
		Map purchaseMap = new HashMap();

		try{
			/*AbstractDaoFactoryのインスタンスを取得*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();

			/*ProductDaoのインスタンスを取得*/
			ProductDao productDao = factory.getProductDao();

			/*PurchaseHistoryDaoのインスタンスを取得*/
			PurchaseHistoryDao purchaseHistoryDao
			= factory.getPurchaseHistoryDao();

			/*ProductImageDaoのインスタンスを取得*/
			ProductImageDao productImage = factory.getProductImageDao();

			/*Productsリストを全件取得*/
			allProducts = productDao.getProducts();

			/*購入リストを全件取得*/
			allPurchaseProducts = purchaseHistoryDao.getPurchaseHistories();

			/*ProductsImageリストを全件取得*/
			allProductsImage = productImage.getProductImages();


			Iterator allPurchaseIterator =  allPurchaseProducts.iterator();
			while(allPurchaseIterator.hasNext()){
				// purchaseHistoryBeanに入れる
				PurchaseHistoryBean purchaseHistoryBean
				= (PurchaseHistoryBean)allPurchaseIterator.next();
				/*比較用にPurchaseHistoryBeanのProductIdを格納*/
				String purchaseProductId = (String)purchaseHistoryBean.getProductId();

				/*全商品リストのイテレータ*/
				Iterator allProductsIterator = allProducts.iterator();
				while(allProductsIterator.hasNext()){
					/*Productリストを一件ずつ格納*/
					productBean = (ProductBean)allProductsIterator.next();
					/*比較用にProductBeanのProductIdを格納*/
					String productId = productBean.getProductId();
					if(purchaseProductId.equals(productId)){
						break;
					}
				}
				/*全商品画像リストのイテレータ*/
				Iterator productsImageIterator = allProductsImage.iterator();
				while(productsImageIterator.hasNext()){
					/*ProductImageリストを一件ずつ格納*/
					productsImageBean
					= (ProductImageBean)productsImageIterator.next();
					/*比較用にProductIamgeBeanのProductIdを格納*/
					String productImageId = productsImageBean.getProductId();
					if(purchaseProductId.equals(productImageId)){
						break;
					}
				}

				if(memberId == purchaseHistoryBean.getMemberId()){
					//if((pageNum - 1) * 10 <= i && i < pageNum * 10){
					purchaseHistories1 = new ArrayList();

					/*日付の書式変換*/
					String[] pdate = purchaseHistoryBean.getPurchaseOrderDate().split("\\s");
					String d = pdate[0].replaceAll("-", "/");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			        Date date = sdf.parse(d);
			        d = sdf.format(date);
			        purchaseHistoryBean.setPurchaseOrderDate(d);

					purchaseHistories1.add(purchaseHistoryBean);
					purchaseHistories1.add(productBean);
					purchaseHistories1.add(productsImageBean);

					purchaseHistories2.add(purchaseHistories1);

					//i++;
					//}
				}
			}


			/*購入した商品情報分イテレータで回す*/
			Iterator purchase2Iterator = purchaseHistories2.iterator();
			while(purchase2Iterator.hasNext()){

				/*購入した商品を一件ずつリストに格納*/
				List purchase2Products = (ArrayList)purchase2Iterator.next();

				/*purchaseMapのキー(日付)に該当する商品がない場合*/
				/*purchaseMapの値にその日付のリストを作成し格納*/
				if(!purchaseMap.containsKey(((PurchaseHistoryBean)(purchase2Products.get(0))).getPurchaseOrderDate())){
					/*新たな日付用のリストを作成*/
					List newPurchaseProducts = new ArrayList();
					/*新たなリストに購入した商品を格納*/
					newPurchaseProducts.add(purchase2Products);
					/*purchaseMapにキーをその日付、値にその新たなリストを格納*/
					purchaseMap.put(((PurchaseHistoryBean)(purchase2Products.get(0))).getPurchaseOrderDate(),newPurchaseProducts);
				/*purchaseMapのキー(日付)と購入した日付が一致した場合の処理*/
				}else{
					/*購入した商品の日付に一致したリストを格納*/
					List dateMatchProducts = (ArrayList)purchaseMap.get(((PurchaseHistoryBean)(purchase2Products.get(0))).getPurchaseOrderDate());
					/*そのリストに購入したリストを格納*/
					dateMatchProducts.add(purchase2Products);
				}
			}

		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}catch(ParseException e){
			throw new LogicException(e.getMessage(), e);
		}

			responseContext.setResult(purchaseMap);

		/*セッションスコープにインスタンスを保存*/
		requestContext.setSessionAttribute("pageNum",pageNum);

		/*転送先のビューを指定*/
		responseContext.setTarget("orderhistory");

		/*returnで結果を返す*/
		return responseContext;
	}
}