package ex;
/*LogicException�N���X���p���������O�C���Ɋւ����O�N���X*/
public class LoginException extends LogicException {
	/*�R���X�g���N�^*/
	public LoginException(String mess, Throwable e) {
		super(mess, e);
	}
}
