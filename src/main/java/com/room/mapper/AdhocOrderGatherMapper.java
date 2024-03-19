package com.room.mapper;

import java.util.List;
import java.util.Map;


public interface AdhocOrderGatherMapper {
    /**
      订单统计
    */
    public List<Map<String, Object>> orderGather(Map<String, Object> params); //订单统计
}

