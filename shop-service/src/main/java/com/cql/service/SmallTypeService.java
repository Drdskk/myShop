package com.cql.service;

import com.cql.entity.BigType;
import com.cql.entity.SmallType;

import java.util.List;

public interface SmallTypeService {
    List<SmallType> getSmallTypes(SmallType smallType);
    Integer addSmallType(SmallType smallType);
    Integer delSmallType(SmallType smallType);
}
