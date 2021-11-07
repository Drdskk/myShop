package com.cql.mapper;

import com.cql.entity.Ord;

import java.util.List;

public interface OrdMapper {
    List<Ord> getOrds(Ord ord);
    Integer addOrd(Ord ord);
    Integer setOrd(Ord ord);
    Integer delOrd(Ord ord);
}
