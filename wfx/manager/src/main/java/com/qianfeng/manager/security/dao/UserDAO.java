package com.qianfeng.manager.security.dao;

import com.qianfeng.manager.security.entity.ChildNode;
import com.qianfeng.manager.security.entity.TreeNode;
import com.qianfeng.manager.security.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    UserInfo findByAccountAndPassword(@Param("account") String account, @Param("password") String password);
    List<String> findFuncByRoleCode(String code);
    List<TreeNode> findFuncTreeByRoleCode(String code);
    List<ChildNode> findChildNodeByModuleCodeAndRoleCode(@Param("moduleCode")String moduleCode, @Param("roleCode") String roleCode);
}