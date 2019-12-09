package com.qianfeng.manager.security.entity;

import java.util.List;


public class TreeNode {
    private String code;
    private String name;
    private String url;
    private List<ChildNode> childNodeList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ChildNode> getChildNodeList() {
        return childNodeList;
    }

    public void setChildNodeList(List<ChildNode> childNodeList) {
        this.childNodeList = childNodeList;
    }
}
