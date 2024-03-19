package com.room.mapper;

import java.util.List;
import java.util.Map;


public interface AdhocStudyGatherMapper {
    /**
      学习时间统计
    */
    public List<Map<String, Object>> studyGather(Map<String, Object> params); //学习时间统计
}

