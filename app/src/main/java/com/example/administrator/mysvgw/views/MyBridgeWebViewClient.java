package com.example.administrator.mysvgw.views;

import android.graphics.Bitmap;
import android.webkit.WebView;

import com.example.administrator.mysvgw.MyApplication;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.BridgeWebViewClient;

/**
 * Created by bruce on 10/28/15.
 */
public class MyBridgeWebViewClient extends BridgeWebViewClient {

    private static final String TAG = "MyBridgeWebViewClient";
    private String loginKey;
    private String curUrl;

    public MyBridgeWebViewClient(BridgeWebView webView) {
        super(webView);
        this.loginKey = MyApplication.getInstance().getLoginKey();
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        curUrl = url;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.startsWith("http")){
            view.loadUrl(url);
            return true;
        }
//        if (!KiliUtils.isEmpty(url) && !url.contains("&app_key=")) {
//            if (url.contains("?")) {
//                url += "&client=android&app_key=" + loginKey;
//            } else {
//                url += "?client=android&app_key=" + loginKey;
//            }
//        }
        return super.shouldOverrideUrlLoading(view, url);
    }

}