package command;

import bean.FavoriteBean;
import dao.AbstractDaoFactory;
import dao.FavoriteDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@author 宇津野
 *@date 2017/01/31
 */
public class DeleteFavoriteCommand extends AbstractCommand{

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{

		/*親クラスのメソッドを利用しRequestContextのインスタンスを取得*/
		RequestContext requestContext = getRequestContext();

		FavoriteBean favorite = new FavoriteBean();
		/*お気に入り表に追加する商品のIDを取得し格納--------*/
		favorite.setProductId( (String)requestContext.getParameter( "productid" )[0]);

		/*お気に入り表に追加する会員のIDを取得-----------*/
		String id = (String)requestContext.getSessionAttribute("login");
		int memberId = Integer.parseInt(id);

		/*お気に入り表から削除する商品の会員IDを格納*/
		favorite.setMemberId(memberId);

		try{
		/*お気に入り削除処理ーーーーーーーーーーーーーーーーーーーーーーー*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			/*FavoriteDao型の変数ににOraFavoriteDaoインスタンスを入れる*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*Favorite表から削除*/
			favoriteDao.removeFavorite(favorite);

		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}

		responseContext.setTarget("productlist");
		return responseContext;
	}
}