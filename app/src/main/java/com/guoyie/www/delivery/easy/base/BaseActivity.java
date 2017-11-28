package com.guoyie.www.delivery.easy.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.guoyie.www.delivery.easy.api.HttpUtils;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.entity.UserInfo;
import com.guoyie.www.delivery.easy.retrofit.RxManager;
import com.guoyie.www.delivery.easy.util.AppUtils;
import com.guoyie.www.delivery.easy.util.TUtil;
import com.guoyie.www.delivery.easy.widget.LightStatusBarUtils;
import com.umeng.analytics.MobclickAgent;

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {
    public    T                  mPresenter;
    public    E                  mModel;
    public    Context            mContext;
    public    RxManager          mRxManager;
    protected InputMethodManager manager;
   // protected ACache aCache;
    private   Toast              toast;

    protected <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    protected UserInfo userInfo;
    protected String uid = "";
    protected String company_id = "";
    protected int role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 日志是否加密
        MobclickAgent.enableEncrypt(false);
        // 捕获了错误和应用的异常处理
        MobclickAgent.setCatchUncaughtExceptions(true);
        //使用集成测试模式请先在程序入口处调用如下代码，打开调试模式
        MobclickAgent.setDebugMode(true);
        mRxManager = new RxManager();
        mContext = this;
        AppUtils.init(this);
        setContentView(getLayoutId());
        initStatusBar(false);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
      //  aCache = ACache.get(mContext);
        this.initPresenter();
        this.initView();
    }

    protected void initStatusBar(boolean isStatus) {
        LightStatusBarUtils.setLightStatusBar(this, isStatus);
    }

    /**
     * 启动相机
     */
    protected void startCamera() {

    }

    /**
     * 读取内存卡信息
     */
    protected void readSdCard() {

    }

    /**
     * 拨打电话权限
     */
    protected void callPhone() {

    }


    /*********************
     * 子类实现
     *****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();


    protected void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

    }

    protected void showShotToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);

        } else {
            toast.setText(msg);
        }
        toast.show();

    }


    /**
     * 防止连续点击跳转两个页面
     */
    protected long lastClickTime;

    protected boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 100) {
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
     * @Description: 进入到下个activity 带动画
     * @author luck
     */
    protected void startAnimAct(Class clz, int enterAnim, int exitAnim) {
        if (isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(mContext, clz);
        startActivity(intent);
        overridePendingTransition(enterAnim, exitAnim);
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
        overridePendingTransition(enterAnim, exitAnim);
        finish();
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
        Intent intent = new Intent(this, clz);
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
        Intent intent = new Intent(this, clz);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }


    /**
     * 隐藏软键盘
     */
    protected void hideKeyboard(EditText editText) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /**
     * 显示软键盘
     */
    protected void showKeyboard(EditText editText) {
        if (getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (getCurrentFocus() != null)
                manager.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
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


    /**
     * 针对6.0动态请求权限问题
     * 判断是否允许此权限
     *
     * @param permissions
     * @return
     */
    protected boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态请求权限
     *
     * @param code
     * @param permissions
     */
    protected void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case HttpUtils.READ_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readSdCard();
                } else {
                    showToast("读取内存卡权限已被拒绝");
                    readSdCard();
                }
                break;
            case HttpUtils.CAMERA:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startCamera();
                } else {
                    showToast("拍照权限已被拒绝");
                }
                break;
            case HttpUtils.CALL_PHONE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callPhone();
                } else {
                    showToast("拨打电话权限已被拒绝");
                }
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
