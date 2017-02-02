package ex;
/*Exceptionクラスを継承したクラス*/
public class AppException extends Exception {
	/*コンストラクタ*/
	public AppException(String mess,Throwable e){
		super(mess,e);
	}
}
