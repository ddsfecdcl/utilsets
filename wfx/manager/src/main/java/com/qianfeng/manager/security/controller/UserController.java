package com.qianfeng.manager.security.controller;

import com.qianfeng.manager.global.entity.JsonResultVo;
import com.qianfeng.manager.security.entity.TreeNode;
import com.qianfeng.manager.security.service.AuthService;
import com.qianfeng.manager.security.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private AuthService authService;
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public JsonResultVo login(String username, String password, Model model){
        if (authService.login(username, password)){
            return JsonResultVo.createSuccessJsonResult(null);
        }else {
            return JsonResultVo.createFailJsonResult("S001001", "用户名或密码错误");
        }
    }

    @ResponseBody
    @RequestMapping("/getTree")
    public JsonResultVo getTree(){
        List<TreeNode> funcTreeByRoleCode = userService.findFuncTreeByRoleCode();
        if (funcTreeByRoleCode != null && funcTreeByRoleCode.size() > 0) {
            return JsonResultVo.createSuccessJsonResult(funcTreeByRoleCode);
        }else {
            return JsonResultVo.createFailJsonResult("S001002", "无法加载权限菜单");
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "/login";
    }
}
