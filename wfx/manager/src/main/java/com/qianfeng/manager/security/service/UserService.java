package com.qianfeng.manager.security.service;

import com.qianfeng.manager.security.dao.UserDAO;
import com.qianfeng.manager.security.entity.ChildNode;
import com.qianfeng.manager.security.entity.TreeNode;
import com.qianfeng.manager.security.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDAO userDAO;

    public UserInfo login(String account, String password){
        return userDAO.findByAccountAndPassword(account, password);
    }

    public List<String> findFuncByRoleCode(String code){
        return userDAO.findFuncByRoleCode(code);
    }

    public List<TreeNode> findFuncTreeByRoleCode(){
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        String code = userInfo.getRole().getCode();
        List<TreeNode> funcTreeByRoleCode = userDAO.findFuncTreeByRoleCode(code);
        for (TreeNode treeNode : funcTreeByRoleCode) {
            List<ChildNode> childNodes = userDAO.findChildNodeByModuleCodeAndRoleCode(treeNode.getCode(), code);
            treeNode.setChildNodeList(childNodes);
        }
        return funcTreeByRoleCode;
    }
}
