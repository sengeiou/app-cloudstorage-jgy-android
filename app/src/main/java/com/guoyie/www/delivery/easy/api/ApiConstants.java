/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.guoyie.www.delivery.easy.api;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ApiConstants {

 //   public static final String BASE_HOST = "http://wms.api.app.chinayie.com/";//正式服务器的地址
   // public static final String BASE_HOST = "http://app.api.yc.dev.chinayie.net/";//测试地址
    //public static final String BASE_HOST = "http://app.api.yc.sit.chinayie.net/";//测试地址
    public static final String BASE_HOST = "http://app.api.yc.uat.chinayie.net/";



    /**
     * 处理图片和String参数一起上传 字符串转换问题
     *
     * @param value
     * @return
     */
    public static RequestBody toRequestBody(String value) {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body;
    }
}
