package com.cql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cql.config.MyUUID;
import com.cql.entity.User;
import com.cql.mapper.UserMapper;
import com.cql.service.UserService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Wrapper;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * (条件)查询用户操作
     * @param user
     * @return  返回查询结果——User对象的List集合
     */
    @Override
//    public List<User> getUsers(User user) {
//        return userMapper.getUsers(user);
//    }
    public List<User> getUsers(User user){
        return userMapper.getUsers(user);
    }

    /**
     * 插入/修改操作
     * @param user
     * @return  返回结果操作是否成功——isZero
     */
    @Override
//    public Integer addUser(User user) {
//        //根据id是否为空判断是插入还是修改操作
//        if(user.getId().isEmpty()){
//            //添加操作
//            //查询用户名是否存在
//            List<User> userList=userMapper.getUsers(new User().setUserName(user.getUserName()));
//            if(userList.size() == 0){
//                //设置id,创建时间
//                return userMapper.addUser(user.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
//            }
//            return 0;
//        }else{
//            //修改操作
//            return userMapper.setUser(user);
//        }
//    }
    public Integer addUser(User user){
        if(user.getId().isEmpty()){
            List<User> userList=userMapper.getUser(new User().setUserName(user.getUserName()));
            if(userList.size()==0){
                return userMapper.insert(user
                        .setId(MyUUID.getUUID())
                        .setCreateTime(MyCurrentTime.getTime())
                        .setDelFlag("0"));
            }
            return 0;
        }else {
            return userMapper.updateById(user);
        }
    }

    /**
     * 单体查询操作
     * @param request
     * @param user
     * @return  返回查询结果—— 1 or 0
     */
    @Override
//    public Integer getUser(HttpServletRequest request,User user) {
//        //查询是否有该用户
//        List<User>  userList=userMapper.getUser(user);
//
//        if(userList.size() == 0){
//            return 0;
//        }
//
//        request.getSession().setAttribute("user",userList.get(0));
//        return 1;
//    }
    public Integer getUser(HttpServletRequest request,User user){
        List<User> userList= userMapper.selectList(new QueryWrapper<User>(user));

        if (userList.size()==0){
            return 0;
        }

        request.getSession().setAttribute("user",userList.get(0));
        return 1;
    }

    /**
     * (逻辑)删除操作
     * @param user
     * @return  返回删除操作结果——isZero
     */
    @Override
//    public Integer delUser(User user) {
//        return userMapper.delUser(user);
//    }
    public Integer delUser(User user){
        return userMapper.updateById(user.setDelFlag("1"));
    }
}
