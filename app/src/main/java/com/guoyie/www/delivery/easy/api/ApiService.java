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

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;



public interface ApiService {
    //获取服务器时间的接口
    @GET("?")
    Observable<GetTime> getTime(@Query("params") String params);
     //登录的接口
     @GET("?")
    Observable<UserInfoData> getLogin(@Query("params") String params);
    //加盟商入驻的接口
    @GET("?")
    Observable<RegisterData> getRegister(@Query("params") String params);
    //获取入库单列表的接口
    @GET("?")
    Observable<InputOrderInfoData> getInputOrderData(@Query("params") String params);
    //获取入库单详情的接口接口
    @GET("?")
    Observable<InputOrderDetailData> getInputOrderDetaliData(@Query("params") String params);
    //获取入库单详情审核接口
    @GET("?")
    Observable<BaseResponse> getInputOrderDetaliUpdate(@Query("params") String params);

    //获取出库单列表的接口
    @GET("?")
    Observable<OuterOrderInfoData> getOuterOrderData(@Query("params") String params);
    //获取出库单详情的接口接口
    @GET("?")
    Observable<OuterOrderDetailData> getOuterOrderDetaliData(@Query("params") String params);
    @GET("?")
    Observable<BaseResponse> getOuterOrderDetaliUpdate(@Query("params") String params);
    //获取储罐管理列表的接口
    @GET("?")
    Observable<StoreManagerListBean> getStoreManagerList(@Query("params") String params);
    //意向单列表的接口
    @GET("?")
    Observable<StorageData>getStorageData(@Query("params") String params);
    //意向单详情的接口
    @GET("?")
    Observable<StorageInfoData>getStorageInfoData(@Query("params") String params);
    //储罐详情的接口
    @GET("?")
    Observable<StoreDetailBean> getStoreDetail(@Query("params") String params);
    //获取库容管理列表的接口
    @GET("?")
    Observable<StoreCapacityListBean> getStoreCapacityList(@Query("params") String params);
    //货权转移列表的接口
    @GET("?")
    Observable<TransstockData>getTransstockListData(@Query("params") String params);
    //货转单单详情的接口
    @GET("?")
    Observable<TransstockDetailData>getTransstockDetailData(@Query("params") String params);
    //货权转移的通过或者拒绝的接口
    @GET("?")
    Observable<BaseResponse>getTransstockUpdate(@Query("params") String params);
    //库容管理筛选，获取商品名列表
    @GET("?")
    Observable<CapacityGoodsNameBean> getCapacityGoodsNameList(@Query("params") String params);
    //库容管理筛选，获取储罐号
    @GET("?")
    Observable<CapacityStoreNumberBean> getCapacityStoreNumber(@Query("params") String params);
    //储罐筛选，获取储罐号
    @GET("?")
    Observable<StoreNumberBean> getStoreNumber(@Query("params") String params);
    //储罐筛选，获取商品名
    @GET("?")
    Observable<GoodsNameBean> getStoreName(@Query("params") String params);
    //储罐筛选，获取储罐性质
    @GET("?")
    Observable<StoreTypeBean> getStoreType(@Query("params") String params);

    //编辑出入库确认单入库接口以及图片上传的问
    @GET("?")
    Observable<BaseResponse> getEditInter(@Query("params") String params);//入库
    @GET("?")
    Observable<BaseResponse> getEditOuter(@Query("params") String params);//出库
    @Multipart
    @POST("?")
    Observable<BaseResponse> upLoadFile(@PartMap Map<String, RequestBody> params);//上传图片
    //编辑出入库明细的接口
    @GET("?")
    Observable<BaseResponse> getAddInter(@Query("params") String params);//入库
    @GET("?")
    Observable<BaseResponse> getAddOuter(@Query("params") String params);//出库
    //完成入库的接口
    @GET("?")
    Observable<BaseResponse>getOrderHandle(@Query("params") String params);//完成入库





}
