package com.cql.mapper;

import com.cql.entity.BigType;

import java.util.List;

public interface BigTypeMapper {
    List<BigType> getBigTypes(BigType bigType);
    Integer addBigType(BigType bigType);
    Integer setBigType(BigType bigType);
    Integer delBigType(BigType bigType);
}
