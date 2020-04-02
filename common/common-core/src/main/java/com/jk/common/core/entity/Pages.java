package com.jk.common.core.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Dylan Yang
 * @Description: Pages
 * @Title: Pages
 * @ProjectName javayh-oauth2
 * @date 2019/6/18 14:54
 */
@Data
public class Pages {
    /**
     * 当前页
     * M  : pageNum
     */
    private int pageNum;
    /*条数*/
    private int pageSize;
    /*排序*/
    private String orderBy;
    private List<String> orderBys;
}

