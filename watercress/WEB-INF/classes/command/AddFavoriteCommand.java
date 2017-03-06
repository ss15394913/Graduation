package command;

import bean.FavoriteBean;
import dao.AbstractDaoFactory;
import dao.FavoriteDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;
/**
 *@author 河野
 *@date 2017/01/31
 */
public class AddFavoriteCommand extends AbstractCommand{

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		/*親クラスのメソッドを利用しRequestContextのインスタンスを取得*/
		RequestContext requestContext = getRequestContext();

		FavoriteBean favorite = new FavoriteBean();
		/*お気に入り表に追加する商品のIDを取得し格納--------*/
		favorite.setProductId( (String)requestContext.getParameter("productId")[0]);

		/*お気に入り表に追加する会員のIDを取得*/
		String id = (String)requestContext.getSessionAttribute("login");
		int memberId = Integer.parseInt(id);

		/*お気に入り表に追加する会員のIDを格納*/
		favorite.setMemberId(memberId);

		try{

		/*お気に入り追加処理ーーーーーーーーーーーーーーーーーーーーーーーー*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			/*FavoriteDao型の変数ににOraFavoriteDaoインスタンスを入れる*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*Favorite表に追加*/
			favoriteDao.addFavorite(favorite);

		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}
		responseContext.setTarget("productlist");

		return responseContext;
	}
}