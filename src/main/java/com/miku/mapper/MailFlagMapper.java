package com.miku.mapper;

import com.miku.po.MailFlag;
import com.miku.po.MailFlagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface MailFlagMapper {
    int countByExample(MailFlagExample example);

    int deleteByExample(MailFlagExample example);

    int deleteByPrimaryKey(String messageName);

    int insert(MailFlag record);

    int insertSelective(MailFlag record);

    List<MailFlag> selectByExample(MailFlagExample example);

    MailFlag selectByPrimaryKey(String messageName);

    int updateByExampleSelective(@Param("record") MailFlag record, @Param("example") MailFlagExample example);

    int updateByExample(@Param("record") MailFlag record, @Param("example") MailFlagExample example);

    int updateByPrimaryKeySelective(MailFlag record);

    int updateByPrimaryKey(MailFlag record);
}