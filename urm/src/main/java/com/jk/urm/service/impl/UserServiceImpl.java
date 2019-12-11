package com.jk.urm.service.impl;

import com.jk.urm.entity.User;
import com.jk.urm.mapper.UserMapper;
import com.jk.urm.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Cacheable("allUser")
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    @Cacheable(value = "userCondition")
    public List<User> queryUserCondition(Map map) {
        return userMapper.queryUserCondition(map);
    }

    @Cacheable(value = "user")
    public User queryUser(User user){
        if(StringUtils.isEmpty(user.getId())&&StringUtils.isEmpty(user.getUserName())&&StringUtils.isEmpty(user.getUserPassword())) return null;
        return userMapper.queryUser(user);
    }

    @Cacheable(value = {"login", "user"},key = "#user.userName + #user.userPassword")
    public User login(User user){
        if(StringUtils.isEmpty(user.getUserName())||StringUtils.isEmpty(user.getUserPassword())) return null;
        return queryUser(user);
    }

    @Override
    @Cacheable(value = {"user"}, key="#user.id")
    public User queryUserById(String userId) {
        User user = new User();
        if(userId == null || userId.equals("")){
            return null;
        }
        user.setId(Integer.valueOf(userId));
        return queryUser(user);
    }

    @Override
    @CacheEvict(value = "allUser" , allEntries=true)
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    @CacheEvict(value = "allUser" , allEntries=true)
    public int insertUserList(List<User> userList){
        return userMapper.insertUserList(userList);
    }


    @Override
    @CacheEvict(value = "user" , key="#user.id")
    public int updateUser(User user) {
        return 0;
    }

    @Override
    @CacheEvict(value = "user" , key="#user.id")
    public int deleteUser(User user) {
        return 0;
    }
}
