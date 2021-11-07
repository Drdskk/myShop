package com.cql.service;

import com.cql.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    List<User> getUsers(User user);
    Integer getUser(HttpServletRequest request, User user);
    Integer addUser(User user);
    Integer delUser(User user);
}
