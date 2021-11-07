package com.cql.service.impl;

import com.cql.config.MyCurrentTime;
import com.cql.config.MyUUID;
import com.cql.entity.Goods;
import com.cql.entity.ShopCar;
import com.cql.entity.User;
import com.cql.mapper.GoodsMapper;
import com.cql.mapper.ShopCarMapper;
import com.cql.mapper.UserMapper;
import com.cql.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 查询操作
     * @param shopCar
     * @return  返回结果——ShopCar对象的List集合
     */
    @Override
    public List<ShopCar> getShopCars(ShopCar shopCar) {
        //判断要查询条件 商品 or 用户
        //根据商品名查询商品id
        if(shopCar.getGoods()!=null){
            if(shopCar.getGoods().getGoodsName()!=null && shopCar.getGoods().getGoodsName()!=""){
                List<Goods> goodsList=goodsMapper.getGoods(new Goods().setGoodsName(shopCar.getGoods().getGoodsName()));
                if(goodsList.size()!=0){
                    //添加商品id条件
                    shopCar.setGoodsId(goodsList.get(0).getId());
                }
            }

        }
        //根据用户名查询用户id
        if(shopCar.getUser()!=null){
            if(shopCar.getUser().getUserName()!=null && shopCar.getUser().getUserName()!=""){
                List<User> userList=userMapper.getUsers(new User().setUserName(shopCar.getUser().getUserName()));
                if(userList.size()!=0){
                    //添加用户id条件
                    shopCar.setUserId(userList.get(0).getId());
                }
            }
        }
        return shopCarMapper.getShopCars(shopCar);
    }

    /**
     * 插入/修改操作
     * @param shopCar
     * @return  返回结果操作是否成功——0 or 1
     */
    @Override
    public Integer addShopCar(ShopCar shopCar) {
        return shopCarMapper.setShopCar(shopCar);
    }

    /**
     * 删除操作
     * @param shopCar
     * @return  返回删除结果 0 or 1
     */
    @Override
    public Integer delShopCar(ShopCar shopCar) {
        return shopCarMapper.delShopCar(shopCar);
    }
}
