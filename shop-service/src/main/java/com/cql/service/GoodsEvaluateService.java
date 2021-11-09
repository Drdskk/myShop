package com.cql.service;

import com.cql.entity.GoodsEvaluate;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GoodsEvaluateService {
    List<GoodsEvaluate> getGoodsEvaluates(GoodsEvaluate goodsEvaluate);
    Integer addGoodsEvaluate(GoodsEvaluate goodsEvaluate);
    Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate);
}
