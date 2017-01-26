package ex;
/*LogicExceptionクラスを継承したSQLExceptionが出たときの例外クラス*/
public class IllegalSQLException extends IntegrationException {
	/*コンストラクタ*/
	public IllegalSQLException(String mess, Throwable e) {
		super(mess, e);
	}
}
