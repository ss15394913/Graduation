/*
  @author 池田大和
*/
package dao;

/*データベースのコネクションを取得するためのクラスのインターフェイス*/
public interface Connector{
	/*取得したコネクションを返すメソッド*/
	public Object getConnection();
}