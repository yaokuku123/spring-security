package com.yqj.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: SecurityController
 * Author: yaoqijun
 * Date: 2021/2/24 10:20
 */
@Controller
public class SecurityController {

    @RequestMapping("/")
    public String login() {
        return "index";
    }

    @Secured("ROLE_PRODUCT")
    @RequestMapping("/product")
    public String product() {
        return "product";
    }

    @Secured("ROLE_ORDER")
    @RequestMapping("/order")
    public String learning() {
        return "order";
    }

}
