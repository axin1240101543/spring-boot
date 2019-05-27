package com.darren.center.springboot.controller;

import com.darren.center.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        log.info("index --- begin ---");
        request.setAttribute("beetl","官网www.ibeetl.com");
        request.setAttribute("test","springboot 集成 beetl 一起来学呀");
        Map<String, Object> params = new HashMap<>();
        params.put("offset", "0");
        params.put("limit", "10");
        request.setAttribute("users", userService.selectUserList(params));
        log.info("index --- end ---");
        return "index.html";
    }

}
