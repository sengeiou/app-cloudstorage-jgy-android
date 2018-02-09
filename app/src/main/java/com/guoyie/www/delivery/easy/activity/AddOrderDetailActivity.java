package com.guoyie.www.delivery.easy.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.AddOrderDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityEditorderdetailBinding;
import com.guoyie.www.delivery.easy.entity.InputOrderDetail;
import com.guoyie.www.delivery.easy.entity.OuterOrderDetail;
import com.guoyie.www.delivery.easy.entity.StoreNumberBean;
import com.guoyie.www.delivery.easy.entity.UserInfoData;
import com.guoyie.www.delivery.easy.model.AddOrderDetailModel;
import com.guoyie.www.delivery.easy.presenter.AddOrderPresenter;
import com.guoyie.www.delivery.easy.toast.T;
import com.guoyie.www.delivery.easy.util.ACache;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.DebugUtil;
import com.guoyie.www.delivery.easy.util.PopDateHelper;
import com.guoyie.www.delivery.easy.util.PopOneHelper;
import com.guoyie.www.delivery.easy.util.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/8
 */
public class AddOrderDetailActivity extends BaseActivity<AddOrderPresenter,AddOrderDetailModel> implements View.OnClickListener, PopOneHelper.OnClickOkListener, PopDateHelper.OnClickOkListener, AddOrderDetailContract.View {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    private ActivityEditorderdetailBinding binding;
    private PopOneHelper oneHelper;
    private PopDateHelper dateHelper;
    private int              mType;
    private InputOrderDetail mInputOrderDetail;
    private OuterOrderDetail mOuterOrderDetail;
    private ACache mACache=ACache.get(mContext);//拿到缓冲的对象
    private UserInfoData mInfo;
    //放储罐号
    private  List<String>nums=new ArrayList<>();



    @Override
    public int getLayoutId() {
        return R.layout.activity_editorderdetail;
    }

    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back =  getView(R.id.left_back);

        mLeft_back.setOnClickListener(this);
        binding.llIntertime.setOnClickListener(this);

