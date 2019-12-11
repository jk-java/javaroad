package com.jk.urm.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.jk.urm.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public List<User> queryAllUser();

    public List<User> queryUserCondition(Map map);

    public User queryUser(User user);

    @DS("write")
    public int insertUser(User user);

    @DS("write")
    public int insertUserList(List<User> userList);
}
