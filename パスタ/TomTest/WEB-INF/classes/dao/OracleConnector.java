/*
  @author 池田大和
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ex.IntegrationException;
import ex.ConnectorException;

/*Oracleデータベースのコネクションを取得するためのクラス*/
public class OracleConnector implements Connector{
	/*コネクションを持つ変数*/
	Connection connection;
	/*コネクションを取得するコンストラクタ*/
	public OracleConnector(String user, String password)
	throws IntegrationException {
		try{
			/*データベースへの接続*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", user, password);
		}catch(ClassNotFoundException e){
			throw new ConnectorException(e.getMessage(), e);
		}catch(SQLException e){
			throw new ConnectorException(e.getMessage(), e);
		}
	}
	/*取得したコネクションを返すメソッド*/
	public Connection getConnection(){
		return connection;
	}
}