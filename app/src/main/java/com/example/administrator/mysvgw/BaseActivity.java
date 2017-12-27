package com.example.administrator.mysvgw;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViews = new SparseArray<>();
        setContentView(getContetView());
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isFinishing()) {
            //如果activity还在执行,取消绑定，防止泄露
        }
    }
}
