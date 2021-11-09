package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.SmallType;

import java.util.List;

public interface SmallTypeMapper extends BaseMapper<SmallType> {
    List<SmallType> getSmallTypes(SmallType smallType);
//    Integer addSmallType(SmallType smallType);
//    Integer setSmallType(SmallType smallType);
//    Integer delSmallType(SmallType smallType);
}
