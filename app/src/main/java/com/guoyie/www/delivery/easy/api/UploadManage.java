package com.guoyie.www.delivery.easy.api;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 *  author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.api
 * email：774169396@qq.com
 * data：2017/4/21
 */

public class UploadManage {
    /**
     * 图文一起上传
     *
     * @param params 参数
     * @param maps   File集合
     * @return
     */
    public static Map<String, RequestBody> HandleImg(String params, HashMap<String, File> maps) {
        Map<String, RequestBody> bodyMap = new HashMap<>();
        Set set = maps.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            File file = maps.get(key);
            if (file == null) {
                continue;
            }
            // key 上传指定key,filename 文件名, 指定图片类型,file 上传文件
            bodyMap.put(key + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/png"), file));
        }
        bodyMap.put("params", ApiConstants.toRequestBody(params));
        return bodyMap;
    }
}
