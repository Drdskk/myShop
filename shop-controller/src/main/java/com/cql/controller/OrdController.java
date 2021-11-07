package com.cql.controller;

import com.cql.entity.Address;
import com.cql.entity.Goods;
import com.cql.entity.Ord;
import com.cql.service.AddressService;
import com.cql.service.GoodsService;
import com.cql.service.OrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ord")
public class OrdController {
    @Autowired
    private OrdService ordService;
    @Autowired
    private AddressService addressService;

    /**
     * 定位到订单信息添加/修改页面
     * @param ord  根据地址id,判断添加还是修改操作
     * @return      跳转到ordForm.html
     */
    @RequestMapping("/ordForm")
    public ModelAndView ordForm(Ord ord){
        ModelAndView mv=new ModelAndView("ordForm");
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
     * @return  返回值为添加操作是否成功 0 or 1
     */
    @RequestMapping("/addOrd")
    @ResponseBody
    public Integer addOrd(Ord ord,Goods goods){
        return ordService.addOrd(ord);
    }

    /**
     *删除订单
     * @param ord
     * @return  返回删除结果 0 or 1
     */
    @RequestMapping("/delOrd")
    @ResponseBody
    public Integer delOrd(Ord ord){
        return ordService.delOrd(ord);
    }
}
