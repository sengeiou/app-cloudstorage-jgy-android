package com.guoyie.www.delivery.easy.activity;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.base.BaseActivity;
import com.guoyie.www.delivery.easy.databinding.ActivityCaBinding;
import com.guoyie.www.delivery.easy.util.Constant;

/**
 * author：柯军
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.activity
 * email：774169396@qq.com
 * data：2017/12/23
 */
public class CAActivity extends BaseActivity implements View.OnClickListener {

    private ActivityCaBinding binding;

    private ImageView left_back;
    private TextView    tv_title;


    @Override
    public int getLayoutId() {
        return R.layout.activity_ca;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());

        left_back = (ImageView) getView(R.id.left_back);
        tv_title = (TextView) getView(R.id.tv_title);
        tv_title.setText("CA详情");
        left_back.setOnClickListener(this);
        String ca_viewpath = getIntent().getStringExtra(Constant.TRANSSTOCK_CA_ID);
        WebSettings settings = binding.wvAgent.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        binding.wvAgent.loadUrl(ca_viewpath);

        //支持对字体的改变
        settings.setSupportZoom(true);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
         settings.setBuiltInZoomControls(true);// 显示缩放按钮(wap网页不支持)
         settings.setUseWideViewPort(true);// 支持双击缩放(wap网页不支持)
         settings.setJavaScriptEnabled(true);// 支持js功能
        //自适应屏幕
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);

        binding.wvAgent.setWebViewClient(new WebViewClient() {
            // 开始加载网页
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //   mWbvAgent.loadUrl(Constant.agent);
                System.out.println("开始加载网页了");
                binding.pbLoading.setVisibility(View.VISIBLE);
            }

            // 网页加载结束
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("网页加载结束" + url);
                binding.pbLoading.setVisibility(View.GONE);

            }

            // 所有链接跳转会走此方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("跳转链接:" + url);
                return true;

            }

            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // Handle the error
                //  view.loadUrl(TIME_OUT_PAGE);

                String data = "网络有异常请重试！";
                view.loadUrl("javascript:document.body.innerHTML=\"" + data + "\"");

            }

            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
                String data = "网络有异常请重试！";
                view.loadUrl("javascript:document.body.innerHTML=\"" + data + "\"");

            }


            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                // 不要使用super，否则有些手机访问不了，因为包含了一条 handler.cancel()
                 super.onReceivedSslError(view, handler, error);
                // 接受所有网站的证书，忽略SSL错误，执行访问网页
                handler.proceed();
                //默认的处理方式，WebView变成空白页
                //handler.cancel();
                // 其他处理
                //handleMessage(Message msg);
            }


        });


        binding.wvAgent.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                // 进度发生变化
                System.out.println("进度:" + newProgress);
            }


        });




    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回的按钮
            case R.id.left_back:
                finish();

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.wvAgent.removeAllViews();
        binding.wvAgent.stopLoading();
        binding.wvAgent.destroy();
    }

}
