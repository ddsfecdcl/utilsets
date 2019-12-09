package com.qianfeng.manager.security.config;

import com.qianfeng.manager.security.entity.UserInfo;
import com.qianfeng.manager.security.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm{
    @Resource
    private UserService userService;

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 得到当前登录的主用户
            UserInfo users = (UserInfo) principals.getPrimaryPrincipal();
            // 得到用户角色
            HashSet<String> roles = new HashSet<String>();
            roles.add(users.getRole().getName());
            info.setRoles(roles);
            // 得到用户权限
            List<String> authnameList = userService.findFuncByRoleCode(users.getRole().getCode());
            info.setStringPermissions(new HashSet<String>(authnameList));
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 将token强转成用户名密码方式
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        char[] password = token1.getPassword();
        String pwd = new String(password);
        UserInfo users = userService.login(username, pwd);
        if (users == null){
            return null;
        }else {
            return new SimpleAuthenticationInfo(users, pwd, getName());
        }
    }
}
