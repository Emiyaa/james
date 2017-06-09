package com.miku.service;

import com.miku.po.User;

/**
 * Created with com.miku.service
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/8 0008
 * Time :       19:43
 */
public interface UserService {

    //密码验证
    public int verify(String username , String password) throws Exception;

    //根据用户名查找用户信息
    public User selectByUsername(String username);

    //根据用户名查找用户信息
    public boolean regist(User user , String password) throws Exception;

    //根据用户名更新用户信息
    public boolean update(User user) throws Exception;
}
