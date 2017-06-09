package com.miku;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created with com.miku
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/10 0010
 * Time :       13:45
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "james.com");
        Session session = Session.getInstance(props,
                new Authenticator()
                {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("admin","admin");
                    }
                }
        );
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("test@james.com"));
        msg.setSubject("中文主题");
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("test@james.com"));
        msg.setContent("<span style='color:red'>中文呵呵呵</span>", "text/html;charset=utf-8");


        Transport.send(msg);

    }

}
