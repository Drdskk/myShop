package com.cql.service;

import com.cql.entity.Goods;
import com.cql.entity.ShopCar;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.List;

public interface ShopCarService {
    List<ShopCar> getShopCars(ShopCar shopCar);
    Integer addShopCar(ShopCar shopCar);
    Integer delShopCar(ShopCar shopCar);
}
