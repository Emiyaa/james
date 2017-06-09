package com.miku.service.impl;

import com.miku.dao.InboxMapperCustom;
import com.miku.dao.MailMapperCustom;
import com.miku.mapper.InboxMapper;
import com.miku.mapper.MailMapper;
import com.miku.po.Inbox;
import com.miku.po.InboxWithBLOBs;
import com.miku.po.Mail;
import com.miku.po.User;
import com.miku.service.MailService;
import com.miku.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with com.miku.service.impl
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/9 0009
 * Time :       18:18
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailMapper mailMapper;

    @Autowired
    private MailMapperCustom mailMapperCustom;

    @Autowired
    private InboxMapperCustom inboxMapperCustom;

    @Autowired
    private MailUtil mailUtil;

    //发送邮件
    @Override
    public boolean sendMail(Mail mail, HttpSession httpSession) throws Exception{

        //调用sendMail发送邮件
        boolean sendFlag = mailUtil.sendMail(mail , httpSession);

        return sendFlag;

    }

    //接收邮件
    @Override
    public List<Mail> recipientMail(HttpSession httpSession) throws Exception{

        List<Mail> mails = new ArrayList<>();
        List<Mail> mailList = new ArrayList<>();
        //获取用户名和密码
        User user = (User) httpSession.getAttribute("user");

        //调用recipientMail接受邮件
        mails = mailUtil.recipientMail(httpSession);

        for (Mail mail : mails){
            if (mail.getRecipient().equals(user.getUsermail())){
                mailList.add(mail);
            }
        }

        return mailList;
    }

    //已发送邮件
    @Override
    public List<Mail> sentMail(HttpSession httpSession) throws Exception{
        //获取用户名和密码
        User user = (User) httpSession.getAttribute("user");

        List<Mail> mails = new ArrayList<>();
        List<Mail> mailList = new ArrayList<>();
        List<InboxWithBLOBs> inboxs = new ArrayList<>();
        //调用recipientMail接受邮件
        mails = mailUtil.recipientMail(httpSession);

        for (Mail mail : mails){
            if (mail.getSender().equals(user.getUsermail())){
                mailList.add(mail);
            }
        }
//        inboxs = mailMapperCustom.sentMail(user.getUsermail());
//
//        for (InboxWithBLOBs inbox : inboxs){
//            Mail mail = new Mail();
//            if (inbox.getSender().equals(user.getUsermail())){
//                mail.setMailid(inbox.getMessageName());
//                mail.setSender(inbox.getSender());
//                mail.setRecipient(inbox.getRecipients());
//                mail.setSendtime(inbox.getLastUpdated());
//                mailList.add(mail);
//            }
//        }

        return mailList;
    }

    //查看草稿箱邮件
    @Override
    public List<Mail> draftMail(HttpSession httpSession) throws Exception{
        //获取用户名和密码
        User user = (User) httpSession.getAttribute("user");

        List<Mail> mails = new ArrayList<>();
        List<Mail> mailList = new ArrayList<>();
        List<InboxWithBLOBs> inboxs = new ArrayList<>();
        //调用recipientMail接受邮件
        mails = mailUtil.recipientMail(httpSession);

        inboxs = mailMapperCustom.draftMail();

        for (Mail mail : mails){
            for (InboxWithBLOBs inbox : inboxs){
                if (mail.getMailid().equals(inbox.getMessageName())){
                    mailList.add(mail);
                }
            }
        }
        return mailList;
    }

    //已删除邮件
    @Override
    public List<Mail> deleteMail(HttpSession httpSession) throws Exception {
        //获取用户名和密码
        User user = (User) httpSession.getAttribute("user");

        List<Mail> mails = new ArrayList<>();
        List<Mail> mailList = new ArrayList<>();
        List<InboxWithBLOBs> inboxs = new ArrayList<>();
        //调用recipientMail接受邮件
        mails = mailUtil.recipientMail(httpSession);

        inboxs = mailMapperCustom.deleteMail();

        for (Mail mail : mails){
            for (InboxWithBLOBs inbox : inboxs){
                if (mail.getMailid().equals(inbox.getMessageName())){
                    mailList.add(mail);
                }
            }
        }
        return mailList;
    }



    @Override
    public boolean inboxSend(Mail mail, HttpSession httpSession) throws Exception {
        return false;
    }

    @Override
    public List<Inbox> inboxRecipient(HttpSession httpSession) throws Exception {
        return null;
    }

    @Override
    public List<Inbox> inboxDraft(HttpSession httpSession) throws Exception {
        return null;
    }

    @Override
    public List<Inbox> inboxSent(HttpSession httpSession) throws Exception {
        return null;
    }

    @Override
    public List<Inbox> inboxDelete(HttpSession httpSession) throws Exception {
        return null;
    }
}
