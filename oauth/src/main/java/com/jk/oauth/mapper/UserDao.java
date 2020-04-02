package com.jk.oauth.mapper;

import com.jk.oauth.vo.SysUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Yang HaiJi, 2019-05-17
 * @version Araf v1.0
 */
@Mapper
@Component
public interface UserDao {
    /**
     * 根据名字查询
     * @param username
     * @return
     */
    SysUserVO findByUserName(String username);

}
