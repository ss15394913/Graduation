package ex;
/*LogicException�N���X���p������SQLException���o���Ƃ��̗�O�N���X*/
public class IllegalSQLException extends IntegrationException {
	/*�R���X�g���N�^*/
	public IllegalSQLException(String mess, Throwable e) {
		super(mess, e);
	}
}
