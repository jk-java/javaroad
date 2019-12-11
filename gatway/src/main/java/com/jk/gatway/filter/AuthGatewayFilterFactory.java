package com.jk.gatway.filter;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author jk
 * @Date: 2019/12/4
 */
@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Override
    public AuthGatewayFilter apply(Object config)
    {
        return new AuthGatewayFilter();
    }

}
