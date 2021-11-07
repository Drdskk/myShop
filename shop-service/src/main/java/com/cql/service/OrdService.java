package com.cql.service;

import com.cql.entity.Goods;
import com.cql.entity.Ord;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrdService {
    List<Ord> getOrds(Ord ord);
    Integer addOrd(Ord ord);
    Integer delOrd(Ord ord);
}
