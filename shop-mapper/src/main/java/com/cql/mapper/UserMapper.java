package com.cql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> getUsers(User user);
    List<User> getUser(User user);
//    Integer addUser(User user);
//    Integer setUser(User user);
//    Integer delUser(User user);
}
