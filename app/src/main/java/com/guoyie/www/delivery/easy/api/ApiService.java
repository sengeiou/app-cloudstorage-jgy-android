package com.guoyie.www.delivery.easy.api;

import com.guoyie.www.delivery.easy.entity.GetTime;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    //获取服务器时间的接口
    @GET("model=index&action=gettime")
    Observable<GetTime> getTime(@Query("params") String params);

}
