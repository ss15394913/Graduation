package ex;
/*AppExceptionクラスを継承したインテグレーション全般に関する例外クラス*/
public class IntegrationException extends AppException {
	/*コンストラクタ*/
	public IntegrationException(String mess, Throwable e) {
		super(mess, e);
	}
}
