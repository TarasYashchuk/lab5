package mailsender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.*;
import java.util.Properties;


public class MailSender {
    public static void sendMessage(Exception e) {
        final String username = "taras.yashchuk.oi.2022@lpnu.ua";
        final String password = "cdnk lmvp ewnl vltw";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        session.setDebug(true);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("taras.yashchuk.oi.2022@lpnu.ua"));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("taras.yashchuk.oi.2022@lpnu.ua"));
            message.setSubject("Error in the application");
            message.setText("An error occurred:\n\n" + e.toString());
            Transport.send(message);
        } catch (Exception ex) {
            e.printStackTrace();
        }
    }
}
