package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.Goods;

import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    List<Goods> getGoods(Goods goods);
//    Integer addGoods(Goods goods);
//    Integer setGoods(Goods goods);
//    Integer upGoods(Goods goods);
//    Integer downGoods(Goods goods);
//    Integer delGoods(Goods goods);
}
