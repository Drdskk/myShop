package com.cql.controller;

import com.cql.entity.BigType;
import com.cql.service.BigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bigType")
public class BigTypeController {
    @Autowired
    private BigTypeService bigTypeService;


    /**
     * 定位到大类信息添加/修改页面
     * @param bigType  根据地址id,判断添加还是修改操作
     * @return      跳转到bigTypeForm.html
     */
    @RequestMapping("/bigTypeForm")
    public ModelAndView bigTypeForm(BigType bigType){
        ModelAndView mv=new ModelAndView("bigTypeForm");
        if (bigType.getId()==null){
            return mv;
        }
        mv.addObject("bigType",bigTypeService.getBigTypes(bigType).get(0));
        return mv;
    }

    /**
     * 获取所有大类信息
     * @param bigType
     * @return  跳转到bigTypePage界面
     */
    @RequestMapping("/getBigTypes")
    public ModelAndView getBigTypes(BigType bigType){
        ModelAndView mv=new ModelAndView("bigTypePage");
        mv.addObject("bigTypeList",bigTypeService.getBigTypes(bigType));
        return mv;
    }

    /**
     * 添加大类
     * @param bigType  添加的大类信息
     * @return  返回值为添加操作是否成功 0 or 1
     */
    @RequestMapping("/addBigType")
    @ResponseBody
    public Integer addBigType(BigType bigType){
        return bigTypeService.addBigType(bigType);
    }

    /**
     * 删除大类
     * @param bigType 需要删除大类的信息
     * @return  返回值为删除操作是否成功 0 or 1
     */
    @RequestMapping("/delBigType")
    @ResponseBody
    public Integer delBigType(BigType bigType){
        return bigTypeService.delBigType(bigType);
    }
}
