package command;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className AbstractCommand
 *@author Kohichi Tujihashi
 *@date 2017/01/26
 *@description
 */
public class AddTempUserCommand extends AbstractCommand{
	/**クライアントからのリクエスト*/
	private RequestContext requestContext;

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{


		try {
            Properties property = new Properties();

            // 各種設定
            property.put("mail.smtp.host", "smtp.gmail.com");
            //property.put("mail.smtp.host", "smtp.mail.yahoo.co.jp");
            property.put("mail.smtp.auth", "true");
            property.put("mail.smtp.starttls.enable", "true");
            property.put("mail.smtp.host", "smtp.gmail.com");
            property.put("mail.smtp.port", "587");
            property.put("mail.smtp.debug", "true");

            Session session = Session.getInstance(property,
                new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    //"Gメールアカウント", "パスワード");
                    "kt15304014@ga.tera-house.ac.jp", "Br7dHHgW");
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);

            InternetAddress toAddress = new InternetAddress(
                    //"宛先メールアドレス", "宛先名");
                    "kt15304014@ga.tera-house.ac.jp", "ツジハシ");

            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);

            InternetAddress fromAddress = new InternetAddress(
                //"送信","管理者");
                "kt15304014@ga.tera-house.ac.jp","辻橋");

            mimeMessage.setFrom(fromAddress);

            mimeMessage.setSubject("テストメール", "ISO-2022-JP");
            mimeMessage.setText("http://localhost:8080/watercress/front/entrycodeで登録！", "ISO-2022-JP");

            Transport.send(mimeMessage);

            System.out.println("送信完了");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("エラー");
        }



		RequestContext reqc = getRequestContext();



		responseContext.setTarget( "entrytemp" );

		//AppricationControllerのsetAttributeに
		//登録するためにsetResultメソッドを使ってbeanを登録
		return responseContext;
	}
}
