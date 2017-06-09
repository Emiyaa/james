package com.miku.util;

import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeUtility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class DigestUtil {

    public String digestString(String pass, String algorithm )
            throws NoSuchAlgorithmException  {

        MessageDigest md;
        ByteArrayOutputStream bos;

        try {
            md = MessageDigest.getInstance(algorithm);
            byte[] digest = md.digest(pass.getBytes("iso-8859-1"));
            bos = new ByteArrayOutputStream();
            OutputStream encodedStream = MimeUtility.encode(bos, "base64");
            encodedStream.write(digest);
            return bos.toString("iso-8859-1");
        } catch (IOException ioe) {
            throw new RuntimeException("Fatal error: " + ioe);
        } catch (MessagingException me) {
            throw new RuntimeException("Fatal error: " + me);
        }
    }

    //邮件主题中文字符转换
    public String transferChinese(String strText){
        try{
            strText = MimeUtility.encodeText(new String(strText.getBytes(), "utf-8"));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return strText;
    }

}
