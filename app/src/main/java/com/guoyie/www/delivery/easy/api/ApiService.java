package com.guoyie.www.delivery.easy.api;

import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.entity.CapacityGoodsNameBean;
import com.guoyie.www.delivery.easy.entity.CapacityStoreNumberBean;
import com.guoyie.www.delivery.easy.entity.GetTime;
import com.guoyie.www.delivery.easy.entity.GoodsNameBean;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;
import com.guoyie.www.delivery.easy.entity.InputOrderInfoData;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetailData;
import com.guoyie.www.delivery.easy.entity.OuterOrderInfoData;
import com.guoyie.www.delivery.easy.entity.RegisterData;
import com.guoyie.www.delivery.easy.entity.StorageData;
import com.guoyie.www.delivery.easy.entity.StorageInfoData;
import com.guoyie.www.delivery.easy.entity.StoreCapacityListBean;
import com.guoyie.www.delivery.easy.entity.StoreDetailBean;
import com.guoyie.www.delivery.easy.entity.StoreManagerListBean;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.StoreTypeBean;
import com.guoyie.www.delivery.easy.entity.TransstockData;
import com.guoyie.www.delivery.easy.entity.TransstockDetailData;
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
    //储罐详情的接口
    @GET("model=stock&action=jarinfo")
    Observable<StoreDetailBean> getStoreDetail(@Query("params") String params);
    //获取库容管理列表的接口
    @GET("model=stock&action=stocklist")
    Observable<StoreCapacityListBean> getStoreCapacityList(@Query("params") String params);
    //货权转移列表的接口
     @GET(HttpUtils.TRANSSTOCK_LSIT)
    Observable<TransstockData>getTransstockListData(@Query("params") String params);
    //货转单单详情的接口
    @GET(HttpUtils.TRANSSTOCK_DETAIL)
    Observable<TransstockDetailData>getTransstockDetailData(@Query("params") String params);
    //货权转移的通过或者拒绝的接口
    @GET(HttpUtils.TRANSSTOCK_UPDATE)
    Observable<BaseResponse>getTransstockUpdate(@Query("params") String params);
    //库容管理筛选，获取商品名列表
    @GET("model=stock&action=searchgoodsname")
    Observable<CapacityGoodsNameBean> getCapacityGoodsNameList(@Query("params") String params);
    //库容管理筛选，获取储罐号
    @GET("model=stock&action=searchstockno")
    Observable<CapacityStoreNumberBean> getCapacityStoreNumber(@Query("params") String params);
    //储罐筛选，获取储罐号
    @GET("model=stock&action=distinctlist")
    Observable<StoreNumberBean> getStoreNumber(@Query("params") String params);
    //储罐筛选，获取商品名
    @GET("model=stock&action=distinctlist")
    Observable<GoodsNameBean> getStoreName(@Query("params") String params);
    //储罐筛选，获取储罐性质
    @GET("model=stock&action=distinctlist")
    Observable<StoreTypeBean> getStoreType(@Query("params") String params);
}
