package com.miku.interceptor;

import com.miku.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with com.miku.interceptor
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2016/12/12 0012
 * Time :       17:40
 */
//登录校验
public class LoginInterceptor
        implements HandlerInterceptor {

    //进入Handler方法之前执行
    //用于身份验证等
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否是公开地址，公开地址配置在配置文件中
        //公开地址是登录提交的地址
        String s1 = "login";
        String s2 = "regist";
        String s3 = "forgot";
        if (url.contains(s1) || url.contains(s2) || url.contains(s3)) {
            //是登录就放行
            return true;
        }
        //判断session中的username
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user.getUsername() != null) {
            return true;
        }
        //此时说明用户没有登录，跳转到登录页面
        request.getRequestDispatcher
                ("/WEB-INF/dynamic/login.jsp").forward
                (request, response);
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
