package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/23
 */

public class CapacityStoreNumberBean extends BaseResponse{

    /**
     * code : 200
     * msg : 储罐号列表
     * data : [{"stock_no":"CGH00000001"},{"stock_no":"CGH0000002"},{"stock_no":"adasd2312"},{"stock_no":"520"},{"stock_no":"93950"},{"stock_no":"123123"},{"stock_no":"5555"},{"stock_no":"1314"},{"stock_no":"900"},{"stock_no":"147"},{"stock_no":"24680"},{"stock_no":"888"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * stock_no : CGH00000001
         */

        private String stock_no;

        public String getStock_no() {
            return stock_no;
        }

        public void setStock_no(String stock_no) {
            this.stock_no = stock_no;
        }
    }
}
