/*
  @author 池田大和
*/
package dao;

import java.util.List;
import bean.MemberStatusBean;
import ex.IntegrationException;

/*会員の状態の情報を取得するために利用するデータアクセスオブジェクト*/
public interface MemberStatusDao {
	/*全ての会員の状態の情報を取得するメソッド*/
	public List getMemberStatuses() throws IntegrationException;
}