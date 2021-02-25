package com.yqj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: OAuth2ProductApplication
 * Author: yaoqijun
 * Date: 2021/2/25 15:02
 */
@SpringBootApplication
@MapperScan("com.yqj.mapper")
public class OAuth2ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ProductApplication.class,args);
    }
}
