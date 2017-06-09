package com.miku.mapper;

import com.miku.po.Rsakey;
import com.miku.po.RsakeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RsakeyMapper {
    int countByExample(RsakeyExample example);

    int deleteByExample(RsakeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rsakey record);

    int insertSelective(Rsakey record);

    List<Rsakey> selectByExampleWithBLOBs(RsakeyExample example);

    List<Rsakey> selectByExample(RsakeyExample example);

    Rsakey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rsakey record, @Param("example") RsakeyExample example);

    int updateByExampleWithBLOBs(@Param("record") Rsakey record, @Param("example") RsakeyExample example);

    int updateByExample(@Param("record") Rsakey record, @Param("example") RsakeyExample example);

    int updateByPrimaryKeySelective(Rsakey record);

    int updateByPrimaryKeyWithBLOBs(Rsakey record);
}