package com.jk.mysqlroad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

@EnableCaching
public class MysqlroadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlroadApplication.class, args);
    }

}
