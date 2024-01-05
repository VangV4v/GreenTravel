package com.cusc.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kyqua
 */
public class SendMail {

    public static boolean sendMail(String address, String subject, String content) throws AddressException, MessagingException {
        String str = "Dear " + address + "! This mail sent from GreenTravel website. <br/>";
        //
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;
        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(address)); //Thay abc b?ng ??a ch? ng??i nh?n
        // B?n c� th? ch?n CC, BCC
        //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //??a ch? cc gmail
        mailMessage.setSubject(subject);

        mailMessage.setContent(str + content, "text/html");
        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");
        // Thay your_gmail th�nh gmail c?a b?n, thay your_password th�nh m?t kh?u gmail c?a b?n
        transport.connect("smtp.gmail.com", "hpnama18099@cusc.ctu.edu.vn", "cp1896g05");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
        return true;
    }
}
