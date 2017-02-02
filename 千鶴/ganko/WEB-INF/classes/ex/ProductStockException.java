package ex;
/*LogicExceptionクラスを継承した在庫が足りないときの例外クラス*/
public class ProductStockException extends LogicException {
	/*コンストラクタ*/
	public ProductStockException(String mess, Throwable e) {
		super(mess, e);
	}
}
