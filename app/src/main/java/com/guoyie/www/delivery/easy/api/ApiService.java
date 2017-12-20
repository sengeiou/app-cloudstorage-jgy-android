package com.guoyie.www.delivery.easy.api;

import com.guoyie.www.delivery.easy.entity.GetTime;
import com.guoyie.www.delivery.easy.entity.OrderInfoData;
import com.guoyie.www.delivery.easy.entity.UserInfoData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiService {
    //获取服务器时间的接口
    @GET("model=index&action=gettime")
    Observable<GetTime> getTime(@Query("params") String params);
     //登录的接口
    @GET("model=login&action=login")
    Observable<UserInfoData> getLogin(@Query("params") String params);
    //获取入库单列表的接口
    @GET("model=warehouse&action=list")
    Observable<OrderInfoData> getInputOrderData(@Query("params") String params);

}
