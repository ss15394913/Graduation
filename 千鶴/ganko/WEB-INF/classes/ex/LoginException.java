package ex;
/*LogicExceptionクラスを継承したログインに関する例外クラス*/
public class LoginException extends LogicException {
	/*コンストラクタ*/
	public LoginException(String mess, Throwable e) {
		super(mess, e);
	}
}
