package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityEditorderdetailBinding;
import com.guoyie.www.delivery.easy.util.PopDateHelper;
import com.guoyie.www.delivery.easy.util.PopOneHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/8
 */
public class EditOrderDetailActivity extends BaseActivity implements View.OnClickListener, PopOneHelper.OnClickOkListener, PopDateHelper.OnClickOkListener {
    private ImageView mLeft_back;
    private TextView  mTv_title;
    private ActivityEditorderdetailBinding binding;
    private PopOneHelper oneHelper;
    private PopDateHelper dateHelper;
    List<String>nums=new ArrayList<>();
    List<String>goods=new ArrayList<>();

    private int type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_editorderdetail;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this,getLayoutId());
        mLeft_back = (ImageView) getView(R.id.left_back);

        mLeft_back.setOnClickListener(this);
        binding.llIntertime.setOnClickListener(this);

        binding.llGoogsxingzhi.setOnClickListener(this);
        binding.llGuanNum.setOnClickListener(this);

        mTv_title = (TextView) getView(R.id.tv_title);
        mTv_title.setText("编辑入库明细单");

        nums.add("1号罐");
        nums.add("2号罐");
        nums.add("3号罐");
        nums.add("4号罐");

        goods.add("进口");
        goods.add("一般");
        goods.add("去口");
        goods.add("走势");
        goods.add("好货");
        goods.add("垃圾");


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

            case R.id.ll_googsxingzhi:
                type = 1;
                oneHelper.setListData(goods);
                oneHelper.show(view);
              break;
            case R.id.ll_guan_num:
                type = 2;
                oneHelper.setListData(nums);
                oneHelper.show(view);
                break;


        }

    }

    @Override
    public void onClickOk(String birthday, int position) {
      switch (type){
          case 1:
              binding.tvGoonsxinzhi.setText(birthday);
              break;
          case 2:
              binding.tvGuannum.setText(birthday);
              break;
      }
    }

    @Override
    public void onClickOk(String birthday) {
        binding.tvTime.setText(birthday);

    }
}
