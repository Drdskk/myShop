package com.cql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cql.config.MyCurrentTime;
import com.cql.config.MyUUID;
import com.cql.entity.Goods;
import com.cql.entity.Ord;
import com.cql.entity.ShopCar;
import com.cql.entity.User;
import com.cql.mapper.GoodsMapper;
import com.cql.mapper.OrdMapper;
import com.cql.mapper.ShopCarMapper;
import com.cql.mapper.UserMapper;
import com.cql.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("shopCarService")
public class ShopCarServiceImpl implements ShopCarService{
    @Autowired
    private ShopCarMapper shopCarMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrdMapper ordMapper;

    /**
     * 查询操作
     * @param shopCar
     * @return  返回结果——ShopCar对象的List集合
     */
    @Override
//    public List<ShopCar> getShopCars(ShopCar shopCar) {
//        //判断要查询条件 商品 or 用户
//        //根据商品名查询商品id
//        if(shopCar.getGoods()!=null){
//            if(shopCar.getGoods().getGoodsName()!=null && shopCar.getGoods().getGoodsName()!=""){
//                List<Goods> goodsList=goodsMapper.getGoods(new Goods().setGoodsName(shopCar.getGoods().getGoodsName()));
//                if(goodsList.size()!=0){
//                    //添加商品id条件
//                    shopCar.setGoodsId(goodsList.get(0).getId());
//                }
//            }
//
//        }
//        //根据用户名查询用户id
//        if(shopCar.getUser()!=null){
//            if(shopCar.getUser().getUserName()!=null && shopCar.getUser().getUserName()!=""){
//                List<User> userList=userMapper.getUsers(new User().setUserName(shopCar.getUser().getUserName()));
//                if(userList.size()!=0){
//                    //添加用户id条件
//                    shopCar.setUserId(userList.get(0).getId());
//                }
//            }
//        }
//        return shopCarMapper.getShopCars(shopCar);
//    }
    public List<ShopCar> getShopCars(ShopCar shopCar) {
        if(shopCar.getGoods()!=null){
            if(shopCar.getGoods().getGoodsName()!=null && shopCar.getGoods().getGoodsName()!=""){
                List<Goods> goodsList=goodsMapper.getGoods(new Goods().setGoodsName(shopCar.getGoods().getGoodsName()));
                if(goodsList.size()!=0){
                    shopCar.setGoodsId(goodsList.get(0).getId());
                }else {
                    return new ArrayList<ShopCar>();
                }
            }
        }
        if(shopCar.getUser()!=null){
            if(shopCar.getUser().getUserName()!=null && shopCar.getUser().getUserName()!=""){
                List<User> userList=userMapper.getUsers(new User().setUserName(shopCar.getUser().getUserName()));
                if(userList.size()!=0){
                    shopCar.setUserId(userList.get(0).getId());
                }else {
                    return new ArrayList<ShopCar>();
                }
            }
        }
        return shopCarMapper.getShopCars(shopCar);
    }

    /**
     * 插入/修改操作
     * @param shopCar
     * @return  返回结果操作是否成功——isZero
     */
    @Override
//    public Integer addShopCar(ShopCar shopCar) {
//        return shopCarMapper.setShopCar(shopCar);
//    }
    public Integer addShopCar(ShopCar shopCar) {
        if(shopCar.getId().isEmpty()){
            return shopCarMapper.insert(shopCar
                    .setId(MyUUID.getUUID())
                    .setDelFlag("0"));
        }else{
            return shopCarMapper.updateById(shopCar);
        }
    }

    /**
     * 删除操作
     * @param shopCar
     * @return  返回删除结果 isZero
     */
    @Override
//    public Integer delShopCar(ShopCar shopCar) {
//        return shopCarMapper.delShopCar(shopCar);
//    }
    public Integer delShopCar(ShopCar shopCar) {
        return shopCarMapper.updateById(shopCar.setDelFlag("1"));
    }

    /**
     * 添加操作
     * @param shopCar
     * @return  返回操作结果  isZero
     */
    @Override
    public Integer shopCarToOrd(ShopCar shopCar) {
        List<ShopCar> shopCarList=shopCarMapper.getShopCars(new ShopCar().setId(shopCar.getId()));
        List<Goods> goodsList = goodsMapper.getGoods(new Goods().setId(shopCarList.get(0).getGoodsId()));

        Integer goodsNum = Integer.parseInt(goodsList.get(0).getNum());
        Integer ordNum=Integer.parseInt(shopCarList.get(0).getNum());

        //订单表和地址表做了关联查询，但购物车表中没有地址字段。就随便设置了一个地址Id值
        if (ordNum < goodsNum) {
            Ord ord=new Ord()
                    .setId(MyUUID.getUUID())
                    .setGoodsId(shopCarList.get(0).getGoodsId())
                    .setUserId(shopCarList.get(0).getUserId())
                    .setNum(shopCarList.get(0).getNum())
                    .setAddressId("1")
                    .setOrdState("1")
                    .setDelFlag("0");

            //删除购物车
            shopCarMapper.deleteById(shopCar.getId());

            //修改商品数量
            goodsMapper.updateById(new Goods()
                    .setNum(String.valueOf(goodsNum - ordNum))
                    .setId(goodsList.get(0).getId()));

            return ordMapper.insert(ord);
        }
        return 0;
    }
}
