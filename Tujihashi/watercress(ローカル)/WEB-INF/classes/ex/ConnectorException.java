package ex;
/*IntegrationExceptionクラスを継承した接続に関する例外クラス*/
public class ConnectorException extends IntegrationException {
	/*コンストラクタ*/
	public ConnectorException(String mess, Throwable e) {
		super(mess, e);
	}
}
