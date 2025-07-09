package biz.promanage.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class PromanageMailAlert {
    public static void SendMail(String subject, String body,String mailTo) {

        final String username = "qa@sulekha.com";
        final String password = "Testing52024";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "outlook.office365.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("qa@sulekha.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
            message.setSubject(subject);
            message.setContent(body, "text/html");
            message.addHeader("X-Priority", "1");
            Transport.send(message);
            System.out.println("Mail Sent....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
