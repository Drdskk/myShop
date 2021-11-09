package com.cql.service.impl;

import com.cql.config.MyCurrentTime;
import com.cql.config.MyUUID;
import com.cql.entity.Goods;
import com.cql.entity.GoodsEvaluate;
import com.cql.entity.ShopCar;
import com.cql.entity.User;
import com.cql.mapper.GoodsEvaluateMapper;
import com.cql.mapper.GoodsMapper;
import com.cql.mapper.UserMapper;
import com.cql.service.GoodsEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("goodsEvaluateService")
public class GoodsEvaluateServiceImpl implements GoodsEvaluateService {
    @Autowired
    private GoodsEvaluateMapper goodsEvaluateMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询操作
     * @param goodsEvaluate
     * @return  返回结果——goodsEvaluate对象的List集合
     */
    @Override
//    public List<GoodsEvaluate> getGoodsEvaluates(GoodsEvaluate goodsEvaluate) {
//        return goodsEvaluateMapper.getGoodsEvaluates(goodsEvaluate);
//    }
    //判断查询条件对象是否为空，再判断查询条件值是否为空
    public List<GoodsEvaluate> getGoodsEvaluates(GoodsEvaluate goodsEvaluate) {
        if(goodsEvaluate.getGoods()!=null){
            if(goodsEvaluate.getGoods().getGoodsName()!=null && goodsEvaluate.getGoods().getGoodsName()!=""){
                List<Goods> goodsList=goodsMapper.getGoods(new Goods().setGoodsName(goodsEvaluate.getGoods().getGoodsName()));
                if(goodsList.size()!=0){
                    goodsEvaluate.setGoodsId(goodsList.get(0).getId());
                }else {
                    return new ArrayList<GoodsEvaluate>();
                }
            }
        }
        if(goodsEvaluate.getUser()!=null){
            if(goodsEvaluate.getUser().getUserName()!=null && goodsEvaluate.getUser().getUserName()!=""){
                List<User> userList=userMapper.getUsers(new User().setUserName(goodsEvaluate.getUser().getUserName()));
                if(userList.size()!=0){
                    goodsEvaluate.setUserId(userList.get(0).getId());
                }else {
                    return new ArrayList<GoodsEvaluate>();
                }
            }
        }
        return goodsEvaluateMapper.getGoodsEvaluates(goodsEvaluate);
    }

    /**
     * 添加操作
     * @param goodsEvaluate
     * @return  返回操作结果  isZero
     */
    @Override
    public Integer addGoodsEvaluate(GoodsEvaluate goodsEvaluate) {
        return goodsEvaluateMapper.insert(goodsEvaluate.setId(MyUUID.getUUID()));
    }

    /**
     *删除操作
     * @param goodsEvaluate
     * @return  返回操作结果 isZero
     */
    @Override
//    public Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate) {
//        return goodsEvaluateMapper.delGoodsEvaluate(goodsEvaluate);
//    }
    public Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate) {
        return goodsEvaluateMapper.deleteById(goodsEvaluate.getId());
    }
}
