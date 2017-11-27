package com.guoyie.www.delivery.easy.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.retrofit.RxManager;
import com.guoyie.www.delivery.easy.util.TUtil;


/**
 * author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.base
 * email：774169396@qq.com
 * data：2017/3/6
 */
public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {
    protected View               rootView;
    public    T                  mPresenter;
    public    E                  mModel;
    public    RxManager          mRxManager;
    protected Context            mContext;
    protected InputMethodManager manager;
  //  protected ACache aCache;

    protected <T extends View> T getView(int id) {
        return (T) rootView.findViewById(id);
    }

    /*protected UserInfo userInfo;
    protected String uid = "";
    protected String company_id = "";
    protected int role;*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null)
            rootView = inflater.inflate(getLayoutResource(), container, false);

        mContext = getActivity();
     //   aCache = ACache.get(getActivity());
        manager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mRxManager = new RxManager();
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        initPresenter();
        initView();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mContext = getActivity();
      //  aCache = ACache.get(getActivity());
        manager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    //获取布局文件
    protected abstract int getLayoutResource();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    protected abstract void initView();

    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 防止连续点击跳转两个页面
     */
    protected long lastClickTime;

    protected boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * @param clz
     * @return void 返回类型
     * @Title: startActivity
     * @Description: 进入到下个activity
     * @author luck
     */
    protected void startAct(Class clz) {
        if (isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(mContext, clz);
        startActivity(intent);
    }

    /**
     * @param clz
     * @return void 返回类型
     * @Title: startActivity
     * @Description: 进入到下个activity
     * @author luck
     */
    protected void startAct(Class clz, Bundle bundle) {
        if (isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * @param clz
     * @return void 返回类型
     * @Title: startActivity
     * @Description: 进入到下个activity, 并关闭当前Activity
     * @author luck
     */
    protected void startFinishAct(Class clz, Bundle bundle) {
        if (isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(getActivity(), clz);
        intent.putExtras(bundle);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * @param clz
     * @return void 返回类型
     * @Title: startActivity
     * @Description: 进入到下个activity 带动画
     * @author luck
     */
    protected void startAnimAct(Class clz, int enterAnim, int exitAnim) {
        if (isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(mContext, clz);
        startActivity(intent);
        getActivity().overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * @param clz
     * @return void 返回类型
     * @Title: startActivity
     * @Description: 进入到下个activity 带动画
     * @author luck
     */
    protected void startAnimFinishAct(Class clz, int enterAnim, int exitAnim) {
        if (isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(mContext, clz);
        startActivity(intent);
        getActivity().overridePendingTransition(enterAnim, exitAnim);
        getActivity().finish();
    }

    /**
     * 隐藏软键盘
     */
    protected void hideKeyboard(EditText editText) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /**
     * 显示软键盘
     */
    protected void showKeyboard(EditText editText) {
        if (getActivity().getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getActivity().getCurrentFocus() != null)
                manager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.onDestroy();
        mRxManager.clear();
    }

    /**
     * 判断是否登录
     *
     * @return
     */
    protected boolean isCheckedLogin() {
        UserInfo user = (UserInfo) GApp.getInstance().readObject(HttpUtils.USER_INFO);
        if (user == null || TextUtils.isEmpty(user.getUsername() + "")) {
            return false;
        }
        return true;
    }

     //更新fragment数据
    public void updata(Object obj,int type) {

    }
}
