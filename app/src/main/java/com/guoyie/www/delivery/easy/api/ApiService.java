package com.guoyie.www.delivery.easy.api;

import com.guoyie.www.delivery.easy.entity.GetTime;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetailData;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.RegisterData;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.StorageInfoData;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface ApiService {
    //获取服务器时间的接口
    @GET(HttpUtils.GET_TIME)
    Observable<GetTime> getTime(@Query("params") String params);
     //登录的接口
    @GET(HttpUtils.LOG_IN)
    Observable<UserInfoData> getLogin(@Query("params") String params);
    //加盟商入驻的接口
    @GET(HttpUtils.RE_GISTER)
    Observable<RegisterData> getRegister(@Query("params") String params);
    //获取入库单列表的接口
    @GET(HttpUtils.INTER_ORDER_LIST)
    Observable<InputOrderInfoData> getInputOrderData(@Query("params") String params);
    //获取入库单详情的接口接口
    @GET(HttpUtils.INTER_ORDER_DETAIL)
    Observable<InputOrderDetailData> getInputOrderDetaliData(@Query("params") String params);

    //获取出库单列表的接口
    @GET(HttpUtils.OUTER_ORDER_LIST)
    Observable<OuterOrderInfoData> getOuterOrderData(@Query("params") String params);
    //获取出库单详情的接口接口
    @GET(HttpUtils.OUTER_ORDER_DETAIL)
    Observable<OuterOrderDetailData> getOuterOrderDetaliData(@Query("params") String params);
    //获取储罐管理列表的接口
    @GET(HttpUtils.STORE_MANAGER_LIST)
    Observable<StoreManagerListBean> getStoreManagerList(@Query("params") String params);
    //意向单列表的接口
    @GET(HttpUtils.INFO_STORAGE)
    Observable<StorageData>getStorageData(@Query("params") String params);
    //意向单详情的接口
    @GET(HttpUtils.INFO_STORAGE_DETALI)
    Observable<StorageInfoData>getStorageInfoData(@Query("params") String params);

}
