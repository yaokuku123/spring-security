package com.yqj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: SecurityApplication
 * Author: yaoqijun
 * Date: 2021/2/24 10:13
 */
@SpringBootApplication
@MapperScan("com.yqj.mapper")
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }
}
