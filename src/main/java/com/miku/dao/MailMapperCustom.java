package com.miku.dao;

import com.miku.po.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with com.miku.dao
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/11 0011
 * Time :       11:07
 */
@Repository
public interface MailMapperCustom {

    //根据接收人查找邮件
//    public List<Mail> recipientMail(String usermail);

    //根据发件人查找邮件
    public List<InboxWithBLOBs> sentMail(String usermail);

    //根据草稿标记查找邮件
    public List<InboxWithBLOBs> draftMail();

    //根据删除标记查找邮件
    public List<InboxWithBLOBs> deleteMail();

    public Rsakey selectKey();
}
