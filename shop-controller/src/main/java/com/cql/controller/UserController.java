package com.cql.controller;

import com.cql.entity.User;
import com.cql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 定位到登录后的首页
     * @return      跳转到head.html
     */
    @RequestMapping("/head")
    public String head(){
        return "head";
    }

    /**
     * 定位到用户信息添加/修改页面
     * @param user  根据用户id,判断添加还是修改操作
     * @return      跳转到userForm.html
     */
    @RequestMapping("/userForm")
    public ModelAndView userForm(User user){
        ModelAndView mv=new ModelAndView("userForm");
        /**
         * isEmpty会在未分配内存空间时报空指针异常  无法分辨值是否为空还是空字符串
         * null用来分辨是否分配了内存空间
         * ""无法分辨是否分配内存空间               判断值是否为空字符串
         */
        if (user.getId()==null){
            return mv;
        }
        mv.addObject("user",userService.getUsers(user).get(0));
        return mv;
    }

    /**
     * 退出登录
     * @param request
     * @return      退出到登陆界面
     */
    @RequestMapping("/out")
    public String out(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "static/login";
    }

    /**
     * 获取所有用户信息
     * @param user
     * @return      跳转到userPage页面
     */
    @RequestMapping("/getUsers")
    public ModelAndView getUsers(User user){
        ModelAndView mv=new ModelAndView("userPage");
        mv.addObject("userList",userService.getUsers(user));
        return mv;
    }

    /**
     * 登录
     * @param user
     * @return  返回值为是否有该用户 0 or 1
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public Integer getUser(HttpServletRequest request,User user){
        return userService.getUser(request,user);
    }

    /**
     * 添加用户
     * @param user  添加的用户信息
     * @return  返回值为添加操作是否成功 0 or 1
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public Integer addUser(User user){
        return userService.addUser(user);
    }

    /**
     * 删除用户
     * @param user  需要删除用户的信息
     * @return  返回值为删除操作是否成功 0 or 1
     */
    @RequestMapping("/delUser")
    @ResponseBody
    public Integer delUser(User user){ return userService.delUser(user); }
}
