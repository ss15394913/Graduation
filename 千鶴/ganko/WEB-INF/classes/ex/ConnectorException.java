package ex;
/*IntegrationException�N���X���p�������ڑ��Ɋւ����O�N���X*/
public class ConnectorException extends IntegrationException {
	/*�R���X�g���N�^*/
	public ConnectorException(String mess, Throwable e) {
		super(mess, e);
	}
}
