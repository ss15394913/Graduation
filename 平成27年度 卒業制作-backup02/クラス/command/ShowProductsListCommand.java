package command;

import java.util.List;
import java.util.Iterator;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import bean.ProductCatalogBean;
import bean.SubCategoryBean;
import dao.ProductCatalogDao;
import dao.OraProductCatalogDao;
import dao.SubCategoryDao;
import dao.AbstractDaoFactory;

import logic.ResponseContext;
import logic.RequestContext;
import logic.WebRequestContext;
import ex.IntegrationException;
import ex.LogicException;

/**
 *@className ShowProductsListCommand
 *@author 河野
 *@date 2017/01/31 ページ番号をセッションで管理する修正をしました。
 *@description 
 */

public class ShowProductsListCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		
		/*RequestContextのインスタンスを取得*/
		RequestContext requestContext = new WebRequestContext();
		
		/*ページの番号*/
		int pageNum = Integer.parseInt(requestContext.getParameter("pageNumber")[0]);
		
		/*選択されたサブカテゴリ*/
		String selectedSubCategory = requestContext.getParameter("subCategory")[0];
		
		int selectedSubCategoryId = 0;
		
		/*ソート用の変数
		  priceAsc = 値段の安い順
		  priceDesc = 値段の高い順
		  purchaseAsc = 購入数が少ない順
		  purchaseDesc = 購入数が多い順
		  nameAsc =50音順
		  nameDesc =50音順の逆順 
		*/
		String[] sortParam = requestContext.getParameter("sort");
		
		/*getProductCatalogsに渡す引数*/
		int[] sortArray = new int[3];
		
		/*全サブカテゴリの情報のリスト*/
		List allSubCategoryList = null; 
		
		/*全商品の情報のリスト*/
		List allCatalogList = null; 
		
		/*クライアントに返す商品情報*/
		List returnProductsList = null;
		
		for(int i = 0;i<=sortParam.length;i++){
			
			/*sortParamの中身に対応した文字列によりソートする*/
			if(sortParam[i].equals("priceAsc")){
				sortArray[0] = ProductCatalogDao.SORT_BY_PRICE_ASC;
			}
			else if(sortParam[i].equals("priceDesc")){
				sortArray[0] = ProductCatalogDao.SORT_BY_PRICE_DESC;
			}
			else if(sortParam[i].equals("purchaseAsc")){
				sortArray[1] = ProductCatalogDao.SORT_BY_PURCHASE_COUNT_ASC;
			}
			else if(sortParam[i].equals("purchaseDesc")){
				sortArray[1] = ProductCatalogDao.SORT_BY_PURCHASE_COUNT_DESC;
			}
			else if(sortParam[i].equals("nameAsc")){
				sortArray[2] = ProductCatalogDao.SORT_BY_NAME_ASC;
			}
			else if(sortParam[i].equals("nameDesc")){
				sortArray[2] = ProductCatalogDao.SORT_BY_NAME_DESC;
			}
		}
		try{
			
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			
			/*Daoからサブカテゴリの情報を取得する*/
			SubCategoryDao subCategoryDao = factory.getSubCategoryDao();
			allSubCategoryList = subCategoryDao.getSubCategories();
			
			Iterator SubCategoryIterator = allSubCategoryList.iterator();
			while(SubCategoryIterator.hasNext()){
				/*サブカテゴリのBeanを取得*/
				SubCategoryBean subCategory
				= (SubCategoryBean)SubCategoryIterator.next();
				/*Beanの中のサブカテゴリの名前と、クライアントが選択した
				  サブカテゴリの名前が同じなら、そのサブカテゴリのIDを
				  変数に格納する*/
				if(subCategory.getSubCategoryName()
					.equals(selectedSubCategory)){
						selectedSubCategoryId
						= subCategory.getSubCategoryId();
					break;
				}
			}
			
			/*Daoから商品の情報を取得する*/
			ProductCatalogDao pcd = factory.getProductCatalogDao();
			
			/*全商品の情報*/
			/*どのようにソートさせるかを決定させる*/
				allCatalogList = pcd.getProductCatalogs(sortArray);
			
			/*全商品の商品数分*/
			for(int i=0; i <= allCatalogList.size();){
				/*15個ずつ絞る*/
				if((pageNum - 1) * 15 <= i && i <= pageNum * 15 - 1){
					/*List内の商品情報のBeanを取り出す*/
					ProductCatalogBean product
					= (ProductCatalogBean)allCatalogList.get(i);
					/*選択されたサブカテゴリの商品なら、
					  クライアントに返す商品情報に加える*/
					if(product.getSubCategoryId()== selectedSubCategoryId){
						returnProductsList.add(allCatalogList.get(i));
						i++;
					}
				}
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*セッションスコープにインスタンスを保存*/
		requestContext.setSessionAttribute("pageNum",pageNum);
		
		/*responseで送る値をセット*/
		responseContext.setResult(returnProductsList);
		
		/*転送先のビューを指定*/
		responseContext.setTarget("productlist");
		
		/*returnで結果を返す*/
		return responseContext;
	}
}