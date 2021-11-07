package com.cql.mapper;

import com.cql.entity.GoodsEvaluate;

import java.util.List;

public interface GoodsEvaluateMapper {
    List<GoodsEvaluate> getGoodsEvaluates(GoodsEvaluate goodsEvaluate);
    Integer addGoodsEvaluate(GoodsEvaluate goodsEvaluate);
    Integer setGoodsEvaluate(GoodsEvaluate goodsEvaluate);
    Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate);
}