        binding.llGoogsxingzhi.setOnClickListener(this);
        binding.llGuanNum.setOnClickListener(this);
        mTv_title =  getView(R.id.tv_title);
        //在这里做缓冲数据的处理
        String cacheJson = mACache.getAsString(Constant.ACHEA_STORE_NUMBER);
        DebugUtil.i("cache json str::" + cacheJson);
        mInfo = (UserInfoData) GApp.getInstance().readObject(Constant.USER_INFO_CACHE);
        if (Tools.isNull(cacheJson)) {
            String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.STORE_FILTER +
                    "&vendor_no=" + mInfo.getData().getInfo().getVendor_no()+
                    "&type=jar_no");
            mPresenter.requestStoreNumber(params);
        } else {
            nums = JSON.parseArray(cacheJson, String.class);

        }


          binding.tvCommit.setOnClickListener(this);
        //拿到点击时候的传递的type只
        Intent intent = getIntent();
        //type=1,是入库单处理的逻辑 2是出库单的逻辑
        mType = intent.getIntExtra(Constant.STOCK_TYPE, 0);
        switch (mType){
            case 1:
                mInputOrderDetail = (InputOrderDetail) intent.getSerializableExtra(Constant.INPUT_EDIT_ORDER);
                break;
            case 2:
                mOuterOrderDetail = (OuterOrderDetail) intent.getSerializableExtra(Constant.OUTER_EDIT_ORDER);
                binding.llLoseQty.setVisibility(View.VISIBLE);
                break;
        }

        initData(mType);

    }

    private void initData(int type) {
        switch (type){
            case 1://添加入库的逻辑
                mTv_title.setText("添加入库明细单");//标题
                binding.goodsName.setText(mInputOrderDetail.getGoods_name());//商品名臣
                binding.orderQty.setText(mInputOrderDetail.getOrder_qty()+mInputOrderDetail.getGoods_unit());//入库数量和单位
                binding.goodsNature.setText(mInputOrderDetail.getGoods_nature());//货物性质写死的
                break;
            case 2://添加出库明细
                mTv_title.setText("添加出库明细单");//标题
                binding.goodsName.setText(mOuterOrderDetail.getGoods_name());//商品名臣
                binding.orderQty.setText(mOuterOrderDetail.getOrder_qty()+mOuterOrderDetail.getGoods_unit());//入库数量和单位
                binding.goodsNature.setText(mOuterOrderDetail.getGoods_nature());//货物性质写死的
                binding.tvTitleNum.setText("预约出库数量/单位");//预约数量的修改
                binding.tvStockTime.setText("出库时间");//出库时间
                binding.tvStockOrderNum.setText("出库单号");//出库单号
                binding.tvStockNum.setText("出库数量");

                break;
        }

    }

    @Override
    public void onClick(View view) {
        oneHelper = new PopOneHelper(this);
            dateHelper = new PopDateHelper(this);
            dateHelper.setObsolete(true);
        oneHelper.setOnClickOkListener(this);
        dateHelper.setOnClickOkListener(this);
        switch (view.getId()){
            case  R.id.left_back:
                finish();
                break;
            case R.id.ll_intertime:
                dateHelper.show(view);
                break;
            case R.id.ll_guan_num:
                oneHelper.setListData(nums);
                oneHelper.show(view);
                break;
            case R.id.tv_commit:
                //用于提交数据防止多次提交
                if (isFastDoubleClick()) {
                    return;
                }

                String instockDate = binding.instockDate.getText().toString().trim();//时间
                String instockDetailNo = binding.instockDetailNo.getText().toString().trim();//入库单号
                String jarNo = binding.jarNo.getText().toString().trim();//选择罐号
                String stockQty = binding.stockQty.getText().toString().trim();//入库数量
                String number = binding.number.getText().toString().trim();//船编号
                String lose_qty = binding.loseQty.getText().toString().trim();//耗损量
                String etRemark = binding.etRemark.getText().toString().trim();//备注
                    if (instockDate.equals("请选择时间")) {
                        T.showAnimToast(mContext, "请选择时间");
                    } else if (Tools.isNull(instockDetailNo)) {
                        T.showAnimToast(mContext, "请输入单号");
                    } else if (jarNo.equals("请选择罐号")) {
                        T.showAnimToast(mContext, "请选择罐号");
                    }else if (Tools.isNull(stockQty)) {
                        T.showAnimToast(mContext, "请输入库数量");
                    }else if (Tools.isNull(number)) {
                        T.showAnimToast(mContext, "请输入车牌号/船舶编号");
                    }else if (mType==2&&Tools.isNull(lose_qty)){
                        T.showAnimToast(mContext, "请输入耗损量");
                    }else {

                        switch (mType){
                            case 1://添加入库明细的接口啊
                                String params1=BlowfishTools.encrypt(HttpUtils.key,HttpUtils.INTER_ORDER_ADDSTOCK+"&instock_id="+mInputOrderDetail.getId()
                                +"&instock_detail_no="+instockDetailNo+"&instock_date="+instockDate+"&goods_id="+mInputOrderDetail.getGoods_id()+"&goods_name="+mInputOrderDetail.getGoods_name()
                                +"&goods_unit="+mInputOrderDetail.getGoods_unit()+"&goods_nature="+mInputOrderDetail.getGoods_nature()+"&stock_qty="+stockQty
                                +"&number="+number+"&jar_no="+jarNo+"&remark="+etRemark);
                                mPresenter.requstAddStcokInter(params1);
                                break;

                            case 2://添加出库明细的接口
                                String params2=BlowfishTools.encrypt(HttpUtils.key,HttpUtils.OUTER_ORDER_ADDSTOCK+"&outstock_id="+mOuterOrderDetail.getId()
                                        +"&outstock_detail_no="+instockDetailNo+"&outstock_date="+instockDate+"&goods_id="+mOuterOrderDetail.getGoods_id()+"&goods_name="+mOuterOrderDetail.getGoods_name()
                                        +"&goods_unit="+mOuterOrderDetail.getGoods_unit()+"&goods_nature="+mOuterOrderDetail.getGoods_nature()+"&stock_qty="+stockQty+"&lose_qty="+lose_qty
                                        +"&number="+number+"&jar_no="+jarNo+"&remark="+etRemark);
                                mPresenter.requstAddStcokOuter(params2);
                                break;



                        }

                }

            break;
            }


    }

    @Override
    public void onClickOk(String birthday, int position) {
        binding.jarNo.setText(birthday);

    }

    @Override
    public void onClickOk(String birthday) {
        String[] split = birthday.split("-");
        if(split[1].length()==1){
            split[1]=0+split[1];
        }

        if(split[2].length()==1){
            split[2]=0+split[2];
        }
        //对数据进行重新排列设置
        birthday=split[0]+"-"+split[1]+"-"+split[2];
        binding.instockDate.setText(birthday);

    }

    @Override
    public void returnAddStcokInter(BaseResponse data) {
        if (data.isOk()){
            showToast(data.getMsg());
            finish();
        }

    }

    @Override
    public void returnAddStcokOuter(BaseResponse data) {
        if (data.isOk()){
            showToast(data.getMsg());
            finish();
        }


    }

    @Override
    public void returnStoreNumber(StoreNumberBean storeNumberBean) {
        if (storeNumberBean.isOk()){
            List<StoreNumberBean.DataBean> data = storeNumberBean.getData();
            for (int i = 0; i < data.size(); i++) {
                 nums.add(data.get(i).getJar_no());
            }

            if (nums!=null){
                mACache.put(Constant.ACHEA_STORE_NUMBER, JSON.toJSONString(nums), 1800);
            }

        }

    }

    @Override
    public void error(String msg) {
        showToast(msg);

    }
}
