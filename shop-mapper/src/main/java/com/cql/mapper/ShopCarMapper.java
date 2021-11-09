package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.Goods;
import com.cql.entity.ShopCar;
import com.cql.entity.User;

import java.util.List;

public interface ShopCarMapper extends BaseMapper<ShopCar> {
    List<ShopCar> getShopCars(ShopCar shopCar);
//    Integer addShopCar(ShopCar shopCar);
//    Integer setShopCar(ShopCar shopCar);
//    Integer delShopCar(ShopCar shopCar);
}
