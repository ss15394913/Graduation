package ex;

public class NoContentException extends LogicException {
	public NoContentException(String mess, Throwable e) {
		super(mess, e);
	}
}
