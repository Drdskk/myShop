package com.cql.controller;

import com.cql.entity.Goods;
import com.cql.entity.ShopCar;
import com.cql.entity.User;
import com.cql.service.GoodsService;
import com.cql.service.ShopCarService;
import com.cql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopCar")
public class ShopCarController {
    @Autowired
    private ShopCarService shopCarService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 定位到购物车信息添加/修改页面
     * @param shopCar  根据地址id,判断添加还是修改操作
     * @return      跳转到shopCarForm.html
     */
    @RequestMapping("/shopCarForm1")
    public ModelAndView addressForm1(ShopCar shopCar){
        ModelAndView mv=new ModelAndView("shopCarForm1");
        mv.addObject("userList",userService.getUsers(new User()));
        mv.addObject("goodsList",goodsService.getGoods(new Goods()));
        if (shopCar.getId()==null){
            return mv;
        }
        mv.addObject("shopCar",shopCarService.getShopCars(shopCar).get(0));
        return mv;
    }

    /**
     * 定位到购物车信息添加/修改页面
     * @param shopCar  根据地址id,判断添加还是修改操作
     * @return      跳转到shopCarForm.html
     */
    @RequestMapping("/shopCarForm2")
    public ModelAndView addressForm2(ShopCar shopCar){
        ModelAndView mv=new ModelAndView("shopCarForm2");
        if (shopCar.getId()==null){
            return mv;
        }
        mv.addObject("shopCar",shopCarService.getShopCars(shopCar).get(0));
        return mv;
    }

    /**
     * 获取所有购物车信息
     * @param shopCar
     * @return  跳转到shopCarPage.html
     */
    @RequestMapping("/getShopCars")
    public ModelAndView getShopCars(ShopCar shopCar){
        ModelAndView mv=new ModelAndView("shopCarPage");
        mv.addObject("shopCarList",shopCarService.getShopCars(shopCar));
        return mv;
    }

    /**
     *修改购物车
     * @param shopCar
     * @return  返回修改操作结果    isZero
     */
    @RequestMapping("/addShopCar")
    @ResponseBody
    public Integer addShopCar(ShopCar shopCar){
        return shopCarService.addShopCar(shopCar);
    }

    /**
     *购物车删除
     * @param shopCar
     * @return  返回删除操作结果    isZero
     */
    @RequestMapping("/delShopCar")
    @ResponseBody
    public Integer delShopCar(ShopCar shopCar){
        return shopCarService.delShopCar(shopCar);
    }

    /**
     *生成订单
     * @param shopCar
     * @return  返回生成订单操作结果  isZero
     */
    @RequestMapping("/shopCarToOrd")
    @ResponseBody
    public Integer shopCarToOrd(ShopCar shopCar){
        return shopCarService.shopCarToOrd(shopCar);
    }
}
