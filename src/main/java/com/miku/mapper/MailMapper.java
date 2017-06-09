package com.miku.mapper;

import com.miku.po.Mail;
import com.miku.po.MailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MailMapper {
    int countByExample(MailExample example);

    int deleteByExample(MailExample example);

    int deleteByPrimaryKey(String mailid);

    int insert(Mail record);

    int insertSelective(Mail record);

    List<Mail> selectByExample(MailExample example);

    Mail selectByPrimaryKey(String mailid);

    int updateByExampleSelective(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByExample(@Param("record") Mail record, @Param("example") MailExample example);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKey(Mail record);
}