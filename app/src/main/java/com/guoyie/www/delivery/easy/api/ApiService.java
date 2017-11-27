package com.guoyie.www.delivery.easy.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {
    //首页的列表数据
    @GET("model=home&action=homepage")
    Observable<Object> getHomePageList(@Query("params") String params);

}
