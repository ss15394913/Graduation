/*
  @author 池田大和
  @date 2017/03/01

 *@description
 resultData : Map<String, Object> 【jspで${data}で取り出される部分】
 ┃
 ┗"productInformation",List<ProductInformationBean> 商品詳細一件ずつのデータ
 ┗"CategoryName",String 表示する商品のカテゴリ名
 ┗"isSaleProduct",Boolean 商品がセール中であるか
 ┗"productColors",List<String> 表示する商品に存在する色
 ┗"productSizes",List<String> 表示する商品に存在するサイズ
 ┗"productStockCounts",Map<String,Integer> 表示する商品の在庫数 javascriptへの受け渡しに使う
 ┃┗(色,サイズ),Integer                キーは色とサイズの文字列を組み合わせて生成する
 ┃
 ┗"productsId",Map<String,String>     表示する商品のId javascriptへの受け渡しに使う
 ┃┗(色,サイズ),String                キーは色とサイズの文字列を組み合わせて生成する
 ┃
 ┗"productImageData",List<Map>
   ┗productImageData : Map<String,String> 該当する商品の画像と、それに附属する説明などのデータ
     ┃
     ┗"imagePath",String 商品画像のパス
     ┗"description",String 商品の説明
*/

package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.CategoryBean;
import bean.ProductImageBean;
import bean.ProductInformationBean;
import bean.TagBean;
import dao.AbstractDaoFactory;
import dao.CategoryDao;
import dao.FavoriteDao;
import dao.ProductImageDao;
import dao.ProductInformationDao;
import dao.TagDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/*クリックされた商品の詳細を表示するコマンドのクラス*/
public class ShowProductDetailCommand extends AbstractCommand {

	/*Daoを取得するためのDaoFactoryを格納する*/
	AbstractDaoFactory factory;
	/*各種Daoを格納する*/
	ProductInformationDao productInformationDao;
	CategoryDao categoryDao;
	FavoriteDao favoriteDao;
	ProductImageDao productImageDao;
	TagDao tagDao;

	/*全商品の情報のリスト*/
	List allProductInformationList;
	/*全カテゴリの情報のリスト*/
	List allCategoryList;
	/*全お気に入りの情報のリスト*/
	List allFavoriteList;
	/*全商品画像のリスト*/
	List allProductImageList;
	/*全タグのリスト*/
	List allTagList;

	/*どの名前のタグがセールのタグであるかを表す定数*/
	final String saleTagName = "セール";

