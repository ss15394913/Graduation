package command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import bean.CategoryBean;
import bean.FavoriteBean;
import bean.ProductBean;
import bean.ProductCatalogBean;
import bean.SubCategoryBean;
import bean.TagBean;
import dao.AbstractDaoFactory;
import dao.CategoryDao;
import dao.FavoriteDao;
import dao.ProductCatalogDao;
import dao.ProductDao;
import dao.SubCategoryDao;
import dao.TagDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className ShowProductsListCommand
 *@author 河野
 *@date 2017/01/31 ページ番号をセッションで管理する修正をしました。
 *@author 池田
 *@date 2017/02/07 格納する結果の仕様を、タグの名前を含むものに変更しました。
 *@date 2017/02/08 商品名、タグ名での検索を行うことができるようにしました。
 *@date 2017/02/09 結果のproductDataに、商品の色を表す画像のパスのListである
                   "productColors"を追加しました。
                   結果のproductDataに、その商品はログイン中の会員のお気に入り
                   であるかを表すBooleanである"isFavoirte"を追加しました。
 *@date 2017/02/13 格納する結果の仕様を、検索条件に該当する商品の数を含むものに
                   変更しました。
 *@date 2017/02/14 格納する結果の仕様を、商品のカテゴリ名を含むものに
                   変更しました。
 *@date 2017/02/15 商品に付与されているタグの取得処理を、
                   １つの商品名に複数のタグが付与されている場合でも
                   正しく取得できるように変更しました。

 *@description
 resultData : Map<String, Object> 【jspで${data}で取り出される部分】
 ┃
 ┗"productCount",Integer 検索条件に該当する商品の数
 ┃
 ┗"pageNumber",Integer 表示するページ番号
 ┃
 ┗"productData" : List<Map>
   ┗productData : Map<String, Object> 商品一件ずつのデータ
     ┃
     ┗"catalog",ProductCatalogBean このBeanの内容通りの、名前などのデータ
     ┗"tagNames",List<String> その商品に付加されているタグの名前のList
     ┗"colors",List<String> その商品の色の画像パスのList
     ┗"isFavorite",Boolean その商品はログイン中の会員のお気に入りであるか
     ┗"categoryName",String その商品のカテゴリ名
 */

public class ShowProductsListCommand extends AbstractCommand{

	/*Daoを取得するためのDaoFactoryを格納する*/
	AbstractDaoFactory factory;
	/*各種Daoを格納する*/
	ProductCatalogDao productCategoryDao;
	TagDao tagDao;
	SubCategoryDao subCategoryDao;
	FavoriteDao favoriteDao;
	ProductDao productDao;
	CategoryDao categoryDao;

	/*全商品の情報のリスト*/
	List allCatalogList;
	/*全タグの情報のリスト*/
	List allTagList;
	/*全サブカテゴリの情報のリスト*/
	List allSubCategoryList;
	/*全お気に入りの情報のリスト*/
	List allFavoriteList;
	/*全商品の情報のリスト*/
	List allProductList;
	/*全カテゴリの情報のリスト*/
	List allCategoryList;

	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		/*RequestContextのインスタンスを取得*/
		RequestContext requestContext = getRequestContext();

		/*送信されてきた各パラメータの取得*/
		/*ページの番号。パラメータが無い場合は1ページ目を表示する*/
		Integer pageNumber = 1;
		String[] pageNumberParam
		= requestContext.getParameter("pageNumber");
		if(pageNumberParam != null){
			pageNumber = Integer.parseInt(pageNumberParam[0]);
		}
		/*選択されたカテゴリの名前*/
		String selectedCategoryName = null;
		String[] selectedCategoryParam
		= requestContext.getParameter("category");
		if(selectedCategoryParam != null){
			selectedCategoryName = selectedCategoryParam[0];
		}
		/*選択されたサブカテゴリの名前*/
		String selectedSubCategoryName = null;
		String[] selectedSubCategoryParam
		= requestContext.getParameter("subCategory");
		if(selectedSubCategoryParam != null){
			selectedSubCategoryName = selectedSubCategoryParam[0];
		}
		/*検索する名前  全角スペースを半角スペースに変換した後、
		  半角スペースで分割して配列にする*/
		String[] searchTexts = null;
		String[] searchTextParam
		= requestContext.getParameter("searchText");
		if(searchTextParam != null){
			String searchTextString
			= searchTextParam[0].replaceAll("　"," ");
			searchTexts = searchTextString.split(" ");
		}
		/*検索するタグ  全角スペースを半角スペースに変換した後、
		  半角スペースで分割して配列にし、Listにする*/
		String[] searchTagParam = requestContext.getParameter("searchTag");
		String[] searchTagArray = null;
		List searchTags = null;
		if(searchTagParam != null){
			String searchTagString = searchTagParam[0].replaceAll("　"," ");
			/*searchTagパラメータが空文字の場合は、searchTagsはnullのまま*/
			if(!(searchTagString.equals(""))){
				searchTagArray = searchTagString.split(" ");
				searchTags = new ArrayList(Arrays.asList(searchTagArray));
			}
		}
		/*ソート条件*/
		String[] sortParams = requestContext.getParameter("sort");
		/*getProductCatalogsに渡す、ソート条件の引数を作成する*/
		/*sortParamsの文字列を、createSortArrayメソッドのルールに
		  従ってint配列に変換する。これを商品検索の際に引数にする*/
		int[] sortArray = createSortArray(sortParams);

