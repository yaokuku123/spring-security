package com.yqj;

import com.yqj.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: AuthProductApplication
 * Author: yaoqijun
 * Date: 2021/2/25 11:05
 */
@SpringBootApplication
@MapperScan("com.yqj.mapper")
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AuthProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthProductApplication.class,args);
    }
}
