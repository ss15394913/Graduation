/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.CategoryBean;
import ex.IntegrationException;

/*カテゴリの情報を取得するために利用するデータアクセスオブジェクト*/
public interface CategoryDao {
	/*全てのカテゴリの情報を取得するメソッド*/
	public List getCategories() throws IntegrationException;
}