/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.FavoriteBean;
import ex.IntegrationException;

/*お気に入りの情報を取得するために利用するデータアクセスオブジェクト*/
public interface FavoriteDao {
	/*全てのお気に入りの情報を取得するメソッド*/
	public List getFavorites() throws IntegrationException;
	/*お気に入りを登録するメソッド*/
	public void addFavorite(FavoriteBean favorite) throws IntegrationException;
	/*お気に入りを削除するメソッド*/
	public void removeFavorite(FavoriteBean favorite) throws IntegrationException;
}