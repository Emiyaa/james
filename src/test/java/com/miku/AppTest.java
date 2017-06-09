package com.miku;

import com.miku.mapper.UsersMapper;
import com.miku.po.User;
import com.miku.po.Users;
import com.miku.service.impl.UserServiceImpl;
import com.miku.service.UserService;
import com.miku.util.Base64Util;
import com.miku.util.DigestUtil;
//import com.miku.util.ECCCoder;
import com.miku.util.PraseMessage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    private ApplicationContext ac;

    @Before
    public void setUp(){
        String cfg = "spring/applicationContext.xml";
        ac = new ClassPathXmlApplicationContext(cfg);
    }


    public void testFindById(){
        UsersMapper usersMapper = ac.getBean(UsersMapper.class);
        Users users = usersMapper.selectByPrimaryKey("admin");
        System.out.println(users.getUsername() + "\t"
                + users.getPwdhash());
    }

    public void test1() throws Exception{
        DigestUtil digestUtil = ac.getBean(DigestUtil.class);
        String s = digestUtil.digestString("test", "SHA");
        System.out.println(s);

    }

    public void test2(){
        String name="sdfsdf@34.com";
        int index=name.indexOf("@");
        String str=name.substring(0 , index);
        System.out.print(str);
    }


    public void testRegist() throws Exception{
        UserService userService = ac.getBean(UserServiceImpl.class);
        User user = new User();
        user.setUsername("james");
        System.out.println(userService.regist(user, "james"));
    }


    /**
     * 　*　PraseMimeMessage类测试 　
     *
     * @throws Exception
     */
    public void testRecipientMail() throws Exception {
        String host = "james.com";
        String username = "admin";//邮箱地址
        String password = "admin";//邮箱密码
        Properties props = System.getProperties();
        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("pop3");
        store.connect(host, username, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        Message message[] = folder.getMessages();
        PraseMessage pmm = ac.getBean(PraseMessage.class);
        Base64Util base64Util = ac.getBean(Base64Util.class);
        for (int i = 1; i < message.length; i++) {
            System.out.println("****************************************第"
                    + (i + 1) + "封邮件**********************************");

            pmm.setMimeMessage((MimeMessage) message[i]);
            System.out.println("主题 :" + pmm.getSubject());
            pmm.setDateFormat("yy年MM月dd日 HH:mm");
            System.out.println("发送时间 :" + pmm.getSendDate());
            System.out.println("是否回执 :" + pmm.getReplySign());
            // System.out.println("是否包含附件 :"+pmm.isContainAttach((Part)message[i]));
            System.out.println("发件人 :" + pmm.getFrom());
            System.out.println("收件人 :" + pmm.getMailAddress("TO"));
            System.out.println("抄送地址 :" + pmm.getMailAddress("CC"));
            System.out.println("密送地址 :" + pmm.getMailAddress("BCC"));
            System.out.println("邮件ID :" + i + ":" + pmm.getMessageId());

            pmm.getMailContent((Part) message[i]); // 根据内容的不同解析邮件

            String s = base64Util.encode(pmm.getBodyText().getBytes());
            byte [] b = base64Util.decode(s);
            String content = new String(b , "utf-8").toString();
            int index = content.indexOf("?B?");
            content = content.substring(index + 3);
            index = content.indexOf("?=");
            content = content.substring(0 , index);
            b = base64Util.decode(content);
            content = new String(b , "utf-8").toString();
//            content = base64Util.encode(content.getBytes());
            System.out.println("邮件正文 :" + content);

            // pmm.setAttachPath("c:/tmp/mail"); //设置邮件附件的保存路径
            // pmm.saveAttachMent((Part)message[i]); //保存附件
            System.out.println("邮件正文 :" + pmm.getBodyText());
            System.out.println("*********************************第" + (i + 1)
                    + "封邮件结束*************************************");
        }
    }

    public void testBase64(){
        String s = "admin";
        s = Base64Util.encode(s.getBytes());
        System.out.println(s);

        System.out.println(Base64Util.decode(Base64Util.encode(s.getBytes())).toString());
    }

//    public void testECCoder() throws Exception{
//        String inputStr = "admin";
//        byte[] data = inputStr.getBytes();
//        Map<String, Object> keyMap = ECCCoder.initKey();
//        String publicKey = ECCCoder.getPublicKey(keyMap);
//        String privateKey = ECCCoder.getPrivateKey(keyMap);
//        System.err.println("公钥: \n" + publicKey);
//        System.err.println("私钥： \n" + privateKey);
//        byte[] encodedData = ECCCoder.encrypt(data, publicKey);
//        String s = new String(encodedData);
//        System.out.println(s);
//        byte[] decodedData = ECCCoder.decrypt(encodedData, privateKey);
//        s = new String(decodedData);
//        System.out.println(s);
//        String outputStr = new String(decodedData);
//        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
//
//    }

}