//�e�X�g�� �r�c��a
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailToLocalhostExample {
    public static void main(String... args) {
        // x-windows-iso2022jp��ISO-2022-JP�̃G�C���A�X��
        System.setProperty("sun.nio.cs.map", "x-windows-iso2022jp/ISO-2022-JP");

        Properties properties = new Properties();

        // SMTP�T�[�o�̃z�X�g�� or IP�A�h���X
        properties.put("mail.smtp.host", "localhost");
        // SMTP�T�[�o�̃|�[�g
        properties.put("mail.smtp.port", "25");
        
        //�������g��25�ԃ|�[�g�֑��M����ݒ�
        
        // �f�o�b�O�����o�͂���ꍇ
        properties.put("mail.debug", "true");

        try {
            Session session = Session.getDefaultInstance(properties);

            // ���M���b�Z�[�W
            MimeMessage message = new MimeMessage(session);

            // From
            message.setFrom(new InternetAddress("from-address@example.com"));
            // ����iTO�j
            message.setRecipients(MimeMessage.RecipientType.TO,
                                  new InternetAddress[] { new InternetAddress("to-address@example.com") });

            // ��������і{��
            message.setSubject(args[0], "ISO-2022-JP");
            message.setText(args[1], "ISO-2022-JP");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}