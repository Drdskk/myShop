package com.cql.mapper;

import com.cql.entity.SmallType;

import java.util.List;

public interface SmallTypeMapper {
    List<SmallType> getSmallTypes(SmallType smallType);
    Integer addSmallType(SmallType smallType);
    Integer setSmallType(SmallType smallType);
    Integer delSmallType(SmallType smallType);
}
