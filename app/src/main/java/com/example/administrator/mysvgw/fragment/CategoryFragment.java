package com.example.administrator.mysvgw.fragment;

import android.view.View;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.administrator.mysvgw.Api;
import com.example.administrator.mysvgw.BaseTopBarFragment;
import com.example.administrator.mysvgw.CommonCallback;
import com.example.administrator.mysvgw.R;
import com.example.administrator.mysvgw.views.LoadingPage;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.kili.okhttp.OkHttpUtils;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Request;

import static com.example.administrator.mysvgw.views.LoadingPage.LOADING;
import static com.example.administrator.mysvgw.views.LoadingPage.LOADING_NONET;

/**
 * Created by whq on 2017/12/26.
 * 分类页面
 */

public class CategoryFragment extends BaseTopBarFragment {

    @BindView(R.id.tv_cate_search)
    TextView tv_cate_search;
    @BindView(R.id.xv_cate_left)
    XRecyclerView xv_cate_left;//左侧rv
    @BindView(R.id.cb_cate)
    ConvenientBanner cb_cate;//广告位
    @BindView(R.id.xv_cate_right)
    XRecyclerView xv_cate_right;//右侧rv

    @BindView(R.id.loadpage)
    LoadingPage loadPage;//加载动画


    @Override
    protected int getContentView() {
        return R.layout.fragment_category;
    }

    @Override
    public void initViews() {
        loadPage.switchLoadingState(LOADING);
        mStatusBarView.setBackgroundResource(R.color.red);
        getCategoryInfo();
    }

    @Override
    public void initListener() {
        loadPage.setLoadinglistener(new LoadingPage.LoadingListener() {
            @Override
            public void onLoading() {
                loadPage.switchLoadingState(LOADING);
                //请求接口
                getCategoryInfo();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View view) {

    }

    /**
     * 获取分类页面信息
     */
    private void getCategoryInfo() {

        String url = Api.URL_CLASSIFY;
        OkHttpUtils.get().url(url).params(null).build().execute(new CommonCallback() {


            @Override
            public void onError(Call call, Exception e) {
                loadPage.switchLoadingState(LOADING_NONET);
            }

            @Override
            public void onResponse(Object response) {

            }
        });
    }


}
