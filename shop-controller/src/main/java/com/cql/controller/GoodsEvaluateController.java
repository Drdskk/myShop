package com.cql.controller;

import com.cql.entity.Goods;
import com.cql.entity.GoodsEvaluate;
import com.cql.entity.SmallType;
import com.cql.service.GoodsEvaluateService;
import com.cql.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/goodsEvaluate")
public class GoodsEvaluateController {
    @Autowired
    private GoodsEvaluateService goodsEvaluateService;

    /**
     * 获取所有的评论信息
     * @param goodsEvaluate
     * @return  跳转到goodsEvaluatePage.html页面
     */
    @RequestMapping("/getGoodsEvaluates")
    @ResponseBody
    public ModelAndView getGoodsEvaluates(GoodsEvaluate goodsEvaluate){
        ModelAndView mv=new ModelAndView("goodsEvaluatePage");
        mv.addObject("goodsEvaluateList",goodsEvaluateService.getGoodsEvaluates(goodsEvaluate));
        return mv;
    }

    /**
     * 删除评论
     * @param goodsEvaluate
     * @return  返回删除评论结果 0 or 1
     */
    @RequestMapping("/delGoodsEvaluate")
    @ResponseBody
    public Integer delGoodsEvaluate(GoodsEvaluate goodsEvaluate){
        return goodsEvaluateService.delGoodsEvaluate(goodsEvaluate);
    }
}
