package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.base.BaseResponse;
import com.guoyie.www.delivery.easy.contract.InterOrderDetailContract;
import com.guoyie.www.delivery.easy.databinding.ActivityInterdetailBinding;
import com.guoyie.www.delivery.easy.entity.InputOrderDetailData;
import com.guoyie.www.delivery.easy.model.InputorderDetaliModel;
import com.guoyie.www.delivery.easy.presenter.InputOrderDetaliPresenter;
import com.guoyie.www.delivery.easy.util.BlowfishTools;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.DebugUtil;

import java.util.ArrayList;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/7
 */
public class InterDetailActivity extends BaseActivity<InputOrderDetaliPresenter,InputorderDetaliModel> implements View.OnClickListener, InterOrderDetailContract.View {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    private ActivityInterdetailBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_interdetail;
    }


    @Override
    public void initPresenter() {
        mPresenter.attachVM(this,mModel);

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back =  getView(R.id.left_back);
        binding.tvRefused.setOnClickListener(this);
        binding.tvAgree.setOnClickListener(this);
        mLeft_back.setOnClickListener(this);
        mTv_title =  getView(R.id.tv_title);
        mTv_title.setText("入库单详情");
        //从上个页面传回来的数据
        String id = getIntent().getStringExtra(Constant.INPUT_ORDER_ID);
        loadData(id);

        ArrayList<BaseResponse> list=new ArrayList<>();
        for (int i = 0; i <1 ; i++) {
            BaseResponse bs=new BaseResponse();
            bs.setCode(i);
            bs.setMessage("heheheh"+i);
            list.add(bs);
        }


        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.griditem, null, false);
            TextView  tv_type=  view.findViewById(R.id.tv_type);
            TextView  tv_rmark=  view.findViewById(R.id.tv_rmark);
            tv_type.setText(list.get(i).getCode()+"");
            tv_rmark.setText(list.get(i).getMessage());
            binding.gridLayout.addView(view);



        }



    }

    private void loadData(String id) {
        String params = BlowfishTools.encrypt(HttpUtils.key, HttpUtils.INTER_ORDER_DETAIL + "&id=" + id);
        mPresenter.requstInterOrderDetail(params);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left_back:
                finish();
                break;
            case R.id.tv_refused:
            //调到编辑详情页面
             startAct(EditOrderDetailActivity.class);
                break;
            case R.id.tv_agree:
                //调到订单编辑页面
                startAct(EditOrderActivity.class);
                break;

        }



    }

    @Override
    public void returnInterOrderDetailData(InputOrderDetailData data) {
        DebugUtil.debug(data.getData()+"");

    }

    @Override
    public void error(String msg) {

    }
}
