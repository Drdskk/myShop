package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.BigType;

import java.util.List;

public interface BigTypeMapper extends BaseMapper<BigType> {
    List<BigType> getBigTypes(BigType bigType);
//    Integer addBigType(BigType bigType);
//    Integer setBigType(BigType bigType);
//    Integer delBigType(BigType bigType);
}
