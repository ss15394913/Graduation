import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
*/
public class SendGMailSample2 {
  //private static final Logger log = LoggerFactory.getLogger(JavaMailSample.class);

  public static void main(String[] args) {
    SendGMailSample2 mailSend = new SendGMailSample2();
    mailSend.send("JavaMail テストメール", "テストメールの本文");
  }

  public void send(String subject, String content) {

    final String to = "yi15304002@ga.tera-house.ac.jp";
    final String from = "dikteim@gmail.com";

    // Google account mail address
    final String username = "yi15304002@ga.tera-house.ac.jp";
    // Google App password
    final String password = "s2aYRu8G";

    //final String charset = "ISO-2022-JP";
    final String charset = "UTF-8";

    final String encoding = "base64";

    // for gmail
    String host = "smtp.gmail.com";
    String port = "587";
    String starttls = "true";

    // for local
    //String host = "localhost";
    //String port = "2525";
    //String starttls = "false";

    Properties props = new Properties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", starttls);

    props.put("mail.smtp.connectiontimeout", "10000");
    props.put("mail.smtp.timeout", "10000");

    props.put("mail.debug", "true");

    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(username, password);
       }
    });

    try {
      MimeMessage message = new MimeMessage(session);

      // Set From:
      message.setFrom(new InternetAddress(from, "Watanabe Shin"));
      // Set ReplyTo:
      message.setReplyTo(new Address[]{new InternetAddress(from)});
      // Set To:
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

      message.setSubject(subject, charset);
      message.setText(content, charset);

      message.setHeader("Content-Transfer-Encoding", encoding);

      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }

  }

}