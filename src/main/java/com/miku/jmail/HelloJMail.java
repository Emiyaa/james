package com.miku.jmail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * Created with com.miku.jmail
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/7 0007
 * Time :       16:55
 */
public class HelloJMail {

    //发送邮件
    public static void sendMail() {
        //String host = "192.168.1.98"; // 指定的smtp服务器，本机的局域网IP
        String host = "localhost"; // 本机smtp服务器
        //String host = "smtp.163.com"; // 163的smtp服务器
        String from = "admin@james.com"; // 邮件发送人的邮件地址
        String to = "admin@james.com"; // 邮件接收人的邮件地址
        final String username = "admin";  //发件人的邮件帐户
        final String password = "admin";   //发件人的邮件密码

        // 创建Properties 对象
        Properties props = System.getProperties();

        // 添加smtp服务器属性
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        // 创建邮件会话
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }

        });

        try {
            // 定义邮件信息
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    to));
//            message.setSubject("I hava my own mail server");

            message.setSubject(transferChinese("主题"));// 设置主题
            message.setContent(transferChinese("正文") , "text/html;charset=utf-8");// 设置内容

            // 发送消息
            session.getTransport("smtp").send(message);
            //Transport.send(message); //也可以这样创建Transport对象发送
            System.out.println("SendMail Process Over!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //接受邮件
    public static void getMail(){
        String host = "localhost";
        final String username = "admin";
        final String password = "admin";

        // 创建Properties 对象
        Properties props = new Properties();

        // 创建邮件会话
        Session session = Session.getDefaultInstance(props, new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }

        });


        try {
            // 获取邮箱的pop3存储
            Store store = session.getStore("pop3");
            store.connect(host, username, password);

            // 获取inbox文件
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);  //打开，打开后才能读取邮件信息

            // 获取邮件消息
            Message message[] = folder.getMessages();

            for (int i=0, n=message.length; i<n; i++) {
                System.out.println(i + ": " + message[i].getFrom()[0]
                        + "\t" + message[i].getSubject());
                try {
                    message[i].writeTo(System.out);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            // 关闭资源
            folder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        System.out.println("GetMail Process Over!");

    }

    //邮件主题中文字符转换
    public static String transferChinese(String strText){
        try{
            strText = MimeUtility.encodeText(new String(strText.getBytes(), "UTF-8"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return strText;
    }

    public static void main(String[] args) {
//        HelloJMail.sendMail();
        HelloJMail.getMail();
    }

}