		/*ログイン中の会員のIDを取得する。*/
		/*ログインしていない場合は-1を格納する。*/
		int loginMemberId = -1;
		if(requestContext.getSessionAttribute("login") != null){
			String idAttribute
			= (String)requestContext.getSessionAttribute("login");
			loginMemberId = Integer.parseInt(idAttribute);
		}

		/*このコマンドのresultとなる、各商品の情報と該当する商品の数*/
		Map resultData = new HashMap();

		/*上記のMapに含まれる、
		  選択されたサブカテゴリの商品が見つかった個数の変数*/
		Integer foundProductCount = 0;

		/*上記のMapに含まれる、商品情報とそのタグ名のリスト*/
		List<Map> productsDataList = new ArrayList<Map>();
		try{
			/*全ての使用する表のListをインスタンス変数に格納する*/
			getAllDataList(sortArray);
		}catch (LogicException e){
			throw new LogicException(e.getMessage(), e);
		}
		/*選択されたカテゴリのIDを分割したメソッドで取得する*/
		int selectedCategoryId
		= getCategoryId(selectedCategoryName);
		/*選択されたサブカテゴリのIDを分割したメソッドで取得する*/
		int selectedSubCategoryId
		= getSubCategoryId(selectedSubCategoryName);
		/*現在ログイン中の会員の、
		  お気に入りの商品のIDのリストを分割したメソッドで取得する*/
		List memberFavoriteList = getMemberFavoriteList(loginMemberId);
		Iterator catalogIterator = allCatalogList.iterator();
		while(catalogIterator.hasNext()){
			/*Iteratorを使ってList内の商品情報のBeanを取り出す*/
			ProductCatalogBean product
				= (ProductCatalogBean)catalogIterator.next();
			/*選択したカテゴリの商品であるかの判定を分割メソッドで行う*/
			/*選択したカテゴリの商品なら、次の検索合致判定に進む*/
			if(judgeCategoryMatch(
			product,selectedCategoryId,selectedSubCategoryId)){

				/*その商品に付加されているタグをこの時点で取得しておく*/
				/*現在の商品情報のタグの名前を格納するListの宣言*/
				List<String> productTagNames
				= getProductTagNames(product.getProductName());

				/*検索条件の文字列に合致するかを、分割メソッドで判定*/
				boolean isMatchText = judgeTextMatch(product,searchTexts);
				/*検索条件のタグに合致するかを、分割メソッドで判定*/
				boolean isMatchTag = judgeTagMatch(productTagNames,searchTags);

				/*検索条件の文字列とタグに合致するなら、商品発見後処理へ*/
				if(isMatchText && isMatchTag){
					/*発見商品数を１増やす*/
					foundProductCount++;
					/*現在のページでその商品を表示すべきかを判定する*/
					/*現在のページ番号で表示すべき商品なら、その情報と
					  それに付加されているタグの名前と
					  その商品の色を表す画像のパスと
					  ログイン中の会員のお気に入りであるかを
					  Mapに格納し、それをListに格納する*/
					if((pageNumber - 1) * 15 < foundProductCount
					&& foundProductCount <= pageNumber * 15){
						/*商品の情報と、付加されているタグの名前と
						  商品の色を表す画像のパスと
						  ログイン中の会員のお気に入りであるかと、
						  商品のカテゴリ名をMapに格納する。*/
						Map productData = new HashMap();
						productData.put("catalog",product);
						productData.put("tagNames",productTagNames);
						/*商品の色を表す画像のパスを
						  分割したメソッドから取得する*/
						List<String> productColors
						= getProductColors(product.getProductName());
						productData.put("colors",productColors);
						/*この商品はログイン中の会員のお気に入り
						  であるかを確認する*/
						Boolean isFavorite = new Boolean(false);
						if(memberFavoriteList.contains(
							product.getExampleProductId())){
							isFavorite = true;
						}
						productData.put("isFavorite",isFavorite);
						/*カテゴリ名を分割したメソッドから取得する*/
						String categoryName
						= getProductCategoryName(product.getCategoryId());
						productData.put("categoryName",categoryName);

						/*格納したMapをListに追加する*/
						productsDataList.add(productData);

					}/*if(現在のページで表示すべきか) の終端*/
				}/*if(検索文字列、検索タグに合致するか) の終端*/
			}/*if(選択したカテゴリか) の終端*/
		}/*while(catalogIterator.hasNext()) の終端*/

