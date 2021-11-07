package com.cql.mapper;

import com.cql.entity.Goods;
import com.cql.entity.ShopCar;
import com.cql.entity.User;

import java.util.List;

public interface ShopCarMapper {
    List<ShopCar> getShopCars(ShopCar shopCar);
    Integer addShopCar(ShopCar shopCar);
    Integer setShopCar(ShopCar shopCar);
    Integer delShopCar(ShopCar shopCar);
}
