package com.cql.controller;

import com.cql.entity.BigType;
import com.cql.entity.SmallType;
import com.cql.service.AddressService;
import com.cql.service.BigTypeService;
import com.cql.service.SmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("smallType")
public class SmallTypeController {
    @Autowired
    private SmallTypeService smallTypeService;
    @Autowired
    private BigTypeService bigTypeService;

    /**
     * 定位到小类信息添加/修改页面
     * @param smallType  根据地址id,判断添加还是修改操作
     * @return      跳转到smallTypeForm.html
     */
    @RequestMapping("/smallTypeForm")
    public ModelAndView smallTypeForm(SmallType smallType){
        ModelAndView mv=new ModelAndView("smallTypeForm");
        mv.addObject("bigTypeList",bigTypeService.getBigTypes(new BigType()));
        if (smallType.getId()==null){
            return mv;
        }
        mv.addObject("smallType",smallTypeService.getSmallTypes(smallType).get(0));
        return mv;
    }

    /**
     * 获取所有小类信息
     * @param smallType
     * @return  跳转到smallTypePage界面
     */
    @RequestMapping(value = "/getSmallTypes")
    public ModelAndView getSmallTypes(SmallType smallType){
        ModelAndView mv=new ModelAndView("smallTypePage");
        mv.addObject("smallTypeList",smallTypeService.getSmallTypes(smallType));
        return mv;
    }

    /**
     * 添加小类
     * @param smallType  添加的小类信息
     * @return  返回值为添加操作是否成功 0 or 1
     */
    @RequestMapping("/addSmallType")
    @ResponseBody
    public Integer addSmallType(SmallType smallType){
        return smallTypeService.addSmallType(smallType);
    }

    /**
     * 删除小类
     * @param smallType 需要删除小类的信息
     * @return  返回值为删除操作是否成功 0 or 1
     */
    @RequestMapping("/delSmallType")
    @ResponseBody
    public Integer delBigType(SmallType smallType){
        return smallTypeService.delSmallType(smallType);
    }
}
