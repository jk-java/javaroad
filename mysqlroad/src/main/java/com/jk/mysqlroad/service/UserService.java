package com.jk.mysqlroad.service;

import com.jk.mysqlroad.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<User> queryAllUser();

    public User queryUser(User user);

    public User login(User user);

    public User queryUserById(String userId);

    public int insertUser(User user);

    public int insertUserList(List<User> userList);

    public int updateUser(User user);

    public int deleteUser(User user);

    public List<User> queryUserCondition(Map map);
}
