package com.miku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created with com.miku.controller
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/12 0012
 * Time :       18:05
 */
@Controller
public class PageController {

    //
    @RequestMapping("/toUser.do")
    public String user(){

        return "user";
    }

    //
    @RequestMapping("/toWrite.do")
    public String write(){

        return "write";
    }

    //
    @RequestMapping("/toReceive.do")
    public String receive(){

        return "receive";
    }

    //
    @RequestMapping("/toDraft.do")
    public String draft(){

        return "draft";
    }

    //
    @RequestMapping("/toSend.do")
    public String send(){

        return "send";
    }

    //
    @RequestMapping("/toDelete.do")
    public String delete(){

        return "delete";
    }

    //
    @RequestMapping("/toRubbish.do")
    public String rubbish(){

        return "rubbish";
    }

}
