package com.jk.gatway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 网关鉴权
 * @author jk
 * @Date: 2019/12/4
 */
@Component
public class AuthGatewayFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        exchange.getResponse().getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        Result result = new Result();
        //后端调用跳过验签
        boolean skipAuth = Boolean.valueOf(exchange.getRequest().getQueryParams().getFirst("skipAuth"));
         if (!skipAuth) {
            String sign = exchange.getRequest().getQueryParams().getFirst("sign");
            if (StringUtils.isEmpty(sign)) {
                //没有验签参数
//                result.setCode(ResultCodeEnum.SGIN_EMPTY.getCode());
//                result.setMsg(ResultCodeEnum.SGIN_EMPTY.getMsg());
//                return exchange.getResponse().writeWith(Flux.just(this.getBodyBuffer(exchange.getResponse(), result)));
            }
            String publicKey = exchange.getRequest().getHeaders().getFirst("publicKey");
            if (StringUtils.isEmpty(publicKey)) {
                //没有公钥
//                result.setCode(ResultCodeEnum.PUBLICKEY_EMPTY.getCode());
//                result.setMsg(ResultCodeEnum.PUBLICKEY_EMPTY.getMsg());
//                return exchange.getResponse().writeWith(Flux.just(this.getBodyBuffer(exchange.getResponse(), result)));
            }
//            String privateKey = redisUtil.getValueStr(publicKey);
            /*if (!StringUtils.isEmpty(privateKey)) {
                TreeMap<String, List<String>> parameterMap = new TreeMap<>(exchange.getRequest().getQueryParams());
                //验签
                StringBuilder sb = new StringBuilder();
                parameterMap.entrySet().forEach(stringEntry -> {
                    if (!StringUtils.equalsIgnoreCase(stringEntry.getKey(), "sign")) {
                        if (!CollectionUtils.isEmpty(stringEntry.getValue())) {
                            sb.append(stringEntry.getKey());
                            sb.append("=");
                            sb.append(stringEntry.getValue().stream().findFirst().get());
                        }
                    }
                });
                sb.append("privateKey=");
                sb.append(privateKey);
                System.out.println(sb.toString());
                String serverSign = DigestUtils.md5Hex(sb.toString());
                System.out.println(serverSign);
                if (!serverSign.equals(sign)) {
                    //验签不通过
                    result.setCode(ResultCodeEnum.SIGN_INVALID.getCode());
                    result.setMsg(ResultCodeEnum.SIGN_INVALID.getMsg());
                    return exchange.getResponse().writeWith(Flux.just(this.getBodyBuffer(exchange.getResponse(), result)));
                }
            } else {
                //私钥过期
                result.setCode(ResultCodeEnum.PRIVATEKEY_EXPIRE.getCode());
                result.setMsg(ResultCodeEnum.PRIVATEKEY_EXPIRE.getMsg());
                return exchange.getResponse().writeWith(Flux.just(this.getBodyBuffer(exchange.getResponse(), result)));
            }*/
        }
        return chain.filter(exchange);
    }

    /**
     * 
     * @param
     * @return 
     * @author jk
     * @Date: 2019/12/4
     */
//    private DataBuffer getBodyBuffer(ServerHttpResponse response, Result result) {
//        return response.bufferFactory().wrap(JSONObject.toJSONBytes(result));
//    }

    @Override
    public int getOrder() {
        return 0;
    }
}
