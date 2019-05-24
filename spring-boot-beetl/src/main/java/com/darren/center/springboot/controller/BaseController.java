package com.darren.center.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class BaseController {

    @GetMapping("/")
    public String index(HttpServletRequest request){
        log.info("index --- begin ---");
        request.setAttribute("beetl","官网www.ibeetl.com");
        request.setAttribute("test","springboot 集成 beetl 一起来学呀");
        log.info("index --- end ---");
        return "index.btl";
    }

}
