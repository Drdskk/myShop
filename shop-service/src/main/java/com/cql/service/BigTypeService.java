package com.cql.service;

import com.cql.entity.BigType;

import java.util.List;

public interface BigTypeService {
    List<BigType> getBigTypes(BigType bigType);
    Integer addBigType(BigType bigType);
    Integer delBigType(BigType bigType);
}
