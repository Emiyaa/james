package com.miku.util;

import com.miku.po.Mail;
import com.miku.po.Rsakey;
import com.miku.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created with com.miku.util
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/12 0012
 * Time :       14:36
 */
@Component
public class MailUtil {

    @Autowired
    private PraseMessage praseMessage;

    @Autowired
    private Base64Util base64Util;

    @Autowired
    private RSAUtils rsaUtils;

    @Autowired
    private RSATest rsaTest;

    //发送邮件
    public boolean sendMail(Mail mail, HttpSession httpSession) throws Exception {

        //获取邮件发送目的服务器
        int index = mail.getRecipient().indexOf("@");
        String host = mail.getRecipient().substring(++index);
        if (!("james.com".equals(host))) {
            host = "smtp." + host;
        }

        //获取用户名和密码
        User user = (User) httpSession.getAttribute("user");
        final String username = user.getUsername();
        final String password = (String) httpSession.getAttribute("pwd");

        // 创建Properties 对象
        Properties props = System.getProperties();
        // 添加smtp服务器属性
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.host", host);

        // 创建邮件会话
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        //打开调试
        session.setDebug(true);

        // 定义邮件信息
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(mail.getSender()));
        msg.setSubject(mail.getSubject());
        msg.setSentDate(new Date());
        mail.setSendtime(new Date());
        msg.addRecipient(Message.RecipientType.TO , new InternetAddress(mail.getRecipient()));

        Rsakey rsakey = new Rsakey();
        rsakey = rsaUtils.getRsakey();

//        System.err.println(rsakey.getPublickey());
//        System.err.println(rsakey.getPrivatekey());
//        String content = mail.getContent();
//        System.out.println("将被加密字符串: " + content);
//        byte[] e = rsaTest.encrypt(rsakey.getPublickey(), str.getBytes());
//        content = rsaTest.bytesToString(e);
//        System.out.println("加密的字符串的字节，使用bytesToString()方法将字节转换为字符串: " + content);
//        msg.setContent(content, "text/html;charset=utf-8");

        System.err.println("公钥加密——私钥解密");
        String source = mail.getContent();
        System.out.println("\r加密前文字：\r\n" + source);
        System.err.println(rsakey.getPublickey());
        System.err.println(rsakey.getPrivatekey());

        System.out.println("将被加密字符串: " + source);
        byte[] e = rsaTest.encrypt(rsakey.getPublickey(), source.getBytes());
        String tmp1 = rsaTest.bytesToString(e);
        System.out.println("加密的字符串的字节，使用bytesToString()方法将字节转换为字符串: " + tmp1);
        msg.setContent(tmp1, "text/html;charset=utf-8");

//        byte[] data = source.getBytes();
//        byte[] encodedData = RSAUtils.encryptByPublicKey(data, rsakey.getPublickey());
//        System.out.println("加密后文字：\r\n" + new String(encodedData));

//        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, rsakey.getPrivatekey());
//        String target = new String(decodedData);
//        System.out.println("解密后文字: \r\n" + target);

//        msg.setContent(new String(encodedData), "text/html;charset=utf-8");

//        String content = mail.getContent();
//        content = transferChinese(content);
//        int indexOf = content.indexOf("?B?");
//        content = content.substring(indexOf);
//        msg.setContent(content, "text/html;charset=utf-8");

        // 发送消息
        session.getTransport("smtp").send(msg);

