package ex;
/*LogicException�N���X���p�������݌ɂ�����Ȃ��Ƃ��̗�O�N���X*/
public class ProductStockException extends LogicException {
	/*�R���X�g���N�^*/
	public ProductStockException(String mess, Throwable e) {
		super(mess, e);
	}
}
