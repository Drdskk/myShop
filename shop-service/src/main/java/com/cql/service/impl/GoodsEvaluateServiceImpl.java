package com.cql.service.impl;

import com.cql.entity.GoodsEvaluate;
import com.cql.entity.User;
import com.cql.mapper.GoodsEvaluateMapper;
import com.cql.service.GoodsEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service("goodsEvaluateService")
public class GoodsEvaluateServiceImpl implements GoodsEvaluateService {
    @Autowired
    private GoodsEvaluateMapper goodsEvaluateMapper;

    /**
     * 查询操作
     * @param goodsEvaluate
     * @return  返回结果——goodsEvaluate对象的List集合
     */
    @Override
    public List<GoodsEvaluate> getGoodsEvaluates(GoodsEvaluate goodsEvaluate) {
        return goodsEvaluateMapper.getGoodsEvaluates(goodsEvaluate);
    }

    /**
     *删除操作
     * @param goodsEvaluate
     * @return  返回操作结果 0 or 1
     */
    @Override
    public Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate) {
        return goodsEvaluateMapper.delGoodsEvaluate(goodsEvaluate);
    }
}
