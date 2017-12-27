package com.guoyie.www.delivery.easy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.adapter.InfoOrderListAdapter;
import com.guoyie.www.delivery.easy.adapter.RecyclerSearchAdapter;
import com.guoyie.www.delivery.easy.adapter.RetrievalAdapter;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivitySearchBinding;
import com.guoyie.www.delivery.easy.db.HistoricalDB;
import com.guoyie.www.delivery.easy.util.Constant;
import com.guoyie.www.delivery.easy.util.DebugUtil;
import com.guoyie.www.delivery.easy.util.Tools;
import com.guoyie.www.delivery.easy.util.Utils;
import com.guoyie.www.delivery.easy.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/12
 */
public class SeachActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerSearchAdapter adapter;
    private List<String>  list  = new ArrayList<>();// 搜索历史集合
    private AutoCompleteTextView et_content;
    private TextView     tv_cancel;
    private HistoricalDB   historicalDB;
    private RetrievalAdapter  adapt;
    private ActivitySearchBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this,getLayoutId());
        //拿到出来的type值
        final int type = getIntent().getIntExtra(Constant.SEACH_ID, 0);
        historicalDB = new HistoricalDB(this,type);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        et_content = (AutoCompleteTextView) getView(R.id.et_content);
        tv_cancel = (TextView) getView(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);
       /* //自动提示
        et_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapt.getItem(position);
                et_content.setText(item);
                et_content.setSelection(item.length());
                Bundle bundle = new Bundle();
                bundle.putString("ProductName", item);
                startAct(SeachRusltActivity.class, bundle);
                historicalDB.saveHistorical(item);
            }
        });*/

        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        binding.recycleView.setItemAnimator(new DefaultItemAnimator());
        binding.recycleView.addItemDecoration(new RecycleViewDivider(
                mContext, LinearLayoutManager.HORIZONTAL, Utils.dip2px(mContext, 0), ContextCompat.getColor(mContext, R.color.transparent)));
        binding.recycleView.setLayoutManager(manager);
        adapter = new RecyclerSearchAdapter(this, onDeleteData,type);
        adapter.setList(list);
        binding.recycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String keywords = list.get(position);
                et_content.setText(keywords);
                et_content.setSelection(keywords.length());
                if (!Tools.isNull(et_content)) {
                    // 先隐藏键盘
                    hideKeyboard(et_content);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constant.KEYS_WORD, keywords);
                    goTagActivity(bundle, type);

                } else {
                    showToast("请输入搜索关键字~");
                }
            }
        });

        et_content.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String keywords = et_content.getText().toString().trim();
                    if (!Tools.isNull(keywords)) {
                        // 先隐藏键盘
                        hideKeyboard(et_content);
                        Bundle bundle = new Bundle();
                        bundle.putString(Constant.KEYS_WORD, keywords);
                       goTagActivity(bundle,type);
                        historicalDB.saveHistorical(keywords);
                    } else {
                        showToast("请输入搜索关键字~");
                    }
                    return true;
                }
                return false;
            }
        });

    }

    private void goTagActivity(Bundle bundle, int type) {
        switch (type){
            case 1:
                startAct(InterOrderActivity.class,bundle);
                break;
            case 2:
                startAct(OuterOrderActivity.class,bundle);
                break;
            case 3:
                startAct(TransTormorderActivity.class,bundle);
                break;
            case 4:
                startAct(InfoOrderListAdapter.class,bundle);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                closeActivity();
                break;
        }
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                closeActivity();
                return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    private void closeActivity() {
        finish();
        overridePendingTransition(R.anim.fade, R.anim.hold);
    }




    /**
     * 删除记录
     */
    private RecyclerSearchAdapter.onDeleteData onDeleteData = new RecyclerSearchAdapter.onDeleteData() {
        @Override
        public void OnDelete(String title) {
            historicalDB.deleteTitle(title);
            list.remove(title);
            adapter.notifyDataSetChanged();
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        list = historicalDB.selectedHistorical();
        adapter.setList(list);
        adapter.notifyDataSetChanged();
        DebugUtil.i("historical::" + list.size());
    }
}
