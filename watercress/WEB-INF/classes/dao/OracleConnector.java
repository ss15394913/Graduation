/*
  @author �r�c��a
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ex.IntegrationException;
import ex.ConnectorException;

/*Oracle�f�[�^�x�[�X�̃R�l�N�V�������擾���邽�߂̃N���X*/
public class OracleConnector implements Connector{
	/*�R�l�N�V���������ϐ�*/
	Connection connection;
	/*�R�l�N�V�������擾����R���X�g���N�^*/
	public OracleConnector(String user, String password)
	throws IntegrationException {
		try{
			/*�f�[�^�x�[�X�ւ̐ڑ�*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", user, password);
		}catch(ClassNotFoundException e){
			throw new ConnectorException(e.getMessage(), e);
		}catch(SQLException e){
			throw new ConnectorException(e.getMessage(), e);
		}
	}
	/*�擾�����R�l�N�V������Ԃ����\�b�h*/
	public Connection getConnection(){
		return connection;
	}
}