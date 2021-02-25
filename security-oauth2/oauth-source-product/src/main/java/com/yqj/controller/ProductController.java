package com.yqj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: ProductController
 * Author: yaoqijun
 * Date: 2021/2/25 15:03
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/findAll")
    public String findAll(){
        return "success findAll...";
    }
}
