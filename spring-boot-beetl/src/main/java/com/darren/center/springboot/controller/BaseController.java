package com.darren.center.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("a", "123456");
        return "index";
    }

}
