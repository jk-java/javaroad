package com.jk.mysqlroad.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String userPassword;

}
