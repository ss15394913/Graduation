/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.SubCategoryBean;
import ex.IntegrationException;

/*サブカテゴリの情報を取得するために利用するデータアクセスオブジェクト*/
public interface SubCategoryDao {
	/*全てのサブカテゴリの情報を取得するメソッド*/
	public List getSubCategories() throws IntegrationException;
}