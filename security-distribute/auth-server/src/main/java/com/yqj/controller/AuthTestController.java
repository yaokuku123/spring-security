package com.yqj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: AuthTestController
 * Author: yaoqijun
 * Date: 2021/2/25 10:46
 */
@RestController
@RequestMapping("/user")
public class AuthTestController {

    @GetMapping("/findAllTest")
    public String findAllTest(){
        return "success findAllTest...";
    }
}
