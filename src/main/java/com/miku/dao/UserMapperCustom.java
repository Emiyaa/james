package com.miku.dao;

import com.miku.po.User;
import org.springframework.stereotype.Repository;

/**
 * Created with com.miku.dao
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/8 0008
 * Time :       11:41
 */
@Repository
public interface UserMapperCustom {

    //根据用户名查找
    User selectByUsername(String username);
}