	/*クリックされた商品の詳細を返すメソッド*/
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException {
		/*initメソッドによって準備されていたRequestContextを取得する*/
		RequestContext requestContext = getRequestContext();

		/*「目的の名前を持つ商品の、商品詳細のリスト」の変数を宣言*/
		List selectedProductInformations = new ArrayList();

		/*「商品のカテゴリ名」の変数を宣言*/
		String selectedCategoryName = null;

		/*「商品がセール中であるか」の変数を宣言*/
		Boolean isSaleProduct = false;

		/*「商品の画像情報のリスト」の変数を宣言*/
		List productImageDatas = new ArrayList();

		/*「商品の色のリスト」の変数を宣言*/
		List productColors = new ArrayList();

		/*「商品のサイズのリスト」の変数を宣言*/
		List productSizes = new ArrayList();

		/*「商品の在庫数のマップ」の変数を宣言*/
		Map productStockCounts = new HashMap();

		/*「商品のIDのマップ」の変数を宣言*/
		Map productsId = new HashMap();

		/*このコマンドのresultとなるMap
		  各商品の情報、カテゴリ名、画像ファイル名などを格納する*/
		Map resultData = new HashMap();

		/*ユーザーが選択した商品の名前を取得*/
		String selectedProductName
		= requestContext.getParameter("productName")[0];

		try{
			/*全ての使用する表のListをインスタンス変数に格納する*/
			getAllDataList();
		}catch (LogicException e){
			throw new LogicException(e.getMessage(), e);
		}

		/*商品詳細表の各行を確認して処理を行う*/
		Iterator productInformationIterator
		= allProductInformationList.iterator();
		while(productInformationIterator.hasNext()){
			/*一件の商品詳細であるBeanを取得*/
			ProductInformationBean productInfo
			= (ProductInformationBean)productInformationIterator.next();
			/*取得したBean内の商品名の変数が、
			  ユーザーが選択した商品の名前と同じであるなら*/
			if(productInfo.getProductName().equals(selectedProductName)){

				/*レスポンスの内容のListにそのBeanを追加する*/
				selectedProductInformations.add(productInfo);

				/*まだカテゴリ名の変数にカテゴリ名が格納されていないなら、
				  分割メソッドを利用しカテゴリ名の変数にカテゴリ名を格納する*/
				if(selectedCategoryName == null){
					selectedCategoryName
					= getProductCategoryName(productInfo.getCategoryId());
				}

				/*分割メソッドで画像情報を取得し、
				  レスポンスの内容のListにそのMapを追加する*/
				productImageDatas.add(
					getProductImageData(productInfo.getProductId()));

				/*現在の商品詳細のBeanから色の名前を取り出し、
				  レスポンスの内容のListにその文字列を追加する*/
				if(!productColors.contains(productInfo.getProductColor())){
					productColors.add(productInfo.getProductColor());
				}
				/*現在の商品詳細のBeanからサイズの名前を取り出し、
				  レスポンスの内容のListにその文字列を追加する*/
				if(!productSizes.contains(productInfo.getProductSize())){
					productSizes.add(productInfo.getProductSize());
				}
				
				/*現在の商品詳細のBeanから在庫数を取り出し、
				  レスポンスの内容のMapにその値を登録する。
				  キーは、その商品詳細の色とサイズから作成する*/
				productStockCounts.put(
					productInfo.getProductColor()+","
					+ productInfo.getProductSize(),
					new Integer(productInfo.getProductStockCount())
				);
				
				/*現在の商品詳細のBeanからIDを取り出し、
				  レスポンスの内容のMapにその値を登録する。
				  キーは、その商品詳細の色とサイズから作成する*/
				productsId.put(
					productInfo.getProductColor()+","
					+ productInfo.getProductSize(),
					productInfo.getProductId()
				);
			}
		}

		/*存在しない色とサイズの組み合わせの商品の在庫数を、
		  -1としてMapに追加する*/
		/*商品に存在する各色のイテレータ取得*/
		Iterator productColorsIteraotor = productColors.iterator();
		while(productColorsIteraotor.hasNext()){
			String color = (String)productColorsIteraotor.next();
			/*商品に存在する各サイズのイテレータ取得*/
			Iterator productSizesIteraotor = productSizes.iterator();
			while(productSizesIteraotor.hasNext()){
				String size = (String)productSizesIteraotor.next();
				/*Mapに"色,サイズ"のキーが登録されていないなら*/
				if(!productStockCounts.containsKey(color+","+size)){
					/*そのキーの値を-1として登録する*/
					productStockCounts.put(color+","+size,new Integer(-1));
				}
			}
		}

		/*選択された商品はセールであるかを、分割メソッドを利用し取得する*/
		isSaleProduct = checkProductSaleTag(selectedProductInformations);

		/*resultであるMapにデータを格納する*/
		/*選択された商品の詳細情報のリスト*/
		resultData.put("productInformation",selectedProductInformations);
		/*選択された商品のカテゴリ名（画像パスの指定のために必要）*/
		resultData.put("categoryName",selectedCategoryName);
		/*選択された商品がセール中であるか*/
		resultData.put("isSaleProduct",isSaleProduct);
		/*選択された商品に存在する色*/
		resultData.put("productColors",productColors);
		/*選択された商品に存在するサイズ*/
		resultData.put("productSizes",productSizes);
		/*選択された商品の在庫数*/
		resultData.put("productStockCounts",productStockCounts);
		/*選択された商品のID*/
		resultData.put("productsId",productsId);
		/*選択された商品の画像ファイル名*/
		resultData.put("productImageData",productImageDatas);

		/*responseで送る値をセット*/
		responseContext.setResult(resultData);

		/*転送先のViewの名前をレスポンスに加える*/
		responseContext.setTarget("productdetail");

		/*必要な情報を入れ終わったレスポンスを返す*/
		return responseContext;
	}

