package com.cql.controller;

import com.cql.entity.Goods;
import com.cql.entity.ShopCar;
import com.cql.service.GoodsService;
import com.cql.service.ShopCarService;
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

    /**
     * 定位到购物车信息添加/修改页面
     * @param shopCar  根据地址id,判断添加还是修改操作
     * @return      跳转到shopCarForm.html
     */
    @RequestMapping("/shopCarForm")
    public ModelAndView addressForm(ShopCar shopCar){
        ModelAndView mv=new ModelAndView("shopCarForm");
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
     * @return  返回修改操作结果
     */
    @RequestMapping("/addShopCar")
    @ResponseBody
    public Integer addShopCar(ShopCar shopCar){
        return shopCarService.addShopCar(shopCar);
    }

    /**
     *
     * @param shopCar
     * @return
     */
    @RequestMapping("/delShopCar")
    @ResponseBody
    public Integer delShopCar(ShopCar shopCar){
        return shopCarService.delShopCar(shopCar);
    }
}
