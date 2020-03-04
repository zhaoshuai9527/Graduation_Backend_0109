package com.common.Response;

public class ResponseInfo {
    private Object body;
    private String code = "1";
    private String desc = "";

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
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



    public ResponseInfo(String code,String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public ResponseInfo(Object obj)
    {
        this.code = "1";
        this.body = obj;
    }

    public ResponseInfo(String code,String desc,Object obj)
    {
        this.code = code;
        this.desc = desc;
        this.body = obj;
    }

    public static ResponseInfo ok(Object obj)
    {
        return new ResponseInfo(obj);
    }

    public static ResponseInfo error(String desc)
    {
        return new ResponseInfo("0",desc);
    }


    public static ResponseInfo create(String code,String desc,Object obj)
    {
        return new ResponseInfo(code,desc,obj);
    }


}
