package com.yqj.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Copyright(C),2019-2021,XXX公司
 * FileName: ControllerExceptionHandler
 * Author: yaoqijun
 * Date: 2021/2/24 10:26
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handlerException(RuntimeException e){
        if(e instanceof AccessDeniedException){
            //重定向到静态页面
            return "redirect:/403.html";
        }else {
            return "redirect:/500.html";
        }
    }
}
