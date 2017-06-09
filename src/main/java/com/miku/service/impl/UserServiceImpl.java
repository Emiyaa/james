package com.miku.service.impl;

import com.miku.dao.UserMapperCustom;
import com.miku.exception.CustomException;
import com.miku.mapper.UserMapper;
import com.miku.mapper.UsersMapper;
import com.miku.po.User;
import com.miku.po.Users;
import com.miku.service.UserService;
import com.miku.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with com.miku.service.impl
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/8 0008
 * Time :       19:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DigestUtil digestUtil;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Override
    public int verify(String username, String password) throws Exception{
        int flag = 0;
        String pwh = null;
        try {
            pwh = usersMapper.selectByPrimaryKey(username).getPwdhash();
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("用户名错误！");

        }

        String pwd = digestUtil.digestString(password , "SHA");
        if (pwh == "" || pwh == null){
            flag = -1;
        }else if (pwh.equals(pwd)){
            flag = 1;
        }
        return flag;
    }

    @Override
    public User selectByUsername(String username) {
        return userMapperCustom.selectByUsername(username);
    }

    @Override
    public boolean regist(User user, String password) throws Exception{
        int index = user.getUsermail().indexOf("@");
        String username = user.getUsermail().substring(0, index);
        user.setUsername(username);
        String pwh = digestUtil.digestString(password , "SHA");
        Users users = new Users();
        users.setUsername(user.getUsername());
        users.setPwdhash(pwh);
        users.setPwdalgorithm("SHA");
        boolean i = usersMapper.insert(users) == 0 ? false : true;
        boolean j = userMapper.insert(user) == 0 ? false : true;
        return i && j;
    }

    //根据用户名更新用户信息
    @Override
    public boolean update(User user) throws Exception {
        int i = userMapper.updateByPrimaryKey(user);
        if (i > 0){
            return true;
        }else {
            return false;
        }
    }
}
