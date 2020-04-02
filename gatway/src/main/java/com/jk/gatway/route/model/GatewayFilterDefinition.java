package com.jk.gatway.route.model;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建过滤器定义模型
 * @author jk
 * @Date: 2019/12/11
 */
@Data
public class GatewayFilterDefinition {

    //Filter Name
    private String name;
    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();
}
