package com.example.administrator.mysvgw.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mysvgw.BaseFragment;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.bean.JsBridgeParam;
import com.example.administrator.mysvgw.utils.SystemHelper;
import com.example.administrator.mysvgw.views.MyBridgeWebViewClient;
import com.example.administrator.mysvgw.views.MyJsBridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by whq on 2017/12/26.
 */

public class HomeFragment extends BaseFragment{

    @BindView(R.id.webviewID)
    MyJsBridgeWebView mWebView;
    @BindView(R.id.rl_home_title)
    RelativeLayout rl_home_title;//一级rl

    @BindView(R.id.rl_second_sharetop)
    RelativeLayout rl_second_sharetop;//二级rl
    @BindView(R.id.iv_left)
    ImageView iv_left;//返回
    @BindView(R.id.tv_title)
    TextView tv_title;//title

    private ProgressBar mProgressBar;
    private String url;
    private HashMap<String, String> headMap = new HashMap<String, String>();

    private MyBridgeWebViewClient mBridgeWebViewClient;
    private boolean isSecond;//是否是二级页面
    String act;
    String stype = "0";
    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            act = bundle.getString("act");
        }
        url = "https://www.svgouwu.com/mobile/index.php?app=default&act=" + (act != null ? act : "index_ceshi_gb") + "&sv=app";
        mProgressBar = mWebView.getProgressBar();
        String verCode = SystemHelper.getAppVersionCode(getContext()) + "";
        headMap.put("version", verCode);
        headMap.put("client", "android");
        WebSettings settings = mWebView.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//根据屏幕缩放
        settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setAppCacheEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setUserAgentString(settings.getUserAgentString() + "[svgw,android," + verCode + "]");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebView.setDefaultHandler(new DefaultHandler());

        mWebView.setWebChromeClient(new HomeFragment.MyWebChromeClient());
        mBridgeWebViewClient = new MyBridgeWebViewClient(mWebView);
        mWebView.setWebViewClient(mBridgeWebViewClient);
        loadWebUrl();
    }

    @Override
    public void initListener() {
        mWebView.registerHandler("submitFromWeb", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {
                try {
                    function.onCallBack("submitFromWeb exe, response url 中文 from Java");
                    JsBridgeParam params = new Gson().fromJson(data, new TypeToken<JsBridgeParam>() {
                    }.getType());
                    Log.i("whq", "action: " + data);
                    if (params != null) {
                        if (("barcode").equals(params.action)) {
                           /* Intent loginIntent = new Intent(getActivity(), CaptureActivity.class);
                            startActivity(loginIntent);*/
                        } else if (("goodsDetail").equals(params.action)) {
                           /* HashMap<String, String> map = new HashMap<String, String>();
                            map.put("goodid", params.ref_id);
                            MobclickAgent.onEvent(getContext(), UmengStat.HOMEPAGETODETAILSCLICKNUMBER, map);
                            Intent intent2 = new Intent(getActivity(), GoodsDetailsWebView.class);
                            intent2.putExtra("url", URL_GOODS_DETAILS + params.ref_id);
                            intent2.putExtra("goodsId", params.ref_id);
                            startActivity(intent2);*/
                        } else if (("category").equals(params.action)) {
                          /*  MobclickAgent.onEvent(getContext(), UmengStat.HOMEPAGETOCLASSIFICATIONNUMBER);
                            Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                            intent.putExtra("category", params.ref_id);
                            getActivity().startActivity(intent);*/
                        } else if (("coupons").equals(params.action)) {
                          /*  MobclickAgent.onEvent(getContext(), UmengStat.HOMEPAGETOCLASSIFICATIONNUMBER);
                            Intent intent3 = new Intent(getActivity(), CouponsCenterActivity.class);
                            intent3.putExtra("coupons", "");
                            startActivity(intent3);*/
                        } else if (("searchIndex").equals(params.action)) {
                           /* Intent intent4 = new Intent(getContext(), CommonFragmentActivity.class);
                            intent4.putExtra(CommonFragmentActivity.TARGET, CommonFragmentActivity.FRAGMENT_SEARCH);
                            intent4.putExtra("searchIndex", "");
                            startActivity(intent4);*/
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.iv_left})
    @Override
    public void processClick(View view) {
        switch (view.getId()){
            case R.id.iv_left:
                //二级页面返回
                if (act != null) {
                    stype = "3";
                    mWebView.loadUrl("https://www.svgouwu.com/mobile/index.php?app=default&act=index_ceshi_gb&sv=app".trim(), headMap);
                } else {
                    mWebView.goBack();
                }
                break;
            default:
                break;
        }
    }
    private void loadWebUrl() {
        mWebView.loadUrl(url.trim(), headMap);
    }
    /**
     * webview加载状态
     */

    private class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            isSecond = mWebView.canGoBack();
         //   hidMenu();
            if (newProgress == 100) {
                mProgressBar.setVisibility(GONE);
            //    getShareUrl(mWebView.getUrl());
                if (act != null) {
                    if ("0".equals(stype)) {
                        showTopTitle(true);
                    } else {
                        showTopTitle(false);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                stype = "0";
                                if ("3".equals(stype)) {
                                    stype = "0";
                                }
                            }
                        }, 1000);
                    }

                } else {
                    showTopTitle(isSecond);
                }

            } else {
                if (mProgressBar.getVisibility() == GONE)
                    mProgressBar.setVisibility(VISIBLE);
                mProgressBar.setProgress(newProgress);

            }
            super.onProgressChanged(view, newProgress);

        }
    }
    /**
     * 首页和二级子页面展示头
     *
     * @param toptype
     */
    private void showTopTitle(boolean toptype) {
        if (toptype) {
            tv_title.setText("四维购物");
            rl_home_title.setVisibility(GONE);
            rl_second_sharetop.setVisibility(VISIBLE);

        } else {
            rl_home_title.setVisibility(VISIBLE);
            rl_second_sharetop.setVisibility(GONE);

        }
    }
}
