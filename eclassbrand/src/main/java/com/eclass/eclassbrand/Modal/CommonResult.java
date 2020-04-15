package com.eclass.eclassbrand.Modal;

import java.io.Serializable;

public class CommonResult implements Serializable {


    private static final long serialVersionUID = -6721531401750654362L;
    private int status;//状态码
    private String result;//接口调用结果
    private String msg;//备注信息
    private Object data;//返回数据

    public CommonResult() {
        status=200;
        result="success";
        msg="接口调用成功";
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}