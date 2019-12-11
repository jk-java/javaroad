package com.jk.gatway.responsedata;

import lombok.Data;

/**
 * @author jk
 * @Date: 2019/12/6
 */
@Data
public class ResponseVo<T> {

    /**
     * 状态码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体的数据.
     */
    private T data;

    public ResponseVo() {
    }


    public ResponseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
