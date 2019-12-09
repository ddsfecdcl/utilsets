package com.qianfeng.manager.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @Resource
    TestService testService;
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/home")
    public String home(){
        return "/home";
    }

    @RequestMapping("/test")
    public String test(Model model){
        List<Books> books = testService.getBooks();

        model.addAttribute("books",books);
        return "/destop";
    }

}
