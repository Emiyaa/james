package com.miku.controller;

import com.miku.exception.CustomException;
import com.miku.po.User;
import com.miku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created with com.miku.controller
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/12 0012
 * Time :       17:42
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("/login.do")
    public String login(HttpSession session, String username,
                        String password) throws Exception {
        //调用service方法进行登录验证
        int flag = userService.verify(username, password);
        if (flag < 0) {
            String message = "用户名错误！";
//            throw new CustomException(message);
            session.setAttribute("message", message);
            return "login";
        } else if (flag == 0) {
            String message = "密码错误！";
            session.setAttribute("message", message);
            return "login";
        } else {
            //获取用户信息
            User user = userService.selectByUsername(username);
            session.setAttribute("pwd", password);
            session.setAttribute("user", user);
            //重定向到邮箱首页
            return "user";
        }

    }

    //登录
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面
        return "login";
    }

    //跳转到注册
    @RequestMapping("/regist.do")
    public String regist() {
        //跳转到注册页面
        return "regist";
    }

    //跳转到忘记密码页面
    @RequestMapping("/forgot.do")
    public String forgot() {
        //跳转到注册页面
        return "forgot";
    }

    //跳转到注册
    @RequestMapping("/registTo.do")
    public ModelAndView registTo(User user, String password,
                                 ModelAndView mv) throws Exception {

        //调用service方法进行注册
        if (userService.regist(user, password)) {
            mv.addObject("reg_message", "注册成功！");
            //重定向到登录页面
            mv.setViewName("login");
            return mv;
        } else {
            mv.addObject("reg_message", "注册失败！");
            //重定向到注册页面
            mv.setViewName("registTo.do");
            return mv;
        }
    }

    //跳转到注册
    @RequestMapping("/update.do")
    public ModelAndView update(User user,
                                 ModelAndView mv) throws Exception {

        //调用service方法进行注册
        if (userService.update(user)) {
            mv.addObject("message", "更新成功！");
            //重定向到用户信息页面
            mv.setViewName("user");
            return mv;
        } else {
            mv.addObject("message", "更新失败！");
            //重定向到用户信息页面
            mv.setViewName("user");
            return mv;
        }
    }

    //校验用户
/*
    @RequestMapping("/volida.do")
    public void volida(HttpSession session){
        session.setAttribute("message" , "用户名重复！");
    }
*/

}