		/*resultであるMapにデータを格納する*/
		/*商品の個数。forEachを用いるため内容の無い配列にする*/
		resultData.put("productCount", new int[foundProductCount]);
		/*ページ番号*/
		resultData.put("pageNumber", pageNumber);
		/*各商品のデータ*/
		resultData.put("productsData", productsDataList);

		/*responseで送る値をセット*/
		responseContext.setResult(resultData);

		/*転送先のビューを指定*/
		responseContext.setTarget("productlist");

		/*returnで結果を返す*/
		return responseContext;
	}

	private int[] createSortArray(String[] sortParams){
		/*返却するソート方法指定用配列を宣言*/
		int[] sortArray = new int[3];

		if(sortParams != null){
			/*sortParamsの内容に従って、定数を配列に格納する*/
			for(int i = 0;i < sortParams.length;i++){
				/*
				  priceAsc = 値段の安い順
				  priceDesc = 値段の高い順
				  purchaseAsc = 購入数が少ない順
				  purchaseDesc = 購入数が多い順
				  nameAsc = 50音順
				  nameDesc = 50音順の逆順
				*/
				if(sortParams[i].equals("priceAsc")){
					sortArray[0] = ProductCatalogDao.SORT_BY_PRICE_ASC;
				}
				else if(sortParams[i].equals("priceDesc")){
					sortArray[0] = ProductCatalogDao.SORT_BY_PRICE_DESC;
				}
				else if(sortParams[i].equals("purchaseAsc")){
					sortArray[1] = ProductCatalogDao.SORT_BY_PURCHASE_COUNT_ASC;
				}
				else if(sortParams[i].equals("purchaseDesc")){
					sortArray[1] = ProductCatalogDao.SORT_BY_PURCHASE_COUNT_DESC;
				}
				else if(sortParams[i].equals("nameAsc")){
					sortArray[2] = ProductCatalogDao.SORT_BY_NAME_ASC;
				}
				else if(sortParams[i].equals("nameDesc")){
					sortArray[2] = ProductCatalogDao.SORT_BY_NAME_DESC;
				}
			}
		}
		/*作成した配列を返す*/
		return sortArray;
	}

	/*選択されたサブカテゴリの名前に対応するIDを返すメソッド*/
	private int getSubCategoryId(String subCategoryName)
	throws LogicException{
		/*引数がnullである(パラメータが存在しない)場合は-1を返す*/
		if(subCategoryName == null){
			return -1;
		}
		/*Iteratorを使い、各サブカテゴリの情報を確認*/
		Iterator subCategoryIterator = allSubCategoryList.iterator();
		while(subCategoryIterator.hasNext()){
			/*サブカテゴリのBeanを取得*/
			SubCategoryBean subCategory
			= (SubCategoryBean)subCategoryIterator.next();
			/*Beanの中のサブカテゴリの名前と、クライアントが選択した
			   サブカテゴリの名前が同じなら、そのサブカテゴリのIDを
			  変数に格納する*/
			if(subCategory.getSubCategoryName()
					.equals(subCategoryName)){
				return subCategory.getSubCategoryId();
			}
		}
		/*一致する名前が無い（＝パラメータが存在しない）場合は-1を返す*/
		return -1;
	}

	/*現在ログイン中の会員の、
	  お気に入りの商品のIDのリストを分割したメソッドで取得するメソッド*/
	private List getMemberFavoriteList(int loginMemberId)
	throws LogicException{
		/*全お気に入りの情報のリスト*/
		allFavoriteList = null;
		/*このメソッドが返す、
		  ログイン中の会員のお気に入り商品のIDのリスト*/
		List memberFavoriteList = new ArrayList();
		/*会員がログインしているなら、お気に入りの商品のIDを取得する*/
		if(loginMemberId != -1){
			Iterator favoriteIterator = allFavoriteList.iterator();
			while(favoriteIterator.hasNext()){
				FavoriteBean favorite
				= (FavoriteBean)favoriteIterator.next();
				/*お気に入りの情報の会員IDとログイン中の会員のIDが
				  同じならそのお気に入り情報の商品のIDをリストに追加*/
				if(loginMemberId == favorite.getMemberId()){
					memberFavoriteList.add(favorite.getProductId());
				}
			}
		}
		return memberFavoriteList;
	}


	/*引数の商品名と名前が一致する商品の、色の画像パスのリストを返すメソッド*/
	private List<String> getProductColors(String productName)
	throws LogicException{
		/*このメソッドが返す、色の画像パスのリストの変数を宣言*/
		List<String> productColors = new ArrayList<String>();
		/*プロパティファイルへのパス */
		String FILE_PATH
		= "c:/watercress/WEB-INF/data/properties/ProductColors.properties";
		/*色毎の画像パスを保存しているプロパティファイルを読み込む*/
		Properties properties = new Properties();
		try{
			properties.load(new FileInputStream(FILE_PATH));
			Iterator productIterator = allProductList.iterator();
			while(productIterator.hasNext()){
				/*商品の情報１件のBeanを取得*/
				ProductBean product = (ProductBean)productIterator.next();
				/*引数の商品名と現在の商品の名前が同じなら*/
				if(productName.equals(product.getProductName())){
					/*現在の商品の色に対応する画像パスを取得する*/
					String productColor
					= properties.getProperty(product.getProductColor());
					productColors.add(productColor);
				}
			}
		}catch (FileNotFoundException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (IOException e) {
			throw new LogicException(e.getMessage(), e);
		}catch (Exception e) {
			throw new LogicException(e.getMessage(), e);
		}
		return productColors;
	}

	/*引数のカテゴリIDの、カテゴリ名を返すメソッド*/
	private String getProductCategoryName(int categoryId)
	throws LogicException{
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

	/*選択されたカテゴリの名前に対応するIDを返すメソッド*/
	private int getCategoryId(String categoryName)
	throws LogicException{
		/*引数がnullである(パラメータが存在しない)場合は-1を返す*/
		if(categoryName == null){
			return -1;
		}
		Iterator categoryIterator = allCategoryList.iterator();
		while(categoryIterator.hasNext()){

			/*カテゴリ１件の情報を取得*/
			CategoryBean category
			= (CategoryBean)categoryIterator.next();

			/*引数のカテゴリの名前と現在のカテゴリの名前が同じなら*/
			if(categoryName.equals(category.getCategoryName())){
				/*現在のカテゴリのIDを返す*/
				return category.getCategoryId();
			}
		}
		/*一致する名前が無い場合は-1を返す*/
		return -1;
	}

	/*この商品は選択されたカテゴリの商品であるかを判定するメソッド*/
	private boolean judgeCategoryMatch(
	ProductCatalogBean product,int selectedCategoryId,
	int selectedSubCategoryId)
	throws LogicException{

		/*先にサブカテゴリが一致しているかを確認する。*/
		if(product.getSubCategoryId() == selectedSubCategoryId){
			return true;
		}
		/*サブカテゴリが一致していない場合の判定を行う*/
		/*カテゴリのパラメータとサブカテゴリのパラメータが
		  同時に送信されてきた場合は、カテゴリのパラメータを無視する
		 （サブカテゴリのパラメータのみで判定を行う）。
		  パラメータが存在しない場合は、引数は-1となっているので、
		  これで判別する。また、どちらのパラメータも存在しない(-1である)場合は
		  trueを返し、全ての商品が該当するようにする*/
		if(selectedSubCategoryId == -1){
			if(selectedCategoryId == product.getCategoryId()
			|| selectedCategoryId == -1){
				return true;
			}
		}
		return false;
	}

	private boolean judgeTextMatch(
	ProductCatalogBean product,String[] searchTexts)
	throws LogicException{
		/*検索条件の文字列が存在しないなら常に条件合致とする*/
		if(searchTexts == null){
			return true;
		}else{
			/*検索条件の文字列が存在する場合、
			  検索文字列全てと合致するかを判定する*/
			/*「全ての検索文字列を持っている」を持つ変数を宣言*/
			boolean isAllTextExist = true;
			for(String searchText : searchTexts){
				/*商品名が検索文字列を含んでいないなら*/
				if(product.getProductName().indexOf(searchText) == -1){
					/*「全ての検索文字列を持っている」を偽にする*/
					isAllTextExist = false;
				}
			}
			/*「全ての検索文字列を持っている」が真なら*/
			if(isAllTextExist){
				/*文字列の検索条件に合致することを表すtrueを返す*/
				return true;
			}
		}
		return false;
	}

	/*引数の商品の名前に一致する商品詳細のIDのListを返すメソッド*/
	private List<String> getProductTagNames(String productName){
		/*引数の商品の名前に一致する商品詳細のIDのListを宣言*/
		List<String> productsId = new ArrayList();

		/*商品詳細のイテレータを取得*/
		Iterator productIterator = allProductList.iterator();
		while(productIterator.hasNext()){
			ProductBean product = (ProductBean)productIterator.next();
			/*現在の商品詳細の名前と引数の名前が一致するなら、*/
			if(product.getProductName().equals(productName)){
				/*その商品詳細のIDをArrayListに加える*/
				productsId.add(product.getProductId());
			}
		}
		/*引数の商品につけられているタグの名前のListを宣言*/
		List<String> productTagNames = new ArrayList();

		/*引数の商品の名前に一致する商品詳細のIDのイテレータを取得*/
		Iterator productsIdIterator = productsId.iterator();
		while(productsIdIterator.hasNext()){
			String productId = (String)productsIdIterator.next();
			/*タグ情報のイテレータを取得*/
			Iterator tagIterator = allTagList.iterator();
			while(tagIterator.hasNext()){
				TagBean tagRelation = (TagBean)tagIterator.next();
				/*商品情報のIDとタグ表の行の商品IDが一致するなら、*/
				if(productId.equals(tagRelation.getProductId())){
					/*そのタグの名前をArrayListに加える*/
					productTagNames.add(tagRelation.getTagName());
				}
			}
		}
		return productTagNames;
	}

	private boolean judgeTagMatch(List productTagNames,List searchTags)
	throws LogicException{
		/*検索条件のタグが存在しないなら常に条件合致とする*/
		if(searchTags == null){
			return true;
		}else{
			/*検索条件のタグが存在する場合、
			  検索タグ全てと合致するかを判定する*/
			/*「全ての検索タグを持っている」を持つ変数を宣言*/
			boolean isAllTagExist = true;
			Iterator searchTagIterator = searchTags.iterator();
			while(searchTagIterator.hasNext()){
				String searchTagName
				= (String)searchTagIterator.next();
				/*商品に付加されているタグの中に
				  検索条件のタグが無いなら*/
				if(!(productTagNames.contains(searchTagName)) ){
					/*「全ての検索タグを持っている」を偽にする*/
					isAllTagExist = false;
				}
			}
			/*「全ての検索タグを持っている」が真なら*/
			if(isAllTagExist){
				/*「文字列のタグ条件に合致する」ことを変数に格納*/
				return true;
			}
		}
		return false;
	}

	/*全ての使用する表のListをインスタンス変数に格納するメソッド*/
	private void getAllDataList(int[] sortArray)
	throws LogicException{
		try{
			/*Daoを取得するためのDaoFactoryを取得する*/
			factory = AbstractDaoFactory.getFactory();

			/*タグの情報を取得するためのDaoを取得*/
			tagDao = factory.getTagDao();
			/*全タグの情報を取得*/
			allTagList = tagDao.getTags();

			/*サブカテゴリの情報を取得するためのDaoを取得する*/
			subCategoryDao = factory.getSubCategoryDao();
			/*Daoからサブカテゴリの情報を取得する*/
			allSubCategoryList = subCategoryDao.getSubCategories();

			/*カテゴリの情報を取得するためのDaoを取得*/
			categoryDao = factory.getCategoryDao();
			/*全カテゴリの情報を取得*/
			allCategoryList = categoryDao.getCategories();

			/*お気に入りの情報を取得するためのDaoを取得する*/
			favoriteDao = factory.getFavoriteDao();
			/*Daoからお気に入りの情報を取得する*/
			allFavoriteList = favoriteDao.getFavorites();

			/*商品詳細情報を取得するためのDaoを取得*/
			productDao = factory.getProductDao();
			/*全商品詳細の情報を取得*/
			allProductList = productDao.getProducts();

			/*商品カタログの情報を取得するためのDaoを取得する*/
			productCategoryDao = factory.getProductCatalogDao();
			/*全商品カタログの情報を取得。sortArrayによってソート条件を設定*/
			allCatalogList = productCategoryDao.getProductCatalogs(sortArray);
		}catch (IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
	}
}