package com.guoyie.www.delivery.easy.entity;

import com.guoyie.www.delivery.easy.base.BaseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.entity
 * email：1649369473@qq.com
 * data：2017/12/25
 *
 * 储罐筛选，储罐号
 */

public class StoreNumberBean extends BaseResponse{

    /**
     * code : 200
     * msg : 获取条件成功
     * data : [{"jar_no":"adasd2312"},{"jar_no":"666"},{"jar_no":"888"},{"jar_no":"777"},{"jar_no":"123"},{"jar_no":"555"},{"jar_no":"520"},{"jar_no":"93950"},{"jar_no":"5201"},{"jar_no":"321"},{"jar_no":"654"},{"jar_no":"852"},{"jar_no":"258"},{"jar_no":"24680"},{"jar_no":"147"},{"jar_no":"1314"},{"jar_no":"5555"},{"jar_no":"369"},{"jar_no":"680"},{"jar_no":"987"},{"jar_no":"900"},{"jar_no":"56568978444444444444444dfdf4df"},{"jar_no":"66658"},{"jar_no":"123123"},{"jar_no":"12223213"}]
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

    public static class DataBean implements Serializable {
        /**
         * jar_no : adasd2312
         */

        private String jar_no;

        public String getJar_no() {
            return jar_no;
        }

        public void setJar_no(String jar_no) {
            this.jar_no = jar_no;
        }
    }
}
