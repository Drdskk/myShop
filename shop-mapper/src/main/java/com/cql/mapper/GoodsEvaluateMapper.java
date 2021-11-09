package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.GoodsEvaluate;

import java.util.List;

public interface GoodsEvaluateMapper extends BaseMapper<GoodsEvaluate> {
    List<GoodsEvaluate> getGoodsEvaluates(GoodsEvaluate goodsEvaluate);
//    Integer addGoodsEvaluate(GoodsEvaluate goodsEvaluate);
//    Integer setGoodsEvaluate(GoodsEvaluate goodsEvaluate);
//    Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate);
}
