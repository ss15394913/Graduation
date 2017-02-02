/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.TagBean;
import ex.IntegrationException;

/*タグの情報を取得するために利用するデータアクセスオブジェクト*/
public interface TagDao {
	/*全てのタグの情報を取得するメソッド*/
	public List getTags() throws IntegrationException;
}