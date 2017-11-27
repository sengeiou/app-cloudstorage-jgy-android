package com.guoyie.www.delivery.easy.base;


import com.guoyie.www.delivery.easy.api.HttpUtils;

import java.io.Serializable;

/**
 * author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.base
 * email：774169396@qq.com
 * data：2017/3/6
 */
public class BaseResponse implements Serializable {
    private String message;
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isOk() {
        return getCode() == HttpUtils.HTTP_RESULT_OK;
    }

    public int getStatusCode() {
        return getCode();
    }
}
