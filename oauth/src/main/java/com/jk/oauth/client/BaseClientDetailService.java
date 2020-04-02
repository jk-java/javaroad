package com.jk.oauth.client;

/**
 * @author jk
 * @Date: 2019/12/27
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 自定义客户端认证\
 */
@Slf4j
@Component
public class BaseClientDetailService implements ClientDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        System.out.println("client_id---------------" + clientId + "------------------");
        BaseClientDetails client = null;
        //这里可以改为查询数据库
        if("client".equals(clientId)) {
//            log.info(clientId);
            String secret = passwordEncoder.encode("123jk");
            client = new BaseClientDetails();
            client.setClientId(clientId);
            System.out.println("secret：" + secret);
            client.setClientSecret(secret);
            //client.setResourceIds(Arrays.asList("order"));
            client.setAuthorizedGrantTypes(Arrays.asList("authorization_code",
                    "client_credentials", "refresh_token", "password", "implicit"));
            //不同的client可以通过 一个scope 对应 权限集
            client.setScope(Arrays.asList("all", "select" , "read_scope"));
            client.setAuthorities(AuthorityUtils.createAuthorityList("admin_role"));
            client.setAccessTokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(1)); //1天
            client.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); //1天
        }
        if(client == null) {
            System.out.println("error_client_id---------------" + clientId + "------------------");
            throw new NoSuchClientException("No client width requested id: " + clientId);
        }
        return client;
    }

}
