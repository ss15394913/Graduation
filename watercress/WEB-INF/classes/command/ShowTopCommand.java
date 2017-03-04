/*
  @author 宇津野
  @date 2017/03/02
*/

package command;

import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductCatalogBean;
import bean.ProductImageBean;
import bean.ProductInformationBean;
import bean.PurchaseRankingBean;
import bean.TagBean;
import dao.AbstractDaoFactory;
import dao.ProductCatalogDao;
import dao.ProductImageDao;
import dao.ProductInformationDao;
import dao.PurchaseRankingDao;
import dao.TagDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.ResponseContext;

/**/
public class ShowTopCommand extends AbstractCommand {

	/*商品詳細情報を全て格納する変数*/
	private ArrayList productInfomationList=new ArrayList();

	/*新商品5件を入れる変数*/
	private ArrayList<ProductInformationBean> newProductList=new ArrayList<ProductInformationBean>();

	/*ProductCatalogを全件入れる変数*/
	private ArrayList catalogList=new ArrayList();

	/*Tag表全件を格納する変数*/
	ArrayList tagList=new ArrayList();

	/*Tag表全件の内、tag_nameが「SALE」の「product_id」を格納する変数*/
	private ArrayList<String> saleTagId=new ArrayList<String>();

	/*SALE商品5件を入れる変数*/
	private ArrayList<ProductInformationBean> saleProductList=new ArrayList<ProductInformationBean>();

	/*商品ランキング全件を入れる変数*/
	private ArrayList allRankingProductList=new ArrayList();

	/*ランキング5件を格納する変数*/
	private ArrayList<ProductInformationBean> rankingProductList=new ArrayList<ProductInformationBean>();

	/*新商品、SALE商品、ランキング商品それぞれのListを格納し纏めるList*/
	private ArrayList resultList=new ArrayList();

	/*全ての画像パス情報を格納するList*/
	private ArrayList allImagePathList=new ArrayList();

	/*商品の画像パスを複数格納したList*/
	private ArrayList<String> pathList=new ArrayList<String>();

	/*商品の画像パスを格納したListを三つ格納するList*/
	private ArrayList imagePathList=new ArrayList();



