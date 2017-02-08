package ex;
/*LogicExceptionを継承したプロフィール入力の不正に関する例外クラス*/
public class InputException extends LogicException {
	/*コンストラクタ*/
	public InputException(String mess, Throwable e) {
		super(mess, e);
	}
}
