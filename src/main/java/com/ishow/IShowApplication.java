package com.ishow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaohaojie
 * @date 2019-10-20 1:25
 */
@SpringBootApplication
@MapperScan("com.ishow.mysql.mapper")
public class IShowApplication {
    public static void main(String[] args) {
        SpringApplication.run(IShowApplication.class,args);
    }
}

