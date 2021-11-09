package com.cql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cql.config.MyUUID;
import com.cql.entity.Goods;
import com.cql.entity.Ord;
import com.cql.entity.User;
import com.cql.mapper.GoodsMapper;
import com.cql.mapper.OrdMapper;
import com.cql.mapper.UserMapper;
import com.cql.service.OrdService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("ordService")
public class OrdServiceImpl implements OrdService {
    @Autowired
    private OrdMapper ordMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     *查询操作
     * @param ord
     * @return  返回结果——Ord对象的List集合
     */
    @Override
//    public List<Ord> getOrds(Ord ord) {
//        if(ord.getGoods()!=null){
//            if(ord.getGoods().getGoodsName()!=null && ord.getGoods().getGoodsName()!=""){
//                List<Goods> goodsList=goodsMapper.getGoods(new Goods().setGoodsName(ord.getGoods().getGoodsName()));
//                if(goodsList.size()!=0) {
//                    ord.setGoodsId(goodsList.get(0).getId());
//                }
//            }
//        }
//
//        if(ord.getUser()!=null) {
//            if (ord.getUser().getUserName() != null && ord.getUser().getUserName() != "") {
//                User user=new User().setUserName(ord.getUser().getUserName());
//                List<User> userList = userMapper.getUsers(user);
//                if (userList.size() != 0) {
//                    ord.setUserId(userList.get(0).getId());
//                }
//            }
//        }
//
//        List<Ord> ordList=ordMapper.getOrds(ord);
//        for(Ord ord1:ordList){
//            ord1.setPrice(String.valueOf(Integer.parseInt(ord1.getGoods().getPrice())*Integer.parseInt(ord1.getNum())));
//        }
//        return ordList;
//    }
    public List<Ord> getOrds(Ord ord) {
        if(ord.getGoods()!=null){
            if(ord.getGoods().getGoodsName()!=null && ord.getGoods().getGoodsName()!=""){
                List<Goods> goodsList=goodsMapper.getGoods(new Goods().setGoodsName(ord.getGoods().getGoodsName()));
                if(goodsList.size()!=0) {
                    ord.setGoodsId(goodsList.get(0).getId());
                }else {
                    return new ArrayList<Ord>();
                }
            }
        }

        if(ord.getUser()!=null) {
            if (ord.getUser().getUserName() != null && ord.getUser().getUserName() != "") {
                List<User> userList = userMapper.getUsers(new User().setUserName(ord.getUser().getUserName()));
                if (userList.size() != 0) {
                    ord.setUserId(userList.get(0).getId());
                }else {
                    return new ArrayList<Ord>();
                }
            }
        }

        List<Ord> ordList=ordMapper.getOrds(ord);
        for(Ord ord1:ordList){
            ord1.setPrice(String.valueOf(Integer.parseInt(ord1.getGoods().getPrice())*Integer.parseInt(ord1.getNum())));
        }
        return ordList;
    }

    /**
     *添加操作
     * @param ord
     * @return  返回操作结果 isZero
     */
    @Override
//    public Integer addOrd(Ord ord) {
///*        if (ord.getId().isEmpty()){
////            List<Goods> goodsList = goodsMapper.getGoods(new Goods().setId(ord.getGoodsId()));
////
////            Integer goodsNum = Integer.parseInt(goodsList.get(0).getNum());
////            Integer ordNum = Integer.parseInt(ord.getNum());
////
////            if (ordNum < goodsNum) {
////                goodsMapper.setGoods(new Goods().setNum(String.valueOf(goodsNum - ordNum)).setId(goodsList.get(0).getId()));
////                return ordMapper.addOrd(ord.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
////            }
////            return 0;
////        }*/
////        return ordMapper.setOrd(ord);
//    }
    public Integer addOrd(Ord ord) {
        if (ord.getId().isEmpty()){
            List<Goods> goodsList = goodsMapper.getGoods(new Goods().setId(ord.getGoodsId()));

            Integer goodsNum = Integer.parseInt(goodsList.get(0).getNum());
            Integer ordNum = Integer.parseInt(ord.getNum());

            if (ordNum < goodsNum) {
                goodsMapper.updateById(new Goods()
                        .setNum(String.valueOf(goodsNum - ordNum))
                        .setId(goodsList.get(0).getId()));
                return ordMapper.insert(ord
                        .setId(MyUUID.getUUID())
                        .setCreateTime(MyCurrentTime.getTime())
                        .setDelFlag("0"));
            }
            return 0;
        }
        return ordMapper.updateById(ord);
    }

    /**
     * 删除操作
     * @param ord
     * @return  返回操作结果 isZero
     */
    @Override
//    public Integer delOrd(Ord ord){
//        List<Ord> ordList = ordMapper.getOrds(ord);
//
//        if ("5".equals(ordList.get(0).getOrdState())) {
//            List<Goods> goodsList = goodsMapper.getGoods(new Goods().setId(ord.getGoodsId()));
//
//            Integer goodsNum = Integer.parseInt(goodsList.get(0).getNum());
//            Integer ordNum = Integer.parseInt(ordList.get(0).getNum());
//
//            goodsMapper.setGoods(new Goods().setNum(String.valueOf(goodsNum + ordNum)).setId(goodsList.get(0).getId()));
//            return ordMapper.delOrd(ord);
//        }
//        return 0;
//    }
    public Integer delOrd(Ord ord){
        List<Ord> ordList = ordMapper.getOrds(ord);

        //只有在订单状态为5(结束订单)时才能删除订单，并恢复商品数量
        if ("5".equals(ordList.get(0).getOrdState())) {
            List<Goods> goodsList = goodsMapper.getGoods(new Goods().setId(ord.getGoodsId()));

            Integer goodsNum = Integer.parseInt(goodsList.get(0).getNum());
            Integer ordNum = Integer.parseInt(ordList.get(0).getNum());

            goodsMapper.updateById(new Goods()
                    .setNum(String.valueOf(goodsNum + ordNum))
                    .setId(goodsList.get(0).getId()));
            return ordMapper.updateById(ord.setDelFlag("1"));
        }
        return 0;
    }
}
