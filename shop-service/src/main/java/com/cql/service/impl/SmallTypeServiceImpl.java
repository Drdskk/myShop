package com.cql.service.impl;

import com.cql.config.MyUUID;
import com.cql.entity.BigType;
import com.cql.entity.Goods;
import com.cql.entity.SmallType;
import com.cql.mapper.GoodsMapper;
import com.cql.mapper.SmallTypeMapper;
import com.cql.service.SmallTypeService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("smallTypeService")
public class SmallTypeServiceImpl implements SmallTypeService {
    @Autowired
    private SmallTypeMapper smallTypeMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询操作
     * @param smallType
     * @return  返回结果——SmallType对象的List集合
     */
    @Override
//    public List<SmallType> getSmallTypes(SmallType smallType) {
//        return smallTypeMapper.getSmallTypes(smallType);
//    }
    public List<SmallType> getSmallTypes(SmallType smallType) {
        return smallTypeMapper.getSmallTypes(smallType);
    }

    /**
     * 插入/修改操作
     * @param smallType
     * @return  返回结果操作是否成功——isZero
     */
    @Override
//    public Integer addSmallType(SmallType smallType) {
//        //根据id是否为空判断是插入还是修改操作
//        if(smallType.getId().isEmpty()){
//            //添加操作
//            //设置id,创建时间
//            return smallTypeMapper.addSmallType(smallType.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
//        }else{
//            //修改操作
//            return smallTypeMapper.setSmallType(smallType);
//        }
//    }
    public Integer addSmallType(SmallType smallType) {
        if(smallType.getId().isEmpty()){
            return smallTypeMapper.insert(smallType
                    .setId(MyUUID.getUUID())
                    .setCreateTime(MyCurrentTime.getTime())
                    .setDelFlag("0"));
        }else{
            return smallTypeMapper.updateById(smallType);
        }
    }


    /**
     * 删除操作
     * @param smallType
     * @return  返回删除操作结果 isZero
     */
    @Override
//    public Integer delSmallType(SmallType smallType) {
//        List<Goods> goodsList=goodsMapper.getGoods(new Goods().setSmallTypeId(smallType.getId()));
//        for(Goods goods:goodsList){
//            goodsMapper.delGoods(goods);
//        }
//        return smallTypeMapper.delSmallType(smallType);
//    }
    public Integer delSmallType(SmallType smallType) {
        List<Goods> goodsList=goodsMapper.getGoods(new Goods().setSmallTypeId(smallType.getId()));
//        for(Goods goods:goodsList){
//            goodsMapper.updateById(goods.setDelFlag("1"));
//        }
//        return smallTypeMapper.updateById(smallType);
        //判断小类下是否还有商品，有就不删
        if(goodsList.size()==0){
            return smallTypeMapper.updateById(smallType.setDelFlag("1"));
        }
        return 0;
    }
}
