package com.miku.mapper;

import com.miku.po.Inbox;
import com.miku.po.InboxExample;
import com.miku.po.InboxKey;
import com.miku.po.InboxWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface InboxMapper {
    int countByExample(InboxExample example);

    int deleteByExample(InboxExample example);

    int deleteByPrimaryKey(InboxKey key);

    int insert(InboxWithBLOBs record);

    int insertSelective(InboxWithBLOBs record);

    List<InboxWithBLOBs> selectByExampleWithBLOBs(InboxExample example);

    List<Inbox> selectByExample(InboxExample example);

    InboxWithBLOBs selectByPrimaryKey(InboxKey key);

    int updateByExampleSelective(@Param("record") InboxWithBLOBs record, @Param("example") InboxExample example);

    int updateByExampleWithBLOBs(@Param("record") InboxWithBLOBs record, @Param("example") InboxExample example);

    int updateByExample(@Param("record") Inbox record, @Param("example") InboxExample example);

    int updateByPrimaryKeySelective(InboxWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(InboxWithBLOBs record);

    int updateByPrimaryKey(Inbox record);
}