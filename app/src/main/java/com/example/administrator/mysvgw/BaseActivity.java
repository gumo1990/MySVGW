package com.example.administrator.mysvgw;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.mysvgw.utils.CommonUtils;
import com.example.administrator.mysvgw.views.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by whq on 2017/12/25.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;

    protected abstract int getContetView();

    protected abstract void initViews();

    protected abstract void initData();

    public abstract void initListener();

    public abstract void proClick(View view);

    private SparseArray<View> mViews;
    public LoadingDialog weixinDialog;
    Unbinder bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViews = new SparseArray<>();
        setContentView(getContetView());
        bind = ButterKnife.bind(this);
        initViews();
        initData();
        initListener();


    }

    public BaseActivity() {
        this.mContext = this;
    }

    @Override
    public void onClick(View view) {
        proClick(view);
    }

    /**
     * 简化findViewById
     */
    @SuppressWarnings("unchecked")
    protected <E extends View> E getView(int viewId) {
        E view = (E) mViews.get(viewId);

        if (view == null) {
            view = (E) findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;

    }
    boolean isCancelable = false;

    public void setLoadingDialog(boolean isCancelable) {
        this.isCancelable = isCancelable;
    }

    public void loadingDialogs(final String msg) {
        // isLoading =true;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                weixinDialog = new LoadingDialog(BaseActivity.this);
                weixinDialog.setShowMsg(msg);
                weixinDialog.setCanceledOnTouchOutside(false);
                // 设置ProgressDialog 是否可以按退回键取消
                weixinDialog.setCancelable(isCancelable);

                if (!BaseActivity.this.isFinishing()) {
                    weixinDialog.show();
                }
            }
        });

    }

    public void cancelLoadingDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {//IllegalArgumentException
                try {
                    if (weixinDialog != null && weixinDialog.isShowing()) {
                        weixinDialog.cancel();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isFinishing()) {
            //如果activity还在执行,取消绑定，防止泄露
            bind.unbind();
        }
    }
    /**
     * 给单个Activity的顶部的View加宽，颜色通ActionBar，且不可修改
     * 有局限性，适合顶部有actionbar，非图片的Activity
     */

    protected void setImmerseLayout(View view, boolean type){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window window = getWindow();
           /* window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);*/
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);底部按钮透明设置

            if(type){
                int statusBarHeight = getStatusBarHeight(this.getBaseContext());
                ViewGroup.LayoutParams lp = view.getLayoutParams();
                lp.height += statusBarHeight;
                view.setLayoutParams(lp);
                view.setPadding(0, statusBarHeight, 0, 0);
            }
        }
    }
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceid = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceid > 0) {
            result = context.getResources().getDimensionPixelOffset(resourceid);
        }
        return result;
    }
}
