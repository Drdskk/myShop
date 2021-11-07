package com.cql.controller;

import com.cql.entity.Address;
import com.cql.entity.User;
import com.cql.service.AddressService;
import com.cql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    /**
     * 定位到地址信息添加/修改页面
     * @param address  根据地址id,判断添加还是修改操作
     * @return      跳转到addressForm.html
     */
    @RequestMapping("/addressForm")
    public ModelAndView addressForm(Address address){
        ModelAndView mv=new ModelAndView("addressForm");
        mv.addObject("userList",userService.getUsers(new User()));
        if (address.getId()==null){
            return mv;
        }
        mv.addObject("address",addressService.getAddress(address).get(0));
        return mv;
    }

    /**
     * 获取所有地址信息
     * @param address
     * @return  跳转到addressPage界面
     */
    @RequestMapping("/getAddress")
    public ModelAndView getAddress(Address address){
        ModelAndView mv=new ModelAndView("addressPage");
        mv.addObject("addressList",addressService.getAddress(address));
        return mv;
    }

    /**
     * 添加地址
     * @param address  添加的地址信息
     * @return  返回值为添加操作是否成功 0 or 1
     */
    @RequestMapping("/addAddress")
    @ResponseBody
    public Integer addAddress(Address address){
        return addressService.addAddress(address);
    }

    /**
     * 删除地址
     * @param address 需要删除地址的信息
     * @return  返回值为删除操作是否成功 0 or 1
     */
    @RequestMapping("/delAddress")
    @ResponseBody
    public Integer delAddress(Address address){
        return addressService.delAddress(address);
    }
}