        return true;

    }

        //接受邮件
    public List<Mail> recipientMail(HttpSession httpSession) throws Exception {

        List<Mail> mails = new ArrayList<>();

        //获取用户名和密码
        User user = (User) httpSession.getAttribute("user");
        final String username = user.getUsername();
        final String password = (String) httpSession.getAttribute("pwd");

        //获取邮件发送目的服务器
        String umail = user.getUsermail();
        int index = umail.indexOf("@");
        String host = umail.substring(++index);

        // 创建Properties 对象
        Properties props = System.getProperties();

        // 创建邮件会话
        Session session = Session.getDefaultInstance(props, null);

        //打开调试
        session.setDebug(true);

        try {
            // 获取邮箱的pop3存储
            Store store = session.getStore("pop3");
            store.connect(host, username, password);

            // 获取inbox文件
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);  //打开，打开后才能读取邮件信息

            // 获取邮件消息
            Message message[] = folder.getMessages();

            for (int i = 0; i < message.length; i++) {

                Mail mail = new Mail();
                praseMessage.setMimeMessage((MimeMessage) message[i]);

                mail.setMailid(praseMessage.getMessageId());
                mail.setSender(praseMessage.getFrom());
                mail.setRecipient(praseMessage.getMailAddress("TO"));
                String subject = praseMessage.getSubject();
//                if (subject.contains("?B?")){
//                    subject = mailDecode(subject);
//                }
                mail.setSubject(subject);
                mail.setSendtime(message[i].getSentDate());

                praseMessage.getMailContent((Part) message[i]); // 根据内容的不同解析邮件
                praseMessage.setAttachPath("D:\\tmp\\mail"); //设置邮件附件的保存路径
                praseMessage.saveAttachMent((Part)message[i]); //保存附件

                String content = praseMessage.getBodyText();

//                if (content.contains("?B?")){
//                    content = mailDecode(content);
//                }
//                mail.setContent(content);

//                System.err.println("公钥加密——私钥解密");
//                String source = mail.getContent();
//                System.out.println("\r加密前文字：\r\n" + source);
//                System.err.println(rsakey.getPublickey());
//                System.err.println(rsakey.getPrivatekey());
//                byte[] data = source.getBytes();
//                byte[] encodedData = RSAUtils.encryptByPublicKey(data, rsakey.getPublickey());
//                System.out.println("加密后文字：\r\n" + new String(encodedData));

//                Rsakey rsakey = new Rsakey();
//                rsakey = rsaUtils.getRsakey();
//                byte[] decodedData = RSAUtils.decryptByPrivateKey(content.getBytes(), rsakey.getPrivatekey());
//                String target = new String(decodedData);
//                System.out.println("解密后文字: \r\n" + target);
//                mail.setContent(target);

                Rsakey rsakey = new Rsakey();
                rsakey = rsaUtils.getRsakey();

                System.err.println("公钥加密——私钥解密");
                System.out.println("\r解密前文字：\r\n" + content);
                System.err.println(rsakey.getPublickey());
                System.err.println(rsakey.getPrivatekey());

                String[] strArr = content.split(" ");
                int len = strArr.length;
                if (len > 128){
                    len = 128;
                }
                byte[] clone = new byte[len];
                for (int j = 0; j < len; j++) {
                    clone[j] = Byte.parseByte(strArr[j]);
                }

                System.out.println("转换为String，然后再次返回到字节: " + rsaTest.bytesToString(clone));
                byte[] d = rsaTest.decrypt(rsakey.getPrivatekey(), clone);
                System.out.println("解密String的字节，使用bytesToString()方法将字节转换为字符串:" + rsaTest.bytesToString(d));
                System.out.println("通过解密字符串的字节构造一个字符串: " + new String(d));

                mail.setContent(new String(d));

                mails.add(mail);
            }

            // 关闭资源
            folder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return mails;
    }

    //邮件主题中文字符转换
    public String transferChinese(String strText){
        try{
            byte [] b = strText.getBytes();
            strText = MimeUtility.encodeText(new String(b, "GBK"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return strText;
    }

    //邮件解码
    public String mailDecode(String content) throws Exception {

        content = base64Util.encode(content.getBytes());
        byte[] b = base64Util.decode(content);
        content = new String(b, "GBK");
        int index = content.indexOf("?B?");
        if (index > -1){
            content = content.substring(index + 3);
            index = content.indexOf("?=");
            content = content.substring(0, index);
            b = base64Util.decode(content);
            content = new String(b, "GBK");

            return content;
        }else {
            return content;
        }

    }
}
