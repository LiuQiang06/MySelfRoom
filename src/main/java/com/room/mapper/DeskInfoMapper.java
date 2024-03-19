package com.room.mapper;

import com.room.pojo.DeskInfo;
import com.room.pojo.DeskInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeskInfoMapper {
    long countByExample(DeskInfoExample example);

    int deleteByExample(DeskInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeskInfo record);

    int insertSelective(DeskInfo record);

    List<DeskInfo> selectByExample(DeskInfoExample example);

    DeskInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    DeskInfo record, @Param("example")
    DeskInfoExample example);

    int updateByExample(@Param("record")
    DeskInfo record, @Param("example")
    DeskInfoExample example);

    int updateByPrimaryKeySelective(DeskInfo record);

    int updateByPrimaryKey(DeskInfo record);
}

