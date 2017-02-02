package ex;
/*AppExceptionクラスを継承したビジネスロジック全般に関する例外クラス*/
public class LogicException extends AppException {
	/*コンストラクタ*/
	public LogicException(String mess, Throwable e) {
		super(mess, e);
	}
}
