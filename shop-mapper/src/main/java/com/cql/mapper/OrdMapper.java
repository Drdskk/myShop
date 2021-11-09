package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.Ord;

import java.util.List;

public interface OrdMapper extends BaseMapper<Ord> {
    List<Ord> getOrds(Ord ord);
//    Integer addOrd(Ord ord);
//    Integer setOrd(Ord ord);
//    Integer delOrd(Ord ord);
}
