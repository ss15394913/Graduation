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
 
            // �e��ݒ�
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
                    //"G���[���A�J�E���g", "�p�X���[�h");
                    "yi15304002@ga.tera-house.ac.jp", "s2aYRu8G");
                }
            });
 
            MimeMessage mimeMessage = new MimeMessage(session);
 
            InternetAddress toAddress = new InternetAddress(
                    //"���惁�[���A�h���X", "���於");
                    "yi15304002@ga.tera-house.ac.jp", "�r�c��a");
 
            mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
 
            InternetAddress fromAddress = new InternetAddress(
                //"���M","�Ǘ���");
                "yi15304002@ga.tera-house.ac.jp","�r�c��a");
 
            mimeMessage.setFrom(fromAddress);
 
            mimeMessage.setSubject("�e�X�g���[��", "ISO-2022-JP");
            mimeMessage.setText("�e�X�g���[���ł�", "ISO-2022-JP");
 
            Transport.send(mimeMessage);
 
            System.out.println("���M����");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("�G���[");
        }
    }
}