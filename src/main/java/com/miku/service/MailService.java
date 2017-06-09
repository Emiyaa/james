package com.miku.service;

import com.miku.po.Inbox;
import com.miku.po.Mail;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with com.miku.service
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/9 0009
 * Time :       18:16
 */
public interface MailService {


    //发送邮件
    public boolean sendMail(Mail mail, HttpSession httpSession) throws Exception;

    //接收邮件
    public List<Mail> recipientMail(HttpSession httpSession) throws Exception;

    //已发送邮件
    public List<Mail> sentMail(HttpSession httpSession) throws Exception;

    //查看草稿箱邮件
    public List<Mail> draftMail(HttpSession httpSession) throws Exception;

    //已删除邮件
    public List<Mail> deleteMail(HttpSession httpSession) throws Exception;



    //发送邮件
    public boolean inboxSend(Mail mail, HttpSession httpSession) throws Exception;

    //接收邮件
    public List<Inbox> inboxRecipient(HttpSession httpSession) throws Exception;

    //查看草稿箱邮件
    public List<Inbox> inboxDraft(HttpSession httpSession) throws Exception;

    //已发送邮件
    public List<Inbox> inboxSent(HttpSession httpSession) throws Exception;

    //已删除邮件
    public List<Inbox> inboxDelete(HttpSession httpSession) throws Exception;

}
