package com.qianfeng.manager.global.entity;




public class JsonResultVo {
    private String code;
    private String desc;
    private Object data;

    private JsonResultVo(){}

    public static JsonResultVo createSuccessJsonResult(Object data){
        JsonResultVo vo = new JsonResultVo();
        vo.code = "10000";
        vo.data = data;
        return vo;
    }

    public static JsonResultVo createFailJsonResult(String code, String desc){
        JsonResultVo vo = new JsonResultVo();
        vo.code = code;
        vo.desc = desc;
        return vo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
