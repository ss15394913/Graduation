package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.FavoriteBean;
import bean.MemberBean;
import bean.ProductBean;
import bean.ProductImageBean;
import bean.TagBean;
import dao.AbstractDaoFactory;
import dao.FavoriteDao;
import dao.MemberDao;
import dao.ProductDao;
import dao.ProductImageDao;
import dao.TagDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className UserStatusCommand
 *@author 河野,宇津野
 *@date 2017/01/31
 *@description アカウント情報、お気に入り商品、おすすめ商品
 */

public class ShowMyPageCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		/*RequestContextのインスタンスを取得*/
		RequestContext requestContext = getRequestContext();

		/*Daoからお気に入り表全件入れるList*/
		List favoriteList = new ArrayList();
		/*会員のお気に入り商品IDのみ入れるList*/
		ArrayList<String> memberFavoriteList =
		new ArrayList<String>();
		/*商品全件を入れるList*/
		List productList = new ArrayList();
		/*会員のお気に入り商品を入れるList*/
		ArrayList<ProductBean> memberProductList =
		new ArrayList<ProductBean>();

		/*入力されたパラメータを受け取る*/
		int memberId = Integer.parseInt(requestContext.getSessionAttribute("login").toString());

		/*MemberBeanのインスタンス*/
		MemberBean member = new MemberBean();

		/*ProductImageBeanの情報が格納してある変数*/
		ProductImageBean productsImageBean = new ProductImageBean();

		/*商品画像のIDを格納してある変数*/
		String imageProductId = null;

		/*タグのリストを全件取得するための変数*/
		List tags = new ArrayList();

		/*オススメ商品のみ格納したリスト*/
		List tagsName = new ArrayList();

		/*メンバーリストを全件取得のためのリスト*/
		List allMemberList = new ArrayList();

		/*商品画像を全件取得のためのリスト*/
		List allProductsImage = new ArrayList();

		/*最終的に返すお気に入り商品リストを格納したMap*/
		Map favoriteProductsInfo = new HashMap();

		/*最終的に返すおすすめ商品リスト格納したMap*/
		Map adviceProductsInfo = new HashMap();

		/*forEachを入れ子にするためにListへ登録(お気に入り商品用)*/
		List favoriteInfoList = new ArrayList();

		/*forEachを入れ子にするためにListへ登録(会員限定セール用)*/
		List adviceInfoList = new ArrayList();
		
		try{
		/*プロフィールの取得処理ーーーーーーーーーーーーーーーーーーーー*/

			/*AbstractDaoFactoryのインスタンスを取得*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();

			/*MemberDaoのインスタンスを取得*/
			MemberDao memberDao = factory.getMemberDao();

			/*メンバーリストを全件取得*/
			allMemberList = memberDao.getMembers();

			Iterator iterator = allMemberList.iterator();

			while(iterator.hasNext()){

				member = (MemberBean)iterator.next();
				if(memberId == member.getMemberId()){
					break;
				}
			}
		/*--------------------------------------------------------------*/
			
/*お気に入り一覧の取得処理ーーーーーーーーーーーーーーーーーーーーーーーー*/

			/*FavoriteDao型の変数ににOraFavoriteDaoインスタンスを入れる*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*ProductDao型の変数ににOraProductDaoインスタンスを入れる*/
			ProductDao productDao = factory.getProductDao();
			/*お気に入り表全件を取得*/
			favoriteList = favoriteDao.getFavorites();
			
			Iterator favoIterator = favoriteList.iterator();
			while(favoIterator.hasNext()){
				/*お気に入り表の内容がループ毎に一件ずつ入る*/
				FavoriteBean favoriteBean =  (FavoriteBean)favoIterator.next();
				/*お気に入りを表示したい会員のIDと
				お気に入り表に登録されているIDを比べ、
				等しい会員IDと結びついている商品IDを入れる*/
				if(memberId == favoriteBean.getMemberId()){
					memberFavoriteList.add(favoriteBean.getProductId());
				}
			}
			/*---------------------------------------------------------*/
			
			/*ProductImageDaoのインスタンスを取得*/
			ProductImageDao productImage = factory.getProductImageDao();

			/*ProductsImageリストを全件取得*/
			allProductsImage = productImage.getProductImages();
			
			/*Product表を全件取得する処理------------------------*/
			productList = productDao.getProducts();
			
			Iterator proIterator = productList.iterator();
			while(proIterator.hasNext()){
				/*商品情報がループ毎に一件ずつ入る*/
				ProductBean productBean =  (ProductBean)proIterator.next();
				
				/*商品画像のイテレータを回す*/
				Iterator favoriteImageIterator = allProductsImage.iterator();
				while(favoriteImageIterator.hasNext()){
					productsImageBean
					= (ProductImageBean)favoriteImageIterator.next();
					/*ProductImageBeanの商品IDを格納*/
					imageProductId = productsImageBean.getProductId();
					
					Iterator favoriteProductIdIterator 
						= memberFavoriteList.iterator();
					while(favoriteProductIdIterator.hasNext()){
						/*お気に入り商品IDが一件ずつ格納される*/
						String favoriteProductId 
							= (String)favoriteProductIdIterator.next();
					/*memberFavoriteList内にある
						複数の商品IDのどれかと合致する商品IDの商品を入れる*/
					if(favoriteProductId.equals(productBean.getProductId()) && favoriteProductId.equals(imageProductId)){
						favoriteProductsInfo = new HashMap();
						
						favoriteProductsInfo.put("productBean",productBean);
						favoriteProductsInfo.put("productsImageBean",productsImageBean);
						/*ListにMapを格納*/
						/*(お気に入りのproductBeanとproductImageBean)*/
						favoriteInfoList.add(favoriteProductsInfo);
						}
					}
				}
			}
			/*----------------------------------------------------*/

/*会員限定セール用の処理ーーーーーーーーーーーーーーーーーーーーーーーーーー*/
			/*-------タグのオススメ商品のみを抽出する処理---------*/

			TagDao tagDao = factory.getTagDao();
			/*Tag表を全件取得*/
			tags = tagDao.getTags();

			Iterator tagIterator = tags.iterator();
			while(tagIterator.hasNext()){
				TagBean tagBean = (TagBean)tagIterator.next();
				String tagName = tagBean.getTagName();

				if(tagName.equals("オススメ")){
					tagsName.add(tagBean);
				}
			}
			/*-------------------------------------------------------*/
			
			/*おすすめ商品とその商品画像を抽出する処理－－－－－－－*/
			Iterator tagNameIterator = tagsName.iterator();
			
			while(tagNameIterator.hasNext()){
				TagBean tagNameBean
				= (TagBean)tagNameIterator.next();
				/*オススメ商品のProductIdを格納*/
				String tagProductId = tagNameBean.getProductId();
				/*オススメの商品のIDは出ている*/
				Iterator productsIterator = productList.iterator();
				while(productsIterator.hasNext()){
					ProductBean productBean
					= (ProductBean)productsIterator.next();
				/*商品のProductIdを格納*/
					String productId = productBean.getProductId();
					
					Iterator productsImageIterator 
							= allProductsImage.iterator();
					while(productsImageIterator.hasNext()){
						productsImageBean 
							= (ProductImageBean)productsImageIterator.next();
						/*ProductImageBeanのproductIdを格納*/
						imageProductId = productsImageBean.getProductId();
						if(productId.equals(tagProductId) && productId.equals(imageProductId)){
							adviceProductsInfo = new HashMap();
							adviceProductsInfo.put("productBean",productBean);
							adviceProductsInfo.put("productsImageBean",productsImageBean);
							/*ListにMapを格納(会員限定セールのproductBeanとproductImageBean)*/
							adviceInfoList.add(adviceProductsInfo);
						}
					}
				}
			}
			/*-----------------------------------------------------*/
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		/*アカウント情報表示用のリスト*/
		requestContext.setRequestAttribute("member",member);

		/*お気に入り商品と画像表示用のList*/
		requestContext.setRequestAttribute("favoriteInfoList",favoriteInfoList);

		/*会員限定セールの商品と画像表示用のList*/
		requestContext.setRequestAttribute("adviceInfoList",adviceInfoList);

		/*転送先のビューを指定*/
		responseContext.setTarget("mypage");

		/*returnで結果を返す*/
		return responseContext;
	}
}