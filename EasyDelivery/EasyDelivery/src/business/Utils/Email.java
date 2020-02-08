/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Gunjan
 */
public class Email {
    
    public static void send(String phoneNumber,String serviceProvider,String name ,String EmailId){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");//we can use 587 also
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("easyDeliveryNeu", "easy12345");
            }
        }
        );
        try {
            String networkEmail = "@tmomail.net";
            String sp = serviceProvider;
            if (null != sp) switch (sp) {
                case "Sprint":
                    networkEmail = "@messaging.sprintpcs.com";
                    break;
                case "T-Mobile":
                    networkEmail = "@tmomail.net";
                    break;
                case "AT&T":
                    networkEmail = "@txt.att.net";
                    break;
                default:
                    break;
            }
            
            String contact = phoneNumber.isEmpty() ? "6314825267" : phoneNumber;
            String contactEmail = contact + networkEmail;
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("easyDeliverNeu@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EmailId + "," + contactEmail));
            message.setSubject("Easy Delivery");
            message.setSentDate(new Date());
            message.setText("Hi, " + name + "\n Thank you for Shopping with EasyDelivery!! \n Your Order placed has been placed!!");
            Transport.send(message);
            
        } catch (Exception e) {
        }
    }
}
