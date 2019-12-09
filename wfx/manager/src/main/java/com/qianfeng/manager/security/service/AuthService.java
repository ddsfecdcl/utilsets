package com.qianfeng.manager.security.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean login(String username, String password){
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
