package com.cql.controller;

import com.cql.entity.Address;
import com.cql.entity.Goods;
import com.cql.entity.Ord;
import com.cql.entity.User;
import com.cql.service.AddressService;
import com.cql.service.GoodsService;
import com.cql.service.OrdService;
import com.cql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ord")
public class OrdController {
    @Autowired
    private OrdService ordService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;

    /**
     * 定位到订单信息添加页面
     * @param ord  根据地址id,判断添加还是修改操作
     * @return      跳转到ordForm1.html
     */
    @RequestMapping("/ordForm1")
    public ModelAndView ordForm1(Ord ord){
        ModelAndView mv=new ModelAndView("ordForm1");
        mv.addObject("userList",userService.getUsers(new User()));
        mv.addObject("goodsList",goodsService.getGoods(new Goods()));
        mv.addObject("addressList",addressService.getAddress(new Address()));
        if (ord.getId()==null){
            return mv;
        }
        mv.addObject("ord",ordService.getOrds(ord).get(0));
        return mv;
    }

    /**
     * 定位到订单信息修改页面
     * @param ord  根据地址id,判断添加还是修改操作
     * @return      跳转到ordForm.html
     */
    @RequestMapping("/ordForm2")
    public ModelAndView ordForm2(Ord ord){
        ModelAndView mv=new ModelAndView("ordForm2");
        mv.addObject("addressList",addressService.getAddress(new Address()));
        if (ord.getId()==null){
            return mv;
        }
        mv.addObject("ord",ordService.getOrds(ord).get(0));
        return mv;
    }

    /**
     * 取所有地址信息
     * @param ord
     * @return      跳转到ordPage.html
     */
    @RequestMapping("/getOrds")
    @ResponseBody
    public ModelAndView getOrds(Ord ord){
        ModelAndView mv=new ModelAndView("ordPage");
        mv.addObject("ordList",ordService.getOrds(ord));
        return mv;
    }

    /**
     *添加地址
     * @param ord
     * @return  返回值为添加操作是否成功 isZero
     */
    @RequestMapping("/addOrd")
    @ResponseBody
    public Integer addOrd(Ord ord,Goods goods){
        return ordService.addOrd(ord);
    }

    /**
     *删除订单
     * @param ord
     * @return  返回删除结果 isZero
     */
    @RequestMapping("/delOrd")
    @ResponseBody
    public Integer delOrd(Ord ord){
        return ordService.delOrd(ord);
    }
}