	public ResponseContext execute(ResponseContext responseContext)throws LogicException{
		try{

			/*AbstractDaoFactoryのインスタンスを取得*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();

			/*ProductInfomationDaoのインスタンスを取得*/
			ProductInformationDao productInfomationDao = factory.getProductInformationDao();

			/*全ての商品詳細を格納*/
			productInfomationList=(ArrayList)productInfomationDao.getProductInformations();

			/*ProductImageDaoのインスタンスの取得*/
			ProductImageDao productImageDao=factory.getProductImageDao();

			/*全ての画像のパス情報を格納したList*/
			allImagePathList=(ArrayList)productImageDao.getProductImages();

			/*商品詳細情報や画像パスの取得に使う値を格納する変数*/
			ArrayList<String> productInfoId=new ArrayList<String>();


			for(int i=0;i<5;i++){
				pathList.add("path");
			}


/*	＜新着商品の取得処理＞	*/


			/*新着商品5件の格納*/
			/*商品データと商品画像パス取得に使うIDのindexは同じ値になる*/
			for(int i=0;i<5;i++){
				/*新着5件のProductInformationBeanが入る*/
				newProductList.add((ProductInformationBean)productInfomationList.get(i));

				/*新着5件の商品の画像パス取得に必要なproduct_idを取得*/
				ProductInformationBean bean=(ProductInformationBean)productInfomationList.get(i);
				/*productInfoに入っているIDを使い画像パスを取得する*/
				productInfoId.add(bean.getProductId());
			}

			/*全ての画像のパス情報をIteratorにする*/
			Iterator newProductIte=allImagePathList.iterator();
			while(newProductIte.hasNext()){
				ProductImageBean bean=(ProductImageBean)newProductIte.next();

				/*新着5件のidと等しい値を持つ画像パスを格納*/
				if(productInfoId.contains(bean.getProductId())){
					/*newProductList[0]の画像パスはpathList[0]に入る*/
					int index=productInfoId.indexOf(bean.getProductId());
					pathList.set(index,bean.getProductImagePath());
				}

			}
			/*新着5件の商品画像パスを格納*/
			imagePathList.add(pathList);

			/*pathListを他の商品のデータ取得に使うため初期化する*/
			pathList=new ArrayList<String>();

/*	＜SALE対象商品の取得処理＞	*/

			/*TagDaoのインスタンスを取得*/
			TagDao tagDao=factory.getTagDao();

			/*Tagの情報を全件取得*/
			tagList=(ArrayList)tagDao.getTags();

			/*saleTagIdの格納数*/
			int count=0;
			/*tag_nameが「SALE」のproduct_idを5件saleTagIdに格納*/
			Iterator it=tagList.iterator();
			while(it.hasNext()){
				TagBean t=(TagBean)it.next();

				String sale="セール";
				if(sale.equals(t.getTagName())){
					/*セール対象商品のIDが格納される*/
					saleTagId.add(t.getProductId());
					count++;
				}
				/*5件のセール対象商品IDが格納されたらループを抜ける*/
				if(count==4){
					break;
				}
			}

			/*ProductCatalogDaoのインスタンスの取得*/
			ProductCatalogDao productCatalogDao=factory.getProductCatalogDao();

			/*ProductCatalogの情報を全件取得*/
			catalogList=(ArrayList)productCatalogDao.getProductCatalogs();

			Iterator catalogIte=catalogList.iterator();
			while(catalogIte.hasNext()){

			/*	ProductCatalogの情報を一件ずつ格納する。						*/
			/*	それのExampleProductId(product_id)とsaleTagId内の値を比べる。	*/
			/*	同一値の商品がSALE対象											*/
				ProductCatalogBean productCatalog=(ProductCatalogBean)catalogIte.next();

			/*	saleTagId内のどれかに一致するかを調べる*/
				if(saleTagId.contains(String.valueOf(productCatalog.getExampleProductId()))){

					/*sale対象の商品画像パスを格納*/
					pathList.add(productCatalog.getProductImagePath());

					/*対象商品の詳細情報の取得*/
					Iterator productInfoIte=productInfomationList.iterator();
					while(productInfoIte.hasNext()){
						ProductInformationBean infoBean=(ProductInformationBean)productInfoIte.next();

						/*sale商品のIDと商品詳細表のIDを比べ、同じの物を格納*/
						if(productCatalog.getExampleProductId().equals(infoBean.getProductId())){
							saleProductList.add(infoBean);
						}
					}
				}
			}
			/*sale商品5件の商品画像パスを格納*/
			imagePathList.add(pathList);


			/*pathListを他の商品のデータ取得に使うため初期化する*/
			pathList=new ArrayList<String>();


/*	＜ランキング商品の取得処理＞	*/

			/*インスタンス生成後、ランキング全件の取得*/
			PurchaseRankingDao purchaseRankingDao=factory.getPurchaseRankingDao();
			allRankingProductList=(ArrayList)purchaseRankingDao.getPurchaseRanking();

			/*商品詳細表からデータを取り出すために、Catalog表のproduct_idを格納する変数*/
			ArrayList<String> productId=new ArrayList<String>();

			/*ランキング上位5件の格納*/
			for(int i=0;i<5;i++){
				/*ランキング上位5件の格納*/
				PurchaseRankingBean rankingBean=(PurchaseRankingBean)allRankingProductList.get(i);

				/*画像パスを取得する処理*/
				catalogIte=catalogList.iterator();
				while(catalogIte.hasNext()){

					/*rankingBean内の商品名とCatalog表の商品名を比べる*/
					/*商品名が一致した商品の画像パスを格納する*/
					ProductCatalogBean productCatalog=(ProductCatalogBean)catalogIte.next();
					if(rankingBean.getProductName().equals(productCatalog.getProductName())){
						pathList.add(productCatalog.getProductImagePath());
						productId.add(productCatalog.getExampleProductId());
					}
				}
			}

			Iterator productInfoIte=productInfomationList.iterator();
			while(productInfoIte.hasNext()){
				ProductInformationBean infoBean=(ProductInformationBean)productInfoIte.next();

				/*sale商品のIDと商品詳細表のIDを比べ、同じの物を格納*/
				if(productId.contains(String.valueOf(infoBean.getProductId()))){
					rankingProductList.add(infoBean);
				}
			}

			/*ランキング商品5件の商品画像パスを格納*/
			imagePathList.add(pathList);




		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}

		/*resultListのデータ内容*/
		/*[0] 新着5件の商品データ*/
		/*[1] sale対象商品5件のデータ*/
		/*[2] ランキングの上位5件のデータ*/
		/*[3]～[5] 上記の商品画像パスのみ格納したデータ*/
		resultList.add(newProductList);
		resultList.add(saleProductList);
		resultList.add(rankingProductList);
		resultList.add(imagePathList.get(0));
		resultList.add(imagePathList.get(1));
		resultList.add(imagePathList.get(2));
		responseContext.setResult(resultList);

		responseContext.setTarget("top");
		return responseContext;
	}
}