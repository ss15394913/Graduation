import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendGMailSample {
    public static void main(String[] args) {
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
                    "yi15304002@ga.tera-house.ac.jp", "s2aYRu8G");
                }
            });
 
            MimeMessage mimeMessage = new MimeMessage(session);
 
            InternetAddress toAddress = new InternetAddress(
                    //"宛先メールアドレス", "宛先名");
                    "yi15304002@ga.tera-house.ac.jp", "池田大和");
 
            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
 
            InternetAddress fromAddress = new InternetAddress(
                //"送信","管理者");
                "yi15304002@ga.tera-house.ac.jp","池田大和");
 
            mimeMessage.setFrom(fromAddress);
 
            mimeMessage.setSubject("テストメール", "ISO-2022-JP");
            mimeMessage.setText("テストメールです", "ISO-2022-JP");
 
            Transport.send(mimeMessage);
 
            System.out.println("送信完了");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("エラー");
        }
    }
}