	/*全ての使用する表のListをインスタンス変数に格納するメソッド*/
	private void getAllDataList()
	throws LogicException{
		try{
			/*Daoを取得するためのDaoFactoryを取得する*/
			factory = AbstractDaoFactory.getFactory();

			/*商品詳細情報を取得するためのDaoを取得*/
			productInformationDao = factory.getProductInformationDao();
			/*全商品詳細の情報を取得*/
			allProductInformationList
			= productInformationDao.getProductInformations();

			/*カテゴリの情報を取得するためのDaoを取得*/
			categoryDao = factory.getCategoryDao();
			/*全カテゴリの情報を取得*/
			allCategoryList = categoryDao.getCategories();

			/*お気に入りの情報を取得するためのDaoを取得する*/
			favoriteDao = factory.getFavoriteDao();
			/*Daoからお気に入りの情報を取得する*/
			allFavoriteList = favoriteDao.getFavorites();

			/*商品画像を取得するためのDaoを取得*/
			productImageDao = factory.getProductImageDao();
			/*全商品画像の情報を取得*/
			allProductImageList = productImageDao.getProductImages();

			/*タグを取得するためのDaoを取得*/
			tagDao = factory.getTagDao();
			/*全タグの情報を取得*/
			allTagList = tagDao.getTags();

		}catch (IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
	}

	/*引数のカテゴリIDの、カテゴリ名を返すメソッド*/
	private String getProductCategoryName(int categoryId){

		Iterator categoryIterator = allCategoryList.iterator();
		while(categoryIterator.hasNext()){

			/*カテゴリ１件の情報を取得*/
			CategoryBean category
			= (CategoryBean)categoryIterator.next();

			/*引数のカテゴリIDと現在のカテゴリのIDが同じなら*/
			if(categoryId == category.getCategoryId()){
				/*現在のカテゴリの名前を返す*/
				return category.getCategoryName();
			}
		}
		return "";
	}

	/*引数の商品IDの、画像パスと説明を格納するMapを返すメソッド*/
	private Map getProductImageData(String productId){
		/*商品詳細の情報を格納するMapを宣言*/
		Map productImageData = new HashMap();

		Iterator productImageIterator = allProductImageList.iterator();
		while(productImageIterator.hasNext()){

			/*商品画像１件の情報を取得*/
			ProductImageBean productImage
			= (ProductImageBean)productImageIterator.next();

			/*引数の商品IDと現在の画像の商品IDが同じなら*/
			if(productId.equals(productImage.getProductId())){
				/*現在の画像パスをMapに格納する*/
				productImageData.put(
					"imagePath",productImage.getProductImagePath()
				);
				productImageData.put(
					"description",
					getProductDescription(productImage.getProductId())
				);
			}
		}
		return productImageData;
	}

	/*引数の商品IDの、説明文を返すメソッド*/
	private String getProductDescription(String productId){

		Iterator productInformationIterator
		= allProductInformationList.iterator();
		while(productInformationIterator.hasNext()){
			/*一件の商品詳細であるBeanを取得*/
			ProductInformationBean productInfo
			= (ProductInformationBean)productInformationIterator.next();

			/*取得したBean内の商品IDの変数が、
			  ユーザーが選択した商品のIDと同じであるなら*/
			if(productInfo.getProductId().equals(productId)){
				/*現在の商品の説明文を返す*/
				return productInfo.getProductDescription();
			}
		}
		return "";
	}

	/*引数のList内の商品に、「セール」タグが付加されているかを返すメソッド*/
	private Boolean checkProductSaleTag(List selectedProductInfo){
		/*セールのタグが付加されている商品のIDのListを宣言*/
		List<String> saleProductsId = new ArrayList<String>();

		/*タグ情報全件から確認する*/
		Iterator tagIterator = allTagList.iterator();
		while(tagIterator.hasNext()){
			TagBean tag = (TagBean)tagIterator.next();
			/*セールのタグの情報なら、その情報の商品IDをListに追加*/
			if(tag.getTagName().equals(saleTagName)){
				saleProductsId.add(tag.getProductId());
			}
		}

		/*引数の商品IDのListの全件を調べる*/
		Iterator selectedProductInfoIterator = selectedProductInfo.iterator();
		while(selectedProductInfoIterator.hasNext()){
			ProductInformationBean productInfo
			= (ProductInformationBean)selectedProductInfoIterator.next();
			/*現在の商品がセールのタグが付加されている商品なら*/
			if(saleProductsId.contains(productInfo.getProductId())){
				/*true(この商品はセール中である)を返す*/
				return new Boolean(true);
			}
		}

		return new Boolean(false);
	}
}