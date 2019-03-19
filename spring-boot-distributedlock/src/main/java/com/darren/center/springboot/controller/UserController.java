package com.darren.center.springboot.controller;

import com.darren.center.springboot.entity.User;
import com.darren.center.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class UserController extends BaseController{

    @Autowired
    private UserService helloService;

    @GetMapping("/index")
    public String user(){
        return "redirect:/getUserList";
    }


    @GetMapping("/getUserList")
    public String getUserList(Model model){
        List<User> users = helloService.selectUserList();
        model.addAttribute("users", users);
        return "user/user";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(Long id){
        helloService.deleteUserById(id);
        return "redirect:/getUserList";
    }

    @GetMapping("/toAddUser")
    public String toAddUser(){
        return "user/add";
    }

    @GetMapping("/addUser")
    public String addUser(User user){
        helloService.addUser(user);
        return "redirect:/getUserList";
    }

    @GetMapping("/toEditUser")
    public String toEditUser(Model model, Long id){
        model.addAttribute("id", id);
        return "user/edit";
    }

    @GetMapping("/editUser")
    public String editUser(User user){
        helloService.editUserById(user);
        return "redirect:/getUserList";
    }

}
