package org.jdbc.maven.SendingMail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSending {

	public static void main(String[] args) throws MessagingException {
		String from = "exams.reddy@gmail.com";
		String to = "krsr6666@gmail.com";
		String subject = "ind vs eng match";
		String text = "india won by 100 runs";

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("exams.reddy@gmail.com", "dgus stuw wsvg duvi");
			}

		});

		session.setDebug(true);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(text);

		Transport.send(message);
		System.out.println("India is now top of the table with6 consecutive wins");

	}

}
