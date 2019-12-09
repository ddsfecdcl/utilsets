package com.qianfeng.manager.global.conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/111")
    public String index(){
        return "/login";
    }




}
