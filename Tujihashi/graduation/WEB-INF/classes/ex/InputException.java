package ex;
/*LogicException���p�������v���t�B�[�����͂̕s���Ɋւ����O�N���X*/
public class InputException extends LogicException {
	/*�R���X�g���N�^*/
	public InputException(String mess, Throwable e) {
		super(mess, e);
	}
}
