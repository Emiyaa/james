package com.miku.util;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created with com.miku.test
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/12 0012
 * Time :       11:06
 */
@Component
public class PraseMessage {
    private MimeMessage mimeMessage = null;
    private String saveAttachPath = "";// 附件下载后的存放目录
    private StringBuffer bodytext = new StringBuffer();
    // 存放邮件内容的StringBuffer对象
    private String dateformat = "yy-MM-dd　HH:mm";// 默认的日前显示格式

    /**
     * 　*　构造函数,初始化一个MimeMessage对象 　
     */

    public MimeMessage getMimeMessage() {
        return mimeMessage;
    }

    public void setMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }

    /**
     * 　*　获得发件人的地址和姓名 　
     */
    public String getFrom() throws Exception {
        InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
        String from = address[0].getAddress();
        if (from == null) {
            from = "";
        }
        String personal = address[0].getPersonal();
        if (personal == null) {
            personal = "";
        }
        String fromaddr = personal + from;
        return fromaddr;
    }

    /**
     * 　*　获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同
     * 　*　"to"----收件人　"cc"---抄送人地址　"bcc"---密送人地址 　
     *
     * @throws Exception
     */
    public String getMailAddress(String type) {
        String mailaddr = "";
        try {
            String addtype = type.toUpperCase();
            InternetAddress[] address = null;
            if (addtype.equals("TO") || addtype.equals("CC")
                    || addtype.equals("BBC")) {
                if (addtype.equals("TO")) {
                    address = (InternetAddress[]) mimeMessage
                            .getRecipients(Message.RecipientType.TO);
                } else if (addtype.equals("CC")) {
                    address = (InternetAddress[]) mimeMessage
                            .getRecipients(Message.RecipientType.CC);
                } else {
                    address = (InternetAddress[]) mimeMessage
                            .getRecipients(Message.RecipientType.BCC);
                }
                if (address != null) {
                    for (int i = 0; i < address.length; i++) {
                        String email = address[i].getAddress();
                        if (email == null)
                            email = "";
                        else {
                            email = MimeUtility.decodeText(email);
                        }
                        String personal = address[i].getPersonal();
                        if (personal == null)
                            personal = "";
                        else {
                            personal = MimeUtility.decodeText(personal);
                        }
                        String compositeto = personal + email;
                        mailaddr += "," + compositeto;
                    }
                    mailaddr = mailaddr.substring(1);
                }
            } else {
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return mailaddr;
    }

    /**
     * 　　*　获得邮件主题 　　
     */
    public String getSubject() {
        String subject = "";
        try {
            subject = MimeUtility.decodeText(mimeMessage.getSubject());
            if (subject == null)
                subject = "";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return subject;
    }

    /**
     * 　　*　获得邮件发送日期 　　
     */
    public String getSendDate() throws Exception {
        Date senddate = mimeMessage.getSentDate();
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        return format.format(senddate);
    }

    /**
     * 　　*　解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件
     * 　　*　主要是根据MimeType类型的不同执行不同的操作，一步一步的解析 　　
     */
    public void getMailContent(Part part) throws Exception {
        bodytext.setLength(0);
        String contenttype = part.getContentType();
        int nameindex = contenttype.indexOf("name");
        boolean conname = false;
        if (nameindex != -1)
            conname = true;
        if (part.isMimeType("text/plain") && !conname) {
            bodytext.append((String) part.getContent());
        } else if (part.isMimeType("text/html") && !conname) {
            bodytext.append((String) part.getContent());
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int counts = multipart.getCount();
            for (int i = 0; i < counts; i++) {
                getMailContent(multipart.getBodyPart(i));
            }
        } else if (part.isMimeType("message/rfc822")) {
            getMailContent((Part) part.getContent());
        }
    }

    /**
     * 　*　获得邮件正文内容 　　
     */
    public String getBodyText() {
        return bodytext.toString();
    }

    /**
     * 　　*　判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false" 　　
     *
     * @throws javax.mail.MessagingException
     */
    public boolean getReplySign() throws MessagingException {
        boolean replysign = false;
        String needreply[] = mimeMessage
                .getHeader("Disposition-Notification-To");
        if (needreply != null) {
            replysign = true;
        }
        return replysign;
    }

    /**
     * 　*　获得此邮件的Message-ID 　　
     *
     * @throws javax.mail.MessagingException
     */
    public String getMessageId() throws MessagingException {
        return mimeMessage.getMessageID();
    }

    /**
     * 　*　【判断此邮件是否已读，如果未读返回返回false,反之返回true】 　　
     *
     * @throws javax.mail.MessagingException
     */
    public boolean isNew() throws MessagingException {
        boolean isnew = false;
        Flags flags = ((Message) mimeMessage).getFlags();
        Flags.Flag[] flag = flags.getSystemFlags();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == Flags.Flag.SEEN) {
                isnew = true;
                break;
            }
        }
        return isnew;
    }

    /**
     * 　*　判断此邮件是否包含附件 　
     *
     * @throws javax.mail.MessagingException
     */
    public boolean isContainAttach(Part part) throws Exception {
        boolean attachflag = false;
        String contentType = part.getContentType();
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            // 获取附件名称可能包含多个附件
            for (int j = 0; j < mp.getCount(); j++) {
                BodyPart mpart = mp.getBodyPart(j);
                String disposition = mpart.getDescription();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
                        .equals(Part.INLINE)))) {
                    attachflag = true;
                } else if (mpart.isMimeType("multipart/*")) {
                    attachflag = isContainAttach((Part) mpart);
                } else {
                    String contype = mpart.getContentType();
                    if (contype.toLowerCase().indexOf("application") != -1)
                        attachflag = true;
                    if (contype.toLowerCase().indexOf("name") != -1)
                        attachflag = true;
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            attachflag = isContainAttach((Part) part.getContent());
        }
        return attachflag;
    }

    /**
     * 　*　【保存附件】 　
     *
     * @throws Exception
     * @throws java.io.IOException
     * @throws javax.mail.MessagingException
     * @throws Exception
     */
    public void saveAttachMent(Part part) throws Exception {
        String fileName = "";
        if (part.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) part.getContent();
            for (int j = 0; j < mp.getCount(); j++) {
                BodyPart mpart = mp.getBodyPart(j);
                String disposition = mpart.getDescription();
                if ((disposition != null)
                        && ((disposition.equals(Part.ATTACHMENT)) || (disposition
                        .equals(Part.INLINE)))) {
                    fileName = mpart.getFileName();
                    if (fileName.toLowerCase().indexOf("GBK") != -1) {
                        fileName = MimeUtility.decodeText(fileName);
                    }
                    saveFile(fileName, mpart.getInputStream());
                } else if (mpart.isMimeType("multipart/*")) {
                    fileName = mpart.getFileName();
                } else {
                    fileName = mpart.getFileName();
                    if ((fileName != null)) {
                        fileName = MimeUtility.decodeText(fileName);
                        saveFile(fileName, mpart.getInputStream());
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachMent((Part) part.getContent());
        }
    }

    /**
     * 　*　【设置附件存放路径】 　
     */
    public void setAttachPath(String attachpath) {
        this.saveAttachPath = attachpath;
    }

    /**
     * 　*　【设置日期显示格式】 　
     */
    public void setDateFormat(String format) {
        this.dateformat = format;
    }

    /**
     * 　*　【获得附件存放路径】 　
     */

    public String getAttachPath() {
        return saveAttachPath;
    }

    /**
     * 　*　【真正的保存附件到指定目录里】 　
     */
    private void saveFile(String fileName, InputStream in) throws Exception {
        String osName = System.getProperty("os.name");
        String storedir = getAttachPath();
        String separator = "";
        if (osName == null)
            osName = "";
        if (osName.toLowerCase().indexOf("win") != -1) {
            // 如果是window 操作系统
            separator = "/";
            if (storedir == null || storedir.equals(""))
                storedir = "D:\\com\\james\\apps\\james\\var\\mail\\inboxes\\tmp";
        } else {
            // 如果是其他的系统
            separator = "/";
            storedir = "/com/james/apps/james/var/mail/inboxes/tmp";
        }
        File strorefile = new File(storedir + separator + fileName);
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(strorefile));
            bis = new BufferedInputStream(in);
            int c;
            while ((c = bis.read()) != -1) {
                bos.write(c);
                bos.flush();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            bos.close();
            bis.close();
        }
    }

}