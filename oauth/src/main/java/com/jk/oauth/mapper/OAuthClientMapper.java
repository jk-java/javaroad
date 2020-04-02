package com.jk.oauth.mapper;

import com.jk.oauth.entity.OAuthClient;
import org.springframework.stereotype.Repository;

/**
 * @author jk
 * @Date: 2020/1/17
 */
@Repository
public interface OAuthClientMapper {

    public OAuthClient findById(Integer id);

    public OAuthClient findByClientId(String clientId);
}
