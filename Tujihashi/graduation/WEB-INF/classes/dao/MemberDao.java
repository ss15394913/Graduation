/*
  @author 池田大和
*/
package dao;

import java.util.List;

import bean.MemberBean;
import ex.IntegrationException;

/*会員の情報を取得するために利用するデータアクセスオブジェクト*/
public interface MemberDao {
	/*全ての会員の情報を取得するメソッド*/
	public List getMembers() throws IntegrationException;
	/*新しい会員の登録を行うメソッド*/
	public void registMember(MemberBean member) throws IntegrationException;
	/*引数のBeanのmemberIdに一致するIDを持つ会員の情報の変更するメソッド*/
	public void editMember(MemberBean member) throws IntegrationException;
}