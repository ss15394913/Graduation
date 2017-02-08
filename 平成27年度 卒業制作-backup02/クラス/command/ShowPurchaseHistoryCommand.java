package command;

import java.util.List;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import bean.PurchaseHistoryBean;
import dao.PurchaseHistoryDao;
import dao.OraPurchaseHistoryDao;
import dao.AbstractDaoFactory;

import logic.ResponseContext;
import logic.RequestContext;
import logic.WebRequestContext;
import ex.IntegrationException;
import ex.LogicException;

/**
 *@className ShowPurchaseHistoryCommand
 *@author 河野
 *@date 2017/01/31
 *@description 
 */

public class ShowPurchaseHistoryCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		/*RequestContextのインスタンスを取得*/
		RequestContext requestContext = new WebRequestContext();
		
		/*getParameterでページ番号を取得*/
		int pageNum = Integer.parseInt(requestContext.getParameter("pageNumber")[0]);
		
		/*購入リストを全件取得のためのリスト*/
		List allPurchaseList = null;
		
		/*returnで返すためのリスト*/
		List returnPurchaseList = null;
		
		try{
			/*AbstractDaoFactoryのインスタンスを取得*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			
			/*PurchaseHistoryDaoのインスタンスを取得*/
			PurchaseHistoryDao purchaseHistoryDao = factory.getPurchaseHistoryDao();
			/*購入リストを全件取得*/
			allPurchaseList = purchaseHistoryDao.getPurchaseHistories();
			
			/*購入リスト分ループ*/
			for(int i = 0; i <= allPurchaseList.size();){
				
				/*表示を10に絞る*/
				if((pageNum - 1) * 10 <= i && i <= pageNum * 10 - 1){
					
					PurchaseHistoryBean purchaseHistory = 
							(PurchaseHistoryBean)allPurchaseList.get(i);
					
					returnPurchaseList.add(allPurchaseList.get(i));
			
					i++;
				}
			}
		
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*セッションスコープにインスタンスを保存*/
		requestContext.setSessionAttribute("pageNum",pageNum);
		
		/*responseで送る値をセット*/
		responseContext.setResult(returnPurchaseList);
		
		/*転送先のビューを指定*/
		responseContext.setTarget("orderhistory");
		
		/*returnで結果を返す*/
		return responseContext;
	}
}