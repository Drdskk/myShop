package com.cql.controller;


import com.cql.entity.BigType;
import com.cql.entity.Goods;
import com.cql.entity.SmallType;
import com.cql.service.GoodsService;
import com.cql.service.SmallTypeService;
import com.cql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SmallTypeService smallTypeService;


    /**
     * 定位到商品信息添加/修改页面
     * @param goods  根据地址id,判断添加还是修改操作
     * @return      跳转到goodsForm.html
     */
    @RequestMapping("/goodsForm")
    public ModelAndView goodsForm(Goods goods){
        ModelAndView mv=new ModelAndView("goodsForm");
        mv.addObject("smallTypeList",smallTypeService.getSmallTypes(new SmallType()));
        if (goods.getId()==null){
            return mv;
        }
        mv.addObject("goods",goodsService.getGoods(goods).get(0));
        return mv;
    }

    /**
     * 定位到商品图片添加页面
     * @param goods  根据地址id,判断添加还是修改操作
     * @return      跳转到goodsForm.html
     */
    @RequestMapping("/goodsPicForm")
    public ModelAndView goodsPicForm(Goods goods){
        ModelAndView mv=new ModelAndView("goodsPicForm");
        mv.addObject("goods",goods);
        return mv;
    }

    /**
     *获取所有商品信息
     * @param goods
     * @return  跳转到goodsPage界面
     */
    @RequestMapping("/getGoods")
    public ModelAndView getGoods(Goods goods){
        ModelAndView mv=new ModelAndView("goodsPage");
        mv.addObject("goodsList",goodsService.getGoods(goods));
        return mv;
    }

    /**
     * 添加商品
     * @param goods  添加的商品信息
     * @return  返回值为添加操作是否成功 0 or 1
     */
    @RequestMapping("/addGoods")
    @ResponseBody
    public Integer addGoods(Goods goods){
        return goodsService.addGoods(goods);
    }

    /**
     * 上下架商品
     * @param goods 需要修改商品的信息
     * @return  返回值为上下架操作是否成功 0 or 1
     */
    @RequestMapping("/setGoods")
    @ResponseBody
    public Integer setGoods(Goods goods){
        return goodsService.setGoods(goods);
    }

    /**
     * 删除商品
     * @param goods 需要删除商品的信息
     * @return  返回值为删除操作是否成功 0 or 1
     */
    @RequestMapping("/delGoods")
    @ResponseBody
    public Integer delGoods(Goods goods){
        return goodsService.delGoods(goods);
    }

    /**
     * 图片上传
     * @param file
     * @param goods
     * @return  返回视图
     */
    @RequestMapping("/picUpload")
    @ResponseBody
    public Integer picUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Goods goods){
        return goodsService.picUpload(request,file,goods);
    }
}
