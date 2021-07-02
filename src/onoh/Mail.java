package onoh;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail
{
    String msg;
    public Mail(String message)
    {
        msg = message;
    }
    void mail()
    {
        Sender sender = new Sender();
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.user", sender.uname);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //props.put("mail.smtp.socketFactory.port", "465");
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.socketFactory.fallback", "false"); 
        try
        {

            Session session = Session.getInstance(props, null);
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setText(msg);
            message.setSubject("ONOH");
            message.setFrom(new InternetAddress(sender.uname));
            message.addRecipient(RecipientType.TO, new InternetAddress("kairostimeyt1@gmail.com"));
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", sender.uname, sender.upwd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        javax.swing.JOptionPane.showMessageDialog(null, "EMAIL SENT SUCCESSFULLY");
    }
}