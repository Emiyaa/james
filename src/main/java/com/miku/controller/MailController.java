package com.miku.controller;

import com.miku.po.Inbox;
import com.miku.po.Mail;
import com.miku.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with com.miku.controller
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/7 0007
 * Time :       11:37
 */
@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    //发送邮件
    @RequestMapping("/write.do")
    public String write(Mail mail, HttpSession session , Model model) throws Exception {

        //调用service方法进行发送邮件
        if (mailService.sendMail(mail, session)) {
            model.addAttribute("message", "邮件发送成功！在写一封吧！");

        } else {
            model.addAttribute("message", "邮件发送失败！重写一封吧！");
        }
        return "/write";
    }

    //接收邮件
    @RequestMapping("/receive.do")
    public String receive(HttpSession session) throws Exception {

        List<Mail> mails = new ArrayList<>();
        //调用service方法进行接收邮件
        mails = mailService.recipientMail(session);

        session.setAttribute("mails", null);
        session.setAttribute("mails", mails);
//        mv.setViewName("receive");

        return "receive";
    }

    //查看邮件正文
    @RequestMapping("/receiveTo.do")
    public String receiveTo(HttpSession session , String mailId) throws Exception {

        List<Mail> mails = new ArrayList<>();
        mails = (List<Mail>)session.getAttribute("mails");
        for (Mail mail : mails){
            if (mail.getMailid().equals(mailId)){
                session.setAttribute("mail", mail);
            }
        }

        return "receiveTo";
    }

    //查看草稿箱邮件
    @RequestMapping("/draft.do")
    public String draft(HttpSession session) throws Exception {

        List<Mail> mails = new ArrayList<>();
        //调用service方法查看发件箱邮件
        mails = mailService.draftMail(session);

        session.setAttribute("mails" , null);
        session.removeAttribute("mails");
        session.setAttribute("mails", mails);
//        mv.setViewName("receive");

        return "draft";
    }

    //查看发件箱邮件
    @RequestMapping("/send.do")
    public String send(HttpSession session) throws Exception {

        List<Mail> mails = new ArrayList<>();
        //调用service方法查看发件箱邮件
        mails = mailService.sentMail(session);

        session.setAttribute("mails" , null);
        session.removeAttribute("mails");
        session.setAttribute("mails", mails);
//        mv.setViewName("receive");

        return "send";
    }

    //查看已删除邮件
    @RequestMapping("/delete.do")
    public String delete(HttpSession session) throws Exception {

        List<Mail> mails = new ArrayList<>();
        //调用service方法查看发件箱邮件
        mails = mailService.deleteMail(session);

        session.setAttribute("mails" , null);
        session.removeAttribute("mails");
        session.setAttribute("mails", mails);
//        mv.setViewName("receive");

        return "delete";
    }

